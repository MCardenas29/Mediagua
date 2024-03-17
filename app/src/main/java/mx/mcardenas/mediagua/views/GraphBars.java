package mx.mcardenas.mediagua.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import mx.mcardenas.mediagua.BackgroundGradient;
import mx.mcardenas.mediagua.R;

public class GraphBars extends View {
    private final float PADDING = 5.0f;
    private final float GAP = 8.0f;
    private final int MIN_HEIGHT = 200;
    public final int BOTTOM_HEIGHT = 60;

    private float mCurrentConsumption = 0;

    private BackgroundGradient background;


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

        background = new BackgroundGradient(R.color.md_theme_light_primaryContainer, getContext());

        a.recycle();
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int contentWidth = getWidth();
        int contentHeight = getHeight();

        background.draw(canvas);
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

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float bottomHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, BOTTOM_HEIGHT, metrics);
        background.resizeGradient((int) (heightSize - bottomHeight));
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