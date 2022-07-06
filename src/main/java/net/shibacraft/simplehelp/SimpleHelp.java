package net.shibacraft.simplehelp;

import net.shibacraft.simplehelp.module.MainModule;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleHelp extends JavaPlugin {

    public static SimpleHelp plugin;
    private MainModule mainModule;

    @Override
    public void onEnable() {
        SimpleHelp.plugin = this;
        mainModule = new MainModule(plugin);
        mainModule.load();

    }

    @Override
    public void onDisable() {
        mainModule.unload();
    }

    public static SimpleHelp getPlugin(){
        return plugin;
    }

}
