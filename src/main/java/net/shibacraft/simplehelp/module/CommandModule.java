package net.shibacraft.simplehelp.module;

import net.shibacraft.simplehelp.SimpleHelp;
import net.shibacraft.simplehelp.SimpleHelpCompletion;
import net.shibacraft.simplehelp.api.loader.Loader;
import net.shibacraft.simplehelp.commands.HelpCommand;
import net.shibacraft.simplehelp.commands.MainCommand;
import net.shibacraft.simplehelp.files.FileManager;

public class CommandModule implements Loader {

    private final SimpleHelp plugin;
    private final FileManager fileManager;

    public CommandModule(SimpleHelp plugin, FileManager fileManager) {
        this.plugin = plugin;
        this.fileManager = fileManager;
    }

    @Override
    public void load() {
        plugin.getCommand("SimpleHelp").setExecutor(new MainCommand(fileManager));
        plugin.getCommand("SimpleHelp").setTabCompleter(new SimpleHelpCompletion());
        plugin.getCommand("SimpleHelp").setPermission("simplehelp.admin");
        plugin.getCommand("Help").setExecutor(new HelpCommand(fileManager));
        plugin.getCommand("Help").setPermission("simplehelp.user");
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }
}
