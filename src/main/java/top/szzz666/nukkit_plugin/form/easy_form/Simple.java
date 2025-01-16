package top.szzz666.nukkit_plugin.form.easy_form;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.handler.FormResponseHandler;
import cn.nukkit.form.window.FormWindowSimple;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static top.szzz666.nukkit_plugin.tools.taskUtil.Async;

@Data
public class Simple {
    private final FormWindowSimple form;
    private final Map<ElementButton, Runnable> buttons = new LinkedHashMap<>();
    private Runnable close;

    public Simple(String title, String content) {
        this.form = new FormWindowSimple(title, content);
    }

    public void add(String text, Runnable runnable) {
        this.buttons.put(new ElementButton(text), runnable);
    }

    public void add(String text, String img, Runnable runnable) {
        String type = img.startsWith("http") ? "url" : "path";
        this.buttons.put(new ElementButton(text, new ElementButtonImageData(type, img)), runnable);
    }

    public void show(Player player) {
        for (ElementButton button : this.buttons.keySet()) {
            this.form.addButton(button);
        }
        this.form.addHandler(FormResponseHandler.withoutPlayer(ignored -> {
            if (this.form.wasClosed()) {
                if (this.close != null) {
                    this.close.run();
                }
                return;
            }
            new ArrayList<>(this.buttons.values()).get(form.getResponse().getClickedButtonId()).run();
        }));
        player.showFormWindow(this.form);
    }

    public void asyncShow(Player player) {
        for (ElementButton button : this.buttons.keySet()) {
            this.form.addButton(button);
        }
        this.form.addHandler(FormResponseHandler.withoutPlayer(ignored -> Async(() -> {
            if (this.form.wasClosed()) {
                if (this.close != null) {
                    this.close.run();
                }
                return;
            }
            new ArrayList<>(this.buttons.values()).get(form.getResponse().getClickedButtonId()).run();
        })));
        player.showFormWindow(this.form);
    }
}
