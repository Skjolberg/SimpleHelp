package net.shibacraft.simplehelp.commands;

import net.shibacraft.simplehelp.SimpleHelp;
import net.shibacraft.simplehelp.api.loader.Loader;
import net.shibacraft.simplehelp.files.FileManager;
import net.shibacraft.simplehelp.files.messages.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    private final SimpleHelp plugin;
    Loader loader;

    public MainCommand(SimpleHelp plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command main, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                loader = new FileManager(plugin);
                loader.reload();
                sender.sendMessage(Messages.RELOAD.get());
            } else {
                sender.sendMessage(Messages.INVALID_ARGUMENT.get());
            }
        } else {
            sender.sendMessage(Messages.INVALID_ARGUMENT.get());
        }
        return true;
    }
}