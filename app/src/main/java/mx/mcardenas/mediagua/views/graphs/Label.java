package mx.mcardenas.mediagua.views.graphs;

import org.jetbrains.annotations.NotNull;

public class Label {
    public String title;
    public String subtitle = null;

    public Label(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public Label(String title) {
        this.title = title;
    }
}
