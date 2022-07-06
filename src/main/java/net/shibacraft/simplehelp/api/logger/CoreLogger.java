package net.shibacraft.simplehelp.api.logger;

import net.shibacraft.simplehelp.SimpleHelp;
import net.shibacraft.simplehelp.api.chat.TextColor;
import org.bukkit.Bukkit;

public class CoreLogger {


    private static final String LOGGER_NAME = "&d&lSimpleHelp";
    private static final SimpleHelp simpleHelp = SimpleHelp.getPlugin();

    public static void warn(String message) {
        simpleHelp.getLogger().warning(LOGGER_NAME + " | " + message);
    }

    public static void severe(String message) {
        simpleHelp.getLogger().severe(LOGGER_NAME + " | " + message);
    }

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(TextColor.color(LOGGER_NAME + "&8 | &r" + message));
    }

}
