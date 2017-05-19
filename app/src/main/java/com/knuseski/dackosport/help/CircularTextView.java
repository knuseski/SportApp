package com.knuseski.dackosport.help;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class CircularTextView extends AppCompatTextView {

    private Context context;

    private float strokeWidth;
    private int strokeColor, solidColor;

    public CircularTextView(Context context) {
        super(context);
        this.context = context;
    }

    public CircularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CircularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }


    @Override
    public void draw(Canvas canvas) {

        Paint circlePaint = new Paint();
        circlePaint.setColor(solidColor);
        circlePaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        Paint strokePaint = new Paint();
        strokePaint.setColor(strokeColor);
        strokePaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        int h = this.getHeight();
        int w = this.getWidth();

        int diameter = ((h > w) ? h : w);
        int radius = diameter / 2;

        this.setHeight(diameter);
        this.setWidth(diameter);

        canvas.drawCircle(diameter / 2, diameter / 2, radius, strokePaint);

        canvas.drawCircle(diameter / 2, diameter / 2, radius - strokeWidth, circlePaint);

        super.draw(canvas);
    }

    public void setStrokeWidth(int dp) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        strokeWidth = dp * scale;

    }

    public void setStrokeColor(String color) {
        strokeColor = Color.parseColor(color);
    }

    public void setStrokeColor(int resource) {
        strokeColor = ContextCompat.getColor(context, resource);
    }

    public void setSolidColor(String color) {
        solidColor = Color.parseColor(color);
    }

    public void setSolidColor(int resource) {
        solidColor = ContextCompat.getColor(context, resource);
    }
}
