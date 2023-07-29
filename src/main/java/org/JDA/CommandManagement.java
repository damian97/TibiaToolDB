package org.JDA;

import java.util.Arrays;

public class CommandManagement {

    private static final String[] SERVERS_NAME = {
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

    private static final String[] LEVEL_IMBUING = {"t1", "t2", "t3"};   // Basic, Intricate, Powerful

    private static final String[] LIST_OF_IMBUEMENTS = {"Scorch", "Venom", "Frost", "Electrify", "Reap", "Vampirism", "Void", "Strike", "Lich Shroud", "Snake Skin", "Dragon Hide", "Quara Scale", "Cloud Fabric", "Demon Presence", "Vibrancy", "Swiftness", "Featherweight", "Chop", "Slash", "Bash", "Precision", "Blockade", "Epiphany", "crit", "mana", "hp"};

    private String serverName;
    private String itemName;
    private int itemPrice;
    private String lvlImbuing;
    private String nameImbu;


    public CommandManagement() {
    }

    public CommandManagement(String serverName, String nameImbu, String lvlImbuing) {
        this.serverName = serverName;
        this.lvlImbuing = lvlImbuing;
        this.nameImbu = nameImbu;
    }

    @Override
    public String toString() {
        return "CommandManagement{" +
                "serverName='" + serverName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", lvlImbuing='" + lvlImbuing + '\'' +
                ", nameImbu='" + nameImbu + '\'' +
                '}';
    }

    public boolean checkCommand(String command) {

        boolean trueServer = false, trueImbuLvl = false, trueImbuName = false;

        String[] tmpComamndTable = command.split(", ");

        String part1 = tmpComamndTable[0];
        String part2 = tmpComamndTable[1];
        String part3 = tmpComamndTable[2];

        for (int i = 0; i < SERVERS_NAME.length; i++) {
            String nextServerName = SERVERS_NAME[i].toLowerCase();
            if (part1.equals(nextServerName)) {
//                System.out.println("Doszedłem do servera w tablicy: " + "iteracja: " + i + "  " + nextServerName);
                serverName = nextServerName;
                trueServer = true;
                break;
            }
        }


        for (int k = 0; k < LIST_OF_IMBUEMENTS.length; k++) {
            String imbuName = LIST_OF_IMBUEMENTS[k];
            if (part2.equals(imbuName)) {
                nameImbu = imbuName;
                trueImbuName = true;
                break;
            }

        }


        for (int j = 0; j < LEVEL_IMBUING.length; j++) {
            String lvlImbu = LEVEL_IMBUING[j].toLowerCase();
            if (part3.equals(lvlImbu)) {
                lvlImbuing = lvlImbu;
                trueImbuLvl = true;
                break;
            }
        }


        return trueServer && trueImbuName && trueImbuLvl;

    }


    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getLvlImbuing() {
        return lvlImbuing;
    }

    public void setLvlImbuing(String lvlImbuing) {
        this.lvlImbuing = lvlImbuing;
    }

    public String getNameImbu() {
        return nameImbu;
    }

    public void setNameImbu(String nameImbu) {
        this.nameImbu = nameImbu;
    }
}
