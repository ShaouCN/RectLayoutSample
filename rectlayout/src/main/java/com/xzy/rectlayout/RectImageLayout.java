package com.xzy.rectlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by xiezhenyu on 2018/2/2.
 */
public class RectImageLayout extends RectLayout {
    private ImageView imageView;
    private int resId;

    public RectImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.RectImageLayout);
        try {
            resId = a.getResourceId(R.styleable.RectImageLayout_src, 0);
        } finally {
            a.recycle();
        }
        init();
    }

    public RectImageLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(resId);
        addView(imageView, 0);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
