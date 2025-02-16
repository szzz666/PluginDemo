package top.szzz666.nukkit_plugin.config;


import static top.szzz666.nukkit_plugin.Main.ec;
import static top.szzz666.nukkit_plugin.Main.plugin;

public class MyConfig {
    public static void initConfig() {
        ec = new EasyConfig("config.yml", plugin);
        ec.add("reloadCommand", "pdreload");
        ec.load();
    }

}
