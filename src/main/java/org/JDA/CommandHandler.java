package org.JDA;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

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


    private void handleCommandImbu(String command, MessageReceivedEvent event) {

        String commands = "!t3crit, dia\n!t3mana\n!t3hp";
        String help = "Wpisz !komenda, lista komend: !commands";
        String t3Crit = "Cena za stworzenie imbu 3 poziomu na obrażenia krytyczne, uwzględniając " +
                "aktualną cene imbu itemów, oraz koszt samego imbuy, na serwerze Dia wynosi: " + 285 + "k gp";

        String commandsImbuCalc = "";

        switch (command) {
            case "help":
                event.getChannel().sendMessage(help).queue();
                break;
            case "commands":
                event.getChannel().sendMessage(commands).queue();
                break;
            case "t3crit, dia":
                event.getChannel().sendMessage(t3Crit).queue();
                break;
            case "rope belt":
                event.getChannel().sendMessage("Cena rope beltów na serwerze Dia to: " + 1232).queue();
                break;

            default:
                event.getChannel().sendMessage("Unknown command. Try !hello or !ping.").queue();
        }
    }


    private void handleCommandItemsPrice(String command, MessageReceivedEvent event) {

        String helpCom = "Aby sprwadzić cene przedmiotu wpisz: [!nazwa_serwera, nazwa_przedmiotu] np. !dia, rope belt";


        String tmpServer = null;
        String tmpItemName = null;

        int commaPos = command.indexOf(',');

        if (commaPos != -1) {
            tmpServer = command.substring(0, commaPos).trim();
            tmpItemName = command.substring(commaPos+1).trim();
            event.getChannel().sendMessage("Cena za jedną sztukę " + tmpItemName + ", na sewerze " + tmpServer + ", wynosi: " + 2831 + " gold coin").queue();
        } else if (command.equals("help")) {
            event.getChannel().sendMessage(helpCom).queue();
        } else {
            event.getChannel().sendMessage("Unknown command. Try !help").queue();
        }


    }


}