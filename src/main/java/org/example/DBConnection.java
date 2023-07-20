package org.example;

import java.sql.*;

public class DBConnection {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private String login = "root";
    private String pass = "";
    private String url = "jdbc:mysql://127.0.0.1:3306/";


    public boolean connectToDB(String databaseName) {


        try {

            connection = DriverManager.getConnection(url + databaseName, login, pass);

            if (connection != null) {
                System.out.println("Jest połączenie");
            } else {
                System.out.println("Brak połączenia z db");
                closeConnection();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeConnection();
        return true;

    }



    public void closeConnection() {

        try {
            resultSet.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
