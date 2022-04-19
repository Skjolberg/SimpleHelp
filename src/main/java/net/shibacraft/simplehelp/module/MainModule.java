package net.shibacraft.simplehelp.module;

import net.shibacraft.simplehelp.SimpleHelp;
import net.shibacraft.simplehelp.api.banner.Banner;
import net.shibacraft.simplehelp.files.FileManager;
import net.shibacraft.simplehelp.api.loader.Loader;

public class MainModule implements Loader {

    private final SimpleHelp plugin;

    public MainModule(SimpleHelp plugin) {
        this.plugin = plugin;
    }

    @Override
    public void load() {
        Loader loader = new Banner(plugin);
        loader.load();
        loader = new FileManager(plugin);
        loader.load();
        loader = new CommandModule(plugin);
        loader.load();

    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }
}
