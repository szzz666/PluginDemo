package top.szzz666.nukkit_plugin.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

import static top.szzz666.nukkit_plugin.form.MyForm.Form;


public class MyCommand extends Command {
    public MyCommand() {
        super("CommandName", "命令描述");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (sender.isPlayer()) {
            Form((Player) sender);
        }
        return false;
    }

}
