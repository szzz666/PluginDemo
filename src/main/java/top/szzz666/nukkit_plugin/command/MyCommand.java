package top.szzz666.nukkit_plugin.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.command.data.CommandParameter;

import static top.szzz666.nukkit_plugin.Main.ec;
import static top.szzz666.nukkit_plugin.Main.plugin;
import static top.szzz666.nukkit_plugin.config.MyConfig.initConfig;


public class MyCommand extends Command {
    String[] options = {"reload"};
    public MyCommand() {
        super(ec.getString("command"), "重新加载" + plugin.getName() + "插件配置");
        this.setPermission(plugin.getName() + ".command");
        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{
                CommandParameter.newEnum("opt", options)
        });
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (sender.isOp() || sender instanceof ConsoleCommandSender) {
            if ("reload".equals(args[0])) {
                initConfig();
                sender.sendMessage(plugin.getName() + "插件配置已重新加载");
            }
        }
        return false;
    }

}
