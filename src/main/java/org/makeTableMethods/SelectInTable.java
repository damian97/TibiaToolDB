package org.makeTableMethods;


import java.sql.*;

public class SelectInTable {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    private static final String DATABASE_NAME = "imbu_items";
    private String url = "jdbc:mysql://127.0.0.1:3306/" + DATABASE_NAME;

    private String sql;
    private String tmpItemName;
    private int tmpItemPrice;



    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getTmpItemName() {
        return tmpItemName;
    }

    public void setTmpItemName(String tmpItemName) {
        this.tmpItemName = tmpItemName;
    }

    public int getTmpItemPrice() {
        return tmpItemPrice;
    }

    public void setTmpItemPrice(int tmpItemPrice) {
        this.tmpItemPrice = tmpItemPrice;
    }


    public SelectInTable() {

        try {

            connection = DriverManager.getConnection(url, "root", "");

            if (connection != null) {

                statement = connection.createStatement();


            } else {
                System.err.println("Brak połączenia");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public int selectPrice(String serverName, String itemName) {

        setSql("SELECT `price` FROM `" + serverName + "` WHERE name = '" + itemName + "'");

        int resultPrice = -1;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getSql());

            if (resultSet.next()) {
                resultPrice = resultSet.getInt("price");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultPrice;
    }




    public void closeConnection() {

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
