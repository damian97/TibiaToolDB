package org.makeTableMethods;

import java.sql.*;

public class InsertItemsToTable {

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


        String[] itemNames = {
                "vampire teeth",
                "bloody pincers",
                "piece of dead brain",
                "rope belt",
                "silencer claws",
                "some grimeleech wings",
                "protective charm",
                "sabretooth",
                "vexclaw talon"
        };


        int[] itemQuantities = {
                25,
                15,
                5,
                25,
                25,
                5,
                20,
                25,
                5
        };



        Connection connection;
        Statement statement;

        String url = "jdbc:mysql://127.0.0.1:3306/" + DATABASE_NAME;


        connection = DriverManager.getConnection(url, "root", "");

        if (connection != null) {


            statement = connection.createStatement();


            for (int j = 0; j < serverNames.length; j++) {
                for (int i = 0; i < itemNames.length; i++) {
                    String itemName = itemNames[i];
                    int amount = itemQuantities[i];

                    String sql = "INSERT INTO " + serverNames[j] + " (id, name, price, amount) VALUES "
                            + " (" + (1 + i) + ",'" + itemName + "', 1, " + amount + ")";

                    statement.executeUpdate(sql);
                }
                System.out.println("Dodaje rekordy do tabeli: " + serverNames[j]);
            }

        } else {
            System.err.println("Brak połączenia");
        }


    }
}
