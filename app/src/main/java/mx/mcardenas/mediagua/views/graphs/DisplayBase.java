package mx.mcardenas.mediagua.views.graphs;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class DisplayBase {
    public enum Position { START, END }

    protected Label[] labels;
    protected float labelSize;
    protected int charCount;
    protected float scrollPos;
    protected boolean hasRuler;
    protected boolean isScrollable;
    protected Paint textPaint;
    protected Position position;

    public DisplayBase(
            Label[] labels,
            float labelSize,
            int charCount,
            float scrollPos,
            boolean hasRuler,
            boolean isScrollable,
            Position position,
            Paint textPaint) {
        this.labels = labels;
        this.labelSize = labelSize;
        this.charCount = charCount;
        this.scrollPos = scrollPos;
        this.hasRuler = hasRuler;
        this.isScrollable = isScrollable;
        this.position = position;
        this.textPaint = textPaint;
    }

    abstract void draw(Canvas canvas);
}
