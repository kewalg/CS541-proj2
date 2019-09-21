package com.example.graphgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class canvas extends Activity implements View.OnClickListener {

    // SingleTouchEventListener obj;
    Button btn;
    SingleTouchEventListener obj;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        //setContentView(new SingleTouchEventListener(this, null));
        btn = (Button) findViewById(R.id.btn_clear_canvas);

        btn.setOnClickListener(this);
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // obj.clearCanvas();
                Toast.makeText(canvas.this, "Test button!", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Test!", Toast.LENGTH_SHORT).show();

    }

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
}