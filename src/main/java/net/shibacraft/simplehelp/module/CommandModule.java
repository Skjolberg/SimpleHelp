package net.shibacraft.simplehelp.module;

import net.shibacraft.simplehelp.SimpleHelp;
import net.shibacraft.simplehelp.SimpleHelpCompletion;
import net.shibacraft.simplehelp.api.loader.Loader;
import net.shibacraft.simplehelp.commands.HelpCommand;
import net.shibacraft.simplehelp.commands.MainCommand;

public class CommandModule implements Loader {

    SimpleHelp plugin;

    public CommandModule(SimpleHelp plugin){
        this.plugin = plugin;
    }

    @Override
    public void load() {
        plugin.getCommand("SimpleHelp").setExecutor(new MainCommand(plugin));
        plugin.getCommand("SimpleHelp").setTabCompleter(new SimpleHelpCompletion());
        plugin.getCommand("SimpleHelp").setPermission("simplehelp.admin");
        plugin.getCommand("Help").setExecutor(new HelpCommand());
        plugin.getCommand("Help").setPermission("simplehelp.user");
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }
}
