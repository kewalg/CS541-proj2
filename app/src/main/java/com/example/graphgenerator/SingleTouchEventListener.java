package com.example.graphgenerator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class SingleTouchEventListener extends View {

    public Paint paint = new Paint();
    public Path path = new Path();
    public Paint mPaint;
    Canvas clear = new Canvas();


    public SingleTouchEventListener(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(100);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        canvas.drawPath(path, paint);
    }

/*

    public boolean clearCanvas(){
        */
/*clear.drawColor(0, PorterDuff.Mode.CLEAR);
        return false;*//*

        path.reset();
        return true;
    }
*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                // nothing to do
                break;
            default:
                return false;
        }

// Schedules a repaint.
        invalidate();
        return true;
    }
}