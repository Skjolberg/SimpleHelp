package net.shibacraft.simplehelp.module;

import net.shibacraft.simplehelp.SimpleHelp;
import net.shibacraft.simplehelp.api.banner.Banner;
import net.shibacraft.simplehelp.api.logger.CoreLogger;
import net.shibacraft.simplehelp.files.FileManager;
import net.shibacraft.simplehelp.api.loader.Loader;

public class MainModule implements Loader {

    private final SimpleHelp plugin;

    public MainModule(SimpleHelp plugin) {
        this.plugin = plugin;
    }

    @Override
    public void load() {
        Banner banner = new Banner(plugin);
        banner.load();
        FileManager fileManager = new FileManager(plugin);
        fileManager.load();
        CommandModule commandModule = new CommandModule(plugin, fileManager);
        commandModule.load();

    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }
}
