package org.makeTableMethods;

import java.sql.*;
import java.util.ArrayList;

public class CreateServerTables {

    private static final String DATABASE_NAME = "imbu_items";


    public static void main(String[] args) throws SQLException {


        String[] serverNames = {
                "Adra", "Alumbra", "Antica", "Ardera", "Astera", "Axera", "Bastia", "Batabra", "Belobra", "Bombra",
                "Bona", "Cadebra", "Calmera", "Castela", "Celebra", "Celesta", "Collabra", "Damora", "Descubra",
                "Dia", "Dibra", "Epoca", "Esmera", "Etebra", "Famosa", "Fera", "Ferobra", "Firmera", "Gentebra",
                "Gladera", "Gravitera", "Harmonia", "Havera", "Honbra", "Illusera", "Impulsa", "Inabra", "Issobra",
                "Jacabra", "Kalibra", "Kardera", "Karna", "Libertabra", "Lobera", "Luminera", "Lutabra", "Marbera",
                "Marcia", "Menera", "Monza", "Mudabra", "Mykera", "Nadora", "Nefera", "Nossobra", "Ocebra", "Olima",
                "Ombra", "Optera", "Ousabra", "Pacera", "Peloria", "Premia", "Quelibra", "Quintera", "Refugia",
                "Reinobra", "Seanera", "Secura", "Serdebra", "Solidera", "Suna", "Syrena", "Talera", "Tembra",
                "Thyria", "Trona", "Utobra", "Venebra", "Versa", "Visabra", "Vitera", "Vunira", "Wintera",
                "Wizera", "Xandebra", "Yonabra", "Zenobra", "Zuna", "Zunera"
        };

        ArrayList<String> serverExist = new ArrayList<>();

        Connection connection;
        Statement statement;

        String url = "jdbc:mysql://127.0.0.1:3306/" + DATABASE_NAME;

        connection = DriverManager.getConnection(url, "root", "");

        if (connection != null) {


            //

            String sqlTableName = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'imbu_items'";

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlTableName);

            while (resultSet.next()) {
                serverExist.add(resultSet.getString("table_name"));
            }


            // wykonaj operacje


            int j = 0;

            for (int i = 0; i < serverNames.length; i++) {

                String tmpServerName = serverNames[i].toLowerCase();

                if (!serverExist.contains(tmpServerName)) {

                    String sql = "CREATE TABLE " + tmpServerName + "("
                            + " id INT AUTO_INCREMENT PRIMARY KEY,"
                            + " name varchar(25),"
                            + " price varchar(25),"
                            + " amount varchar(25)"
                            + ");";

                    statement.executeUpdate(sql);

                    System.out.println("Dodano " + tmpServerName);
                    j++;

                } else {
                    System.out.println(tmpServerName + " już istnieje w bazie danych");
                }
            }

            System.out.println("Dodano rekordów: " + j);

        } else {
            System.err.println("Brak połączenia");
        }



    }
}
