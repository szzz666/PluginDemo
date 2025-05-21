package top.szzz666.nukkit_plugin.config;


import static top.szzz666.nukkit_plugin.Main.ConfigPath;
import static top.szzz666.nukkit_plugin.Main.ec;

public class MyConfig {
    public static void initConfig() {
        ec = new EasyConfig(ConfigPath + "/config.yml");
        ec.add("command", "pd");
        ec.load();
    }

}
