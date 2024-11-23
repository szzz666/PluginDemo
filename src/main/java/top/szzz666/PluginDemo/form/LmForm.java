package top.szzz666.PluginDemo.form;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.handler.FormResponseHandler;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import top.szzz666.PluginDemo.config.MyConfig;

import static top.szzz666.PluginDemo.config.LangConfig.loadLangConfig;
import static top.szzz666.PluginDemo.config.LangConfig.saveConfig;
import static top.szzz666.PluginDemo.config.MyConfig.Language;
import static top.szzz666.PluginDemo.config.MyConfig.loadConfig;


public class LmForm {
    public static void mainForm(Player player) {
        FormWindowSimple form = new FormWindowSimple("mainForm_title", "mainForm_content");
        form.addButton(new ElementButton("mainForm_button1"));
        form.addButton(new ElementButton("mainForm_button2"));
        form.addHandler(FormResponseHandler.withoutPlayer(ignored -> {
            if (form.wasClosed()) return;
            int buttonIndex = form.getResponse().getClickedButtonId();
            if (buttonIndex == 0) {
                Form0(player);
            } else {
                loadConfig();
                loadLangConfig();
                player.sendMessage("mainForm_sendMessage");
            }
        }));
        player.showFormWindow(form);
    }

    public static void Form0(Player player) {
        FormWindowCustom form = new FormWindowCustom("Form0_title");
        // 添加组件
        form.addElement(new ElementInput("Form0_Element0", Language, Language));
        // 设置提交操作
        form.addHandler(FormResponseHandler.withoutPlayer(ignored -> {
            if (form.wasClosed()) return;
            String Language = form.getResponse().getInputResponse(0);

            // 处理用户提交的数据
            MyConfig.Language = Language;
            saveConfig();
            loadLangConfig();
            player.sendMessage("Form0_sendMessage");
        }));
        // 显示表单给玩家
        player.showFormWindow(form);
    }
}
