package org.JDA;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.makeTableMethods.SelectInTable;

public class CommandHandler extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;


        if (event.getChannel().getId().equals("1133336606724595734")) {     // "ceny"
            handleCommandItemsPrice(createCommand(event.getMessage().getContentRaw()), event);
        } else if (event.getChannel().getId().equals("1133348555944366162")) {   // "imbu"
            handleCommandImbu(createCommand(event.getMessage().getContentRaw()), event);
        } else if (event.getChannel().getId().equals("1133305417838116876")) {   // "ogólny"
            handleCommand(createCommand(event.getMessage().getContentRaw()), event);
        }



    }


    private String createCommand(String message) {
        String command = "";
            if (message.startsWith("!")) {
                command = message.substring(1).toLowerCase();
            }
        return command;
    }

    private void handleCommand(String command, MessageReceivedEvent event) {

        String hello = "Zapraszam Cię na kanał 'ogólny', na kanale 'pl' porozmawiasz z innymi użytkownikami. \n" +
                "Możesz przejśc na kanał 'ceny', gdzie sprawdzisz cene dowolnego przedmiotu w Tibii \n" +
                "Możesz przejść na kanał 'kalkulator_imbu', gdzie sprawdzisz całkowitą cenę imbu, w oparciu o ceny itemów na twoim serwerze. \n" +
                "Jest to początkowa faza mojego projektu. \n" +
                "Rozgość się i czuj się jak u siebie :)";

        String commandsGeneral = "\n" +
                "!hello \n" +
                "!commands";


        switch (command) {
            case "hello":
                event.getChannel().sendMessage("Witaj, " + event.getAuthor().getAsMention() + "! \n" + hello).queue();
                break;
            case "commands":
                event.getChannel().sendMessage("Lista komend: " + commandsGeneral).queue();
                break;
            default:
                event.getChannel().sendMessage("Unknown command. Try !hello or !commands.").queue();
        }
    }



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

    private void handleCommandItemsPrice(String command, MessageReceivedEvent event) {

        String helpCom = "Aby sprwadzić cene przedmiotu wpisz: [!nazwa_serwera, nazwa_przedmiotu] np. !dia, rope belt" +
                "\n Możesz wpisać także [!nazwa_serwera, {crit, mana, hp}] np. !dia, mana, aby wyświetlić ceny przedmiotów do danego imbuingu";


        String tmpServer = null;
        String tmpItemName = null;
        int tmpItemPrice = 0;

        int commaPos = command.indexOf(',');

        if (commaPos != -1) {
            tmpServer = command.substring(0, commaPos).trim();
            tmpItemName = command.substring(commaPos+1).trim();
            System.out.println(tmpItemName);

            if (tmpItemName.equals("crit")) {

                String message = "Serwer:  " + tmpServer + "\n";

                for (int i = 6; i <= 8; i++) {
                    tmpItemPrice = getPriceFromDB(tmpServer, itemNames[i]);
                    message += itemNames[i] + ": " + tmpItemPrice + " gp \n";
                }
                event.getChannel().sendMessage(message).queue();

            } else if (tmpItemName.equals("mana")) {

                String message = "Serwer:  " + tmpServer + "\n";

                for (int i = 3; i <= 5; i++) {
                    tmpItemPrice = getPriceFromDB(tmpServer, itemNames[i]);
                    message += itemNames[i] + ": " + tmpItemPrice + " gp \n";
                }
                event.getChannel().sendMessage(message).queue();

            } else if (tmpItemName.equals("hp")) {

                String message = "Serwer:  " + tmpServer + "\n";

                for (int i = 0; i <= 2; i++) {
                    tmpItemPrice = getPriceFromDB(tmpServer, itemNames[i]);
                    message += itemNames[i] + ": " + tmpItemPrice + " gp \n";
                }
                event.getChannel().sendMessage(message).queue();

            } else {
                tmpItemPrice = getPriceFromDB(tmpServer, tmpItemName);
                event.getChannel().sendMessage("Cena za jedną sztukę " + tmpItemName + ", na sewerze " + tmpServer + ", wynosi: " + tmpItemPrice + " gold coin").queue();
            }

        } else if (command.equals("help")) {
            event.getChannel().sendMessage(helpCom).queue();
        } else {
            event.getChannel().sendMessage("Unknown command. Try !help").queue();
        }


    }


    private void handleCommandImbu(String command, MessageReceivedEvent event) {

        String commands = "Aby sprwadzić całkowitą cenę imbuingu wpisz: [!nazwa_serwera, nazwa_imbu, poziom_imbu] np. !dia, rope belt";


        String help = "Wpisz !komenda, lista komend: !commands";

        String t3Crit = "Cena za stworzenie imbu 3 poziomu na obrażenia krytyczne, uwzględniając " +
                "aktualną cene imbu itemów, oraz koszt samego imbu, na serwerze Dia wynosi: " + 285 + "k gp";

        String commandsImbuCalc = "";











        switch (command) {
            case "help":
                event.getChannel().sendMessage(help).queue();
                break;
            case "commands":
                event.getChannel().sendMessage(commands).queue();
                break;
            case "dia, t3crit":
                event.getChannel().sendMessage(t3Crit).queue();
                break;
            case "rope belt":
                event.getChannel().sendMessage("Cena rope beltów na serwerze Dia to: " + 1232).queue();
                break;

            default:
                event.getChannel().sendMessage("Unknown command. Try !hello or !ping.").queue();
        }
    }


    public int getPriceFromDB(String Server, String item) {
        SelectInTable select = new SelectInTable();
        int tmpItemPrice = select.selectPrice(Server, item);
        select.closeConnection();
        return tmpItemPrice;
    }




}