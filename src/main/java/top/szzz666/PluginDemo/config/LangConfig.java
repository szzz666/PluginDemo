package top.szzz666.PluginDemo.config;

import cn.nukkit.utils.Config;

import static top.szzz666.PluginDemo.PluginDemoMain.ConfigPath;
import static top.szzz666.PluginDemo.PluginDemoMain.plugin;
import static top.szzz666.PluginDemo.config.MyConfig.Language;


public class LangConfig {
    public static boolean loadLangConfig() {
        plugin.saveResource("language/chs.yml");
        plugin.saveResource("language/eng.yml");
        Config LangConfig = new Config(ConfigPath + "/language/" + Language, Config.YAML);
        LangConfig.save();
        return true;
    }
    public static boolean saveConfig() {
        Config config = new Config(ConfigPath + "/config.yml", Config.YAML);
        config.set("Language", Language);
        config.save();
        return true;
    }
}
