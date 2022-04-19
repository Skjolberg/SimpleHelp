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
        CoreLogger.info("&5Plugin: &e" + plugin.getName());
        CoreLogger.info("&fAuthor: &e" + plugin.getDescription().getAuthors().get(0));
        CoreLogger.info("&fVersion: &e" + plugin.getDescription().getVersion());
        CoreLogger.info("&fDownload in :&e");
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }

}
