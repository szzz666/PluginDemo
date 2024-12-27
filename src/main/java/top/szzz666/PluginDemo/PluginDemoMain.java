package top.szzz666.PluginDemo;

import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import top.szzz666.PluginDemo.command.MyCommand;
import top.szzz666.PluginDemo.event.Listeners;

import static top.szzz666.PluginDemo.config.MyConfig.loadConfig;
import static top.szzz666.PluginDemo.tools.pluginUtil.nkConsole;


public class PluginDemoMain extends PluginBase {
    public static Plugin plugin;
    public static Server nkServer;
    public static CommandSender consoleObjects;
    public static String ConfigPath;

    //插件读取
    @Override
    public void onLoad() {
        nkServer = getServer();
        plugin = this;
        consoleObjects = getServer().getConsoleSender();
        ConfigPath = getDataFolder().getPath();
        loadConfig();
        nkConsole("&b插件读取...");
    }

    //插件开启
    @Override
    public void onEnable() {
        //注册监听器
        this.getServer().getPluginManager().registerEvents(new Listeners(), this);
        //注册命令
        this.getServer().getCommandMap().register(this.getName(), new MyCommand());
        nkConsole("&b插件开启");
        nkConsole("&c如果遇到任何bug，请加入Q群进行反馈：894279534", 1);
    }

    //插件关闭
    @Override
    public void onDisable() {
        nkConsole("&b插件关闭");
    }

}
