package top.szzz666.PluginDemo.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;


public class MyCommand extends Command {
    public MyCommand() {
        super("CommandName", "命令描述");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (sender.isPlayer()) {

        }
        return false;
    }

}
