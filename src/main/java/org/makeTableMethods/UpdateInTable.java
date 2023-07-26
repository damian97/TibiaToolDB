package org.makeTableMethods;

import java.sql.*;

public class UpdateInTable {

    private Connection connection = null;
    private Statement statement = null;


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


    public UpdateInTable() {

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


    public void updatePrice(String serverName, String itemName, int price) {

        setSql("UPDATE " + serverName + " SET price = "+ price +" WHERE name = '" + itemName + "'");
        try {
            statement.executeUpdate(getSql());
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
