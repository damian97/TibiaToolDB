package org.JDA;

public class ImbuCalculator extends CommandManagement{

    private static final int[] LVL_IMBU_PRICE = {15_000, 50_000, 150_000};

    private  int totalPrice = 0;

    public ImbuCalculator(String serverName, String lvlImbuing, String nameImbu) {
        super(serverName, lvlImbuing, nameImbu);
    }

    public int calculatePrice() {


        // W tym miejscu logika liczenia ceny imbu



        return totalPrice;
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

}
