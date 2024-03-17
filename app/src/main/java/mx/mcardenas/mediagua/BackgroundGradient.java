package mx.mcardenas.mediagua;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import androidx.annotation.ColorRes;
import androidx.core.content.res.ResourcesCompat;

import org.jetbrains.annotations.NotNull;

public class BackgroundGradient {

    LinearGradient gradient;
    Matrix transform;
    Paint background;

    public BackgroundGradient(@ColorRes int color, @NotNull Context ctx) {
        int backgroundInt = ResourcesCompat.getColor(ctx.getResources(), color, ctx.getTheme());
        transform = new Matrix();
        gradient = new LinearGradient(
                0f, 0f, 0f, 1f,
                new int[]{ Color.TRANSPARENT, backgroundInt },
                new float[] { 0.5f, 1f },
                Shader.TileMode.DECAL
        );
        gradient.setLocalMatrix(transform);
        background = new Paint();
        background.setDither(true);
        background.setShader(gradient);
    }

    public void resizeGradient(int height) {
        transform.setScale(1, height);
        gradient.setLocalMatrix(transform);
    }

    public void draw(Canvas canvas) {
        canvas.drawPaint(background);
    }
}
