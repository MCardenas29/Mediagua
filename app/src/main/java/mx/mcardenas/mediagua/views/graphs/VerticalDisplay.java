package mx.mcardenas.mediagua.views.graphs;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class VerticalDisplay extends DisplayBase {

    public VerticalDisplay(Label[] labels,
                           float labelSize,
                           int charCount,
                           float scrollPos,
                           boolean hasRuler,
                           boolean isScrollable,
                           Position position,
                           Paint textPaint) {
        super(labels, labelSize, charCount, scrollPos, hasRuler, isScrollable, position, textPaint);
    }

    @Override
    void draw(Canvas canvas) {
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        int displayHeight = (int) (labelSize * labels.length);

        // Draw all the labels in a vertical manner
        for (int i = 0; i < labels.length; i++) {
            Label label = labels[i];
            Rect bounds = new Rect();
            textPaint.getTextBounds(label.title, 0, label.title.length(), bounds);
            canvas.drawText(label.title, 0, labelSize * i + bounds.height(), textPaint);
        }
    }
}
