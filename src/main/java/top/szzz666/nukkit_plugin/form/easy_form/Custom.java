package top.szzz666.nukkit_plugin.form.easy_form;

import cn.nukkit.Player;
import cn.nukkit.form.element.Element;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.handler.FormResponseHandler;
import cn.nukkit.form.window.FormWindowCustom;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static top.szzz666.nukkit_plugin.tools.taskUtil.Async;

@Data
public class Custom {
    private final Map<String, Element> elements = new LinkedHashMap<>();
    private FormWindowCustom form;
    private Runnable close;
    private Runnable submit;

    public Custom(String title) {
        this.form = new FormWindowCustom(title);
    }

    public String add(String Label) {
        String key = getRandKey();
        this.elements.put(key, new ElementLabel(Label));
        return key;
    }

    private String getRandKey() {
        return "custom_" + Math.random();
    }

    public void add(String key, Element element) {
        this.elements.put(key, element);
    }

    public void show(Player player) {
        for (Element element : this.elements.values()) {
            this.form.addElement(element);
        }
        this.form.addHandler(FormResponseHandler.withoutPlayer(ignored -> {
            if (this.form.wasClosed()) {
                if (this.close != null) {
                    this.close.run();
                }
                return;
            }
            if (this.submit != null) {
                this.submit.run();
            }
        }));
        player.showFormWindow(this.form);
    }

    public void asyncShow(Player player) {
        for (Element element : this.elements.values()) {
            this.form.addElement(element);
        }
        this.form.addHandler(FormResponseHandler.withoutPlayer(ignored -> Async(() -> {
            if (this.form.wasClosed()) {
                if (this.close != null) {
                    this.close.run();
                }
                return;
            }
            if (this.submit != null) {
                this.submit.run();
            }
        })));
        player.showFormWindow(this.form);
    }

    @SuppressWarnings("unchecked")
    public <T> T getRes(String key) {
        int index = new ArrayList<>(this.elements.keySet()).indexOf(key);
        return (T) this.form.getResponse().getResponse(index);
    }

    public String getInputRes(String key) {
        int index = new ArrayList<>(this.elements.keySet()).indexOf(key);
        return this.form.getResponse().getInputResponse(index);
    }

    public String getDropdownRes(String key) {
        int index = new ArrayList<>(this.elements.keySet()).indexOf(key);
        return this.form.getResponse().getDropdownResponse(index).getElementContent();
    }

    public String getStepSliderRes(String key) {
        int index = new ArrayList<>(this.elements.keySet()).indexOf(key);
        return this.form.getResponse().getStepSliderResponse(index).getElementContent();
    }

    public int getStepSliderIdRes(String key) {
        int index = new ArrayList<>(this.elements.keySet()).indexOf(key);
        return this.form.getResponse().getStepSliderResponse(index).getElementID();
    }

    public int getDropdownIndexRes(String key) {
        int index = new ArrayList<>(this.elements.keySet()).indexOf(key);
        return this.form.getResponse().getDropdownResponse(index).getElementID();
    }

    public float getSliderRes(String key) {
        int index = new ArrayList<>(this.elements.keySet()).indexOf(key);
        return this.form.getResponse().getSliderResponse(index);
    }

    public boolean getToggleRes(String key) {
        int index = new ArrayList<>(this.elements.keySet()).indexOf(key);
        return this.form.getResponse().getToggleResponse(index);
    }

}
