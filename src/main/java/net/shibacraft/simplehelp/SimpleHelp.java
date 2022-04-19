package net.shibacraft.simplehelp;

import lombok.Getter;
import net.shibacraft.simplehelp.api.loader.Loader;
import net.shibacraft.simplehelp.module.MainModule;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleHelp extends JavaPlugin {

    @Getter
    static SimpleHelp plugin;
    private Loader loader;

    @Override
    public void onEnable() {
        SimpleHelp.plugin = this;
        loader = new MainModule(this);
        loader.load();

    }

    @Override
    public void onDisable() {
        loader.unload();
    }

}
