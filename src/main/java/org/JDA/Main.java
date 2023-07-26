package org.JDA;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class Main {

    public static void main(String[] args) {

        String token = "MTEzMjY5MTcyOTIyOTgxOTk1OA.GHvtr_.GgLA8aF_LdWgHPCfYXBH7p_UVdzWAgHvwzaVZY";

        JDA jda = JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new CommandHandler())
                .build();

    }

}
