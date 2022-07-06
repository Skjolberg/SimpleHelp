package net.shibacraft.simplehelp.commands;

import de.leonhard.storage.Yaml;
import net.shibacraft.simplehelp.api.chat.TextColor;
import net.shibacraft.simplehelp.files.FileManager;
import net.shibacraft.simplehelp.files.messages.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class HelpCommand implements CommandExecutor {

    private final Yaml ayudaFile;

    public HelpCommand(FileManager fileManager) {
        this.ayudaFile = fileManager.getYaml("Config");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command help, String label, String[] args) {

        List<String> sectionList;

        if (args.length > 0) {
            if (ayudaFile.contains(args[0]) && args.length == 1) {
                sectionList = ayudaFile.getStringList(args[0]);
                for (String i : sectionList) {
                    sender.sendMessage(TextColor.color(i));
                }
            } else {
                sender.sendMessage(Messages.INVALID_ARGUMENT.get());
            }
        } else {
            sectionList = ayudaFile.getStringList("1");
            for (String i : sectionList) {
                sender.sendMessage(TextColor.color(i));
            }
        }
        return true;
    }

}
