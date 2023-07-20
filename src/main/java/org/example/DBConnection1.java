package org.example;

import java.sql.*;

public class DBConnection1 {

    private String login = "root";
    private String pass = "";
    private String url = "jdbc:mysql://127.0.0.1:3306/";

    private String dbName;
    private String tbName;

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;


    public void connectToDB(String databaseName, String tableName, Inquiry inquiry) {

        dbName = databaseName;
        tbName = tableName;


        try {
            connection = DriverManager.getConnection(url + databaseName, login, pass);

            if (connection == null) {
                System.out.println("No connection to db");
            } else {
                System.out.println("Connection to db exist");
            }


            select();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
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


    public void select() {


        try {
            statement = connection.createStatement();

        String sql = "SELECT * FROM " + tbName;

        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("Login:" + resultSet.getString("login") + " Pass: " + resultSet.getString("password"));
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
