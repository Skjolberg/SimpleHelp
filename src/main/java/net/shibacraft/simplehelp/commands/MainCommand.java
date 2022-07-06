package net.shibacraft.simplehelp.commands;

import net.shibacraft.simplehelp.files.FileManager;
import net.shibacraft.simplehelp.files.messages.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommand implements CommandExecutor {

    private final FileManager fileManager;

    public MainCommand(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command main, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                fileManager.reload();
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