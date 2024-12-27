package top.szzz666.PluginDemo.config;

import cn.nukkit.utils.Config;

import static top.szzz666.PluginDemo.PluginDemoMain.ConfigPath;
import static top.szzz666.PluginDemo.PluginDemoMain.plugin;

public class MyConfig {
    public static String CommandName = "mycommand";

    public static boolean loadConfig() {
        plugin.saveResource("config.yml");
        Config config = new Config(ConfigPath + "/config.yml", Config.YAML);
        CommandName = config.getString("CommandName", "mycommand");
        saveConfig();
        return true;
    }

    public static boolean saveConfig() {
        Config config = new Config(ConfigPath + "/config.yml", Config.YAML);
        config.set("CommandName", CommandName);
        config.save();
        return true;
    }

}
