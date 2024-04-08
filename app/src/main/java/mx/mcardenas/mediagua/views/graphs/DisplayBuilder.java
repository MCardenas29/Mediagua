package mx.mcardenas.mediagua.views.graphs;

import android.graphics.Color;
import android.graphics.Paint;

public class DisplayBuilder {
    private Label[] labels;
    private float labelSize;
    private int charCount;
    private float scrollPos;
    private boolean hasRuler;
    private boolean isScrollable;
    private Paint textPaint;
    private DisplayBase.Position position;

    public DisplayBuilder(Label[] labels, float labelSize) {
        this.labels = labels;
        this.labelSize = labelSize;
        this.charCount = -1;
        this.scrollPos = 0;
        this.hasRuler = false;
        this.isScrollable = false;
        this.textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(22);
        this.position = DisplayBase.Position.START;
    }

    public VerticalDisplay createVertical() {
        return new VerticalDisplay(
                labels,
                labelSize,
                charCount,
                scrollPos,
                hasRuler,
                isScrollable,
                position,
                textPaint
        );
    }

    // public HorizontalDisplay createHorizontal() {
    //     return new HorizontalDisplay(
    //             labels,
    //             labelSize,
    //             charCount,
    //             scrollPos,
    //             hasRuler,
    //             isScrollable,
    //             position,
    //             textPaint
    //     );
    // }

    public void setCharCount(int charCount) {
        this.charCount = charCount;
    }

    public void setScrollPos(float scrollPos) {
        this.scrollPos = scrollPos;
    }

    public void setHasRuler(boolean hasRuler) {
        this.hasRuler = hasRuler;
    }

    public void setScrollable(boolean scrollable) {
        isScrollable = scrollable;
    }

    public void setPosition(DisplayBase.Position position) {
        this.position = position;
    }

    public void setTextPaint(Paint textPaint) {
        this.textPaint = textPaint;
    }
}
