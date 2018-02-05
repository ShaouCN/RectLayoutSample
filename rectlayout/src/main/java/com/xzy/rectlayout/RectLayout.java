package com.xzy.rectlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


/**
 * 矩形，根据mode不同适应宽高
 *
 * @author xiezhenyu 2017/2/22.
 */
public class RectLayout extends RelativeLayout {
    /**
     * 以宽作为基准，高度会变成宽的scale倍
     */
    public static final int MODE_WIDTH = 1;
    /**
     * 以高作为基准，宽度会变成高的scale倍
     */
    public static final int MODE_HEIGHT = 2;

    private int mMode = MODE_WIDTH;

    /**
     * 倍数
     */
    private double scale = 1;

    public RectLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.RectLayout);
        try {
            mMode = a.getInteger(R.styleable.RectLayout_mode, MODE_WIDTH);
            scale = a.getFloat(R.styleable.RectLayout_scale, 1);
        } finally {
            a.recycle();
        }
    }

    public RectLayout(Context context) {
        super(context);
    }

    public void setMode(int mode) {
        if (mode == MODE_WIDTH || mode == MODE_HEIGHT) {
            mMode = mode;
            invalidate();
        } else {
            throw new RuntimeException("mode must be 1 or 2!");
        }
    }

    public int getMode() {
        return mMode;
    }

    public void setScale(double scale) {
        this.scale = scale;
        invalidate();
    }

    public double getScale() {
        return scale;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = getMeasuredWidth();
        int childHeightSize = getMeasuredHeight();
        switch (mMode) {
            case MODE_WIDTH:
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
                heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (childWidthSize * scale), MeasureSpec.EXACTLY);
                break;
            case MODE_HEIGHT:
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeightSize, MeasureSpec.EXACTLY);
                widthMeasureSpec = MeasureSpec.makeMeasureSpec((int) (childHeightSize * scale), MeasureSpec.EXACTLY);
                break;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
