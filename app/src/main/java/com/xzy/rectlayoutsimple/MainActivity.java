package com.xzy.rectlayoutsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xzy.rectlayout.RectLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        RectLayout layout = new RectLayout(this);
        layout.setMode(RectLayout.MODE_WIDTH);
        layout.setScale(0.4);
        layout.setLayoutParams(new ViewGroup.LayoutParams((int) (dm.widthPixels * 0.5), ViewGroup.LayoutParams.WRAP_CONTENT));

        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setImageResource(R.mipmap.ic_launcher_round);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        layout.addView(imageView);
        ((LinearLayout) findViewById(R.id.root)).addView(layout);
    }
}
