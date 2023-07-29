package org.JDA;

import org.makeTableMethods.SelectInTable;

public class ImbuCalculator extends CommandManagement{

    private static final int[] LVL_IMBU_PRICE = {15_000, 50_000, 150_000};

    private  int totalPrice = 0;

    public ImbuCalculator(String serverName, String lvlImbuing, String nameImbu) {
        super(serverName, lvlImbuing, nameImbu);
    }

    public int calculatePrice() {

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


        String tmpServer = this.getServerName();
        String tmpImbu = this.getNameImbu();
        int tmpItemAmount;
        int tmpItemPrice;
        int result = 0;
        int tmpImbuLvl = Integer.parseInt(this.getLvlImbuing().substring(1));

        int start = 0, stop = 0;

        switch (tmpImbu) {
            case "crit" :
                start = 6;
                stop = 8;
                break;
            case "mana" :
                start = 3;
                stop = 5;
                break;
            case "hp" :
                stop = 2;
                break;

        }


        // Operacje w zaleznosci od poziomu imbu

        for (int i = start ; i <= stop; i++) {
            tmpItemPrice = getPriceFromDB(tmpServer, itemNames[i]);
            tmpItemAmount = getAmountFromDB(tmpServer, itemNames[i]);
            result += tmpItemPrice * tmpItemAmount;
        }

        System.out.println("Cena za itemy: " + result);

        switch (tmpImbuLvl) {
            case 1 :
                result += LVL_IMBU_PRICE[0];
                break;
            case 2 :
                result += LVL_IMBU_PRICE[1];
                break;
            case 3 :
                result += LVL_IMBU_PRICE[2];
                break;
        }
        System.out.println("Cena za itemy plus koszt: " + result);


        return result;
    }



    @Override
    public String toString() {
        return "CommandManagement{" +
                "serverName='" + this.getServerName() + '\'' +
                ", itemName='" + this.getItemName() + '\'' +
                ", itemPrice=" + this.getItemPrice() +
                ", lvlImbuing='" + this.getLvlImbuing() + '\'' +
                ", nameImbu='" + this.getNameImbu() + '\'' +
                '}' + "ImbuCalculator{" +
                "totalPrice=" + totalPrice +
                '}';

    }


    public int getAmountFromDB(String Server, String item) {
        SelectInTable select = new SelectInTable();
        int tmpItemAmount = select.selectItemAmount(Server, item);
        select.closeConnection();
        return tmpItemAmount;
    }

    public int getPriceFromDB(String Server, String item) {
        SelectInTable select = new SelectInTable();
        int tmpItemPrice = select.selectPrice(Server, item);
        select.closeConnection();
        return tmpItemPrice;
    }


}
