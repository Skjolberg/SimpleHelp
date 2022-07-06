package net.shibacraft.simplehelp.api.banner;

import net.shibacraft.simplehelp.SimpleHelp;
import net.shibacraft.simplehelp.api.loader.Loader;
import net.shibacraft.simplehelp.api.logger.CoreLogger;

public class Banner implements Loader {

    private final SimpleHelp plugin;

    public Banner(SimpleHelp plugin) {
        this.plugin = plugin;
    }

    @Override
    public void load() {
        CoreLogger.log("&5Plugin: &e" + plugin.getName());
        CoreLogger.log("&fAuthor: &e" + plugin.getDescription().getAuthors().get(0));
        CoreLogger.log("&fVersion: &e" + plugin.getDescription().getVersion());
        CoreLogger.log("&fDownload in :&ehttps://www.spigotmc.org/resources/simplehelp.101502/");
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }

}
