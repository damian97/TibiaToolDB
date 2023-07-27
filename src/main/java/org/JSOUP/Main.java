package org.JSOUP;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String imbuNamesTable = "{";
        char quote = '"';

        Connection connection = Jsoup.connect("https://tibia.fandom.com/wiki/Imbuing");
        Document document = connection.get();
//        Elements imbuNames = document.select("a[href]");

        Elements tables = document.select("table");

        for (Element table : tables) {
            Elements rows = table.select("tr"); // Znajdź wszystkie wiersze tabeli

            for (int i = 0; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements columns = row.select("td"); // Znajdź wszystkie komórki (kolumny) w bieżącym wierszu

                for (int j = 0; j < columns.size(); j++) {
                    Element column = columns.get(j);
                    String cellData = column.text(); // Pobierz dane z komórki (tekst)
                    if (i + 1 == 2 && j + 1 == 1 && cellData.startsWith("Basic")) {
                        imbuNamesTable += quote + cellData.substring(6) + quote + ", ";
                    }
                }
            }

        }

        imbuNamesTable = imbuNamesTable.substring(0, imbuNamesTable.length()-2);
        imbuNamesTable += "};";

        System.out.println(imbuNamesTable.toString());

    }

}
