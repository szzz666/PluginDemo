package top.szzz666.PluginDemo.config;

import cn.nukkit.utils.Config;

import static top.szzz666.PluginDemo.PluginDemoMain.ConfigPath;
import static top.szzz666.PluginDemo.PluginDemoMain.plugin;

public class MyConfig {
    public static String Language;



    public static boolean loadConfig() {
        plugin.saveResource("config.yml");
        Config config = new Config(ConfigPath + "/config.yml", Config.YAML);
        Language = config.getString("Language");
        config.save();
        return true;
    }

}
