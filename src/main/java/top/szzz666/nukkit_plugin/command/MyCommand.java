package top.szzz666.nukkit_plugin.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;

import static top.szzz666.nukkit_plugin.Main.ec;
import static top.szzz666.nukkit_plugin.Main.plugin;
import static top.szzz666.nukkit_plugin.config.MyConfig.initConfig;


public class MyCommand extends Command {
    public MyCommand() {
        super(ec.getString("reloadCommand"), "重新加载" + plugin.getName() + "插件配置");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (sender.isOp() || sender instanceof ConsoleCommandSender) {
            initConfig();
            sender.sendMessage(plugin.getName() + "插件配置已重新加载");
        }
        return false;
    }

}
