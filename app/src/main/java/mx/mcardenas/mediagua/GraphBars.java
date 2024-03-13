package mx.mcardenas.mediagua;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class GraphBars extends View {
    private final float PADDING = 5.0f;
    private final float GAP = 8.0f;
    private final int MIN_HEIGHT = 200;
    private final Color bottomBarColor = Color.valueOf();

    private float mCurrentConsumption = 0;
    private Drawable faucet;

    private TextPaint textPaint;

    public GraphBars(Context context) {
        super(context);
        init(null, 0);
    }

    public GraphBars(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GraphBars(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.GraphBars, defStyle, 0);

        // mExampleColor = a.getColor(
        //         R.styleable.GraphBars_exampleColor,
        //         mExampleColor);
        //
        // if (a.hasValue(R.styleable.GraphBars_exampleDrawable)) {
        //     mExampleDrawable = a.getDrawable(
        //             R.styleable.GraphBars_exampleDrawable);
        //     mExampleDrawable.setCallback(this);
        // }
        //
        // a.recycle();
        //
        textPaint = new TextPaint();
        textPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.CENTER);
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
        textPaint.setTextSize(24f);
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int contentWidth = getWidth();
        int contentHeight = getHeight();
        canvas.drawRect(0, contentHeight - 80, contentWidth, contentHeight, Color.argb(0.2, 0.3, 0.3, 1));

        // canvas.drawText(mExampleString,
        //         paddingLeft + (contentWidth - mTextWidth) / 2,
        //         paddingTop + (contentHeight + mTextHeight) / 2,
        //         mTextPaint);

        // if (mExampleDrawable != null) {
        //     mExampleDrawable.setBounds(paddingLeft, paddingTop,
        //             paddingLeft + contentWidth, paddingTop + contentHeight);
        //     mExampleDrawable.draw(canvas);
        // }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        float density = getResources().getDisplayMetrics().density;

        heightSize = (int) Math.max(heightSize, MIN_HEIGHT * density);
        setMeasuredDimension(widthSize, heightSize);
    }

    public void setCurrentConsumption(float consumption) {
        if (this.mCurrentConsumption == consumption)
            return;
        this.mCurrentConsumption = consumption;
        invalidate();
    }

    public float getCurrentConsumption() {
        return mCurrentConsumption;
    }
}