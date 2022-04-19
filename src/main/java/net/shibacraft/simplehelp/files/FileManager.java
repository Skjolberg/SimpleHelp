package net.shibacraft.simplehelp.files;


import de.leonhard.storage.Yaml;
import de.leonhard.storage.internal.settings.ConfigSettings;
import de.leonhard.storage.internal.settings.DataType;
import de.leonhard.storage.internal.settings.ReloadSettings;
import lombok.Getter;
import net.shibacraft.simplehelp.SimpleHelp;
import net.shibacraft.simplehelp.api.loader.Loader;
import net.shibacraft.simplehelp.files.messages.Messages;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileManager implements Loader {

    private static SimpleHelp plugin;

    @Getter
    private static final Map<String, Yaml> filesYaml = new HashMap<>();
    private static final Set<String> filesCheck = new HashSet<>();

    public FileManager(SimpleHelp plugin) {
        FileManager.plugin = plugin;
    }


    @Override
    public void load() {

        filesCheck.add("Messages.yml");
        filesCheck.add("Help.yml");
        checkFiles(filesCheck);
        filesCheck.clear();

        filesYaml.put("Messages", new Yaml("Messages.yml", plugin.getDataFolder().getPath()));
        Messages.load();
        filesYaml.put("Help", new Yaml("Help.yml", plugin.getDataFolder().getPath(), null,
                ReloadSettings.INTELLIGENT, ConfigSettings.PRESERVE_COMMENTS, DataType.SORTED));
    }

    @Override
    public void unload() {
        filesYaml.clear();
        filesCheck.clear();
    }

    @Override
    public void reload() {
        filesYaml.get("Messages").forceReload();
        filesYaml.get("Help").forceReload();
    }

    public static void createFileIfNotExists(String file){
        File fileCheck = new File(plugin.getDataFolder(), file);

        if (!fileCheck.exists()) {
            plugin.saveResource(file, false);
        }
    }

    public static void checkFiles(Set<String> filesCheck){

        for (String file : filesCheck) {
            createFileIfNotExists(file);
        }

    }
}
