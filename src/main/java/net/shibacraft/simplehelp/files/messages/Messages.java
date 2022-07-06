package net.shibacraft.simplehelp.files.messages;

import de.leonhard.storage.Yaml;
import net.shibacraft.simplehelp.api.chat.TextColor;
import net.shibacraft.simplehelp.files.FileManager;


public enum Messages {

    PREFIX("PREFIX", "&8[&dSimpleDropInventory&8]&r "),
    INVALID_ARGUMENT("INVALID_ARGUMENT", "&cThe argument is Invalid."),
    NO_PERMISSION("NO_PERMISSION", "&cYou do not have permission to do this."),
    RELOAD("RELOAD", "&aPlugin reloaded!");

    private final String path;

    private String value;

    private static boolean Prefix = true;

    public String get() {
        return Prefix ? TextColor.color(PREFIX.getValue() + this.value) : TextColor.color(this.value);
    }

    Messages(String path, String value) {
        this.path = path;
        this.value = value;
    }

    public static void load() {

        Yaml messagesFile = FileManager.getFileManager().getYaml("Messages");

        Prefix = !messagesFile.getString("PREFIX").isEmpty();

        for (Messages msg : values()) {

            if (!messagesFile.contains(msg.getPath())) {
                messagesFile.set(msg.getPath(), msg.getValue());
                continue;
            }

            String str = messagesFile.getString(msg.getPath());
            msg.setValue(str);
        }

    }

    public String getPath() {
        return this.path;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isPrefix() {
        return Prefix;
    }

}
