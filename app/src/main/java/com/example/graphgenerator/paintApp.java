package com.example.graphgenerator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;


public class paintApp extends View {


    private Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path path = new Path();

    public paintApp(Context context) {
        //defining the brush size and color
        super(context);
        brush.setStyle(Paint.Style.STROKE);
        brush.setColor(Color.WHITE);
        brush.setStrokeWidth(50);
    }

    @Override
    protected void onDraw(Canvas c) {
        c.drawPath(path, brush);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            //generate the canvas draw on finger touchdown
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                break;
            //start drawing a line on finger drag
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}