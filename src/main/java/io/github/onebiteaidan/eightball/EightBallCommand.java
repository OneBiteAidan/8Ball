package io.github.onebiteaidan.eightball;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EightBallCommand implements CommandExecutor {

    private final Eightball main;

    public EightBallCommand(Eightball main) {
        this.main = main;
    }

    public static String colorize(String message)
    {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("8ball.use")) {
                String prompt = String.join(" ", args); //Uses args as a place for fortune prompt.
                List<String> responses = main.getConfig().getStringList("Responses"); //Initializing the list

                Random r = new Random();
                int index = r.nextInt(responses.size());
                String response = responses.get(index);

                //Print response
                player.sendMessage(colorize("&7The great &5&l8BALL &r&7has heard your question..."));
                player.sendMessage(colorize(""));
                player.sendMessage(colorize("&e'" + prompt + "'"));
                player.sendMessage(colorize(""));
                player.sendMessage(colorize("&7...here is their conclusion."));
                player.sendMessage(colorize("&5" + response));
                }
            }
        return false;
    }
}
