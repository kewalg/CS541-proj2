package com.example.graphgenerator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class coordi_tracker extends AppCompatActivity {


    float dX;
    float dY;
    int lastAction;
    View.OnTouchListener touchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordi_tracker);

        touchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        lastAction = MotionEvent.ACTION_DOWN;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.setY(event.getRawY() + dY);
                        view.setX(event.getRawX() + dX);

                        lastAction = MotionEvent.ACTION_MOVE;
                        break;
                    case MotionEvent.ACTION_UP:
                        if (lastAction == MotionEvent.ACTION_DOWN) {
                            Toast.makeText(coordi_tracker.this, "Clicked!", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    default:
                        return false;
                }
                return true;
            }
        };
        final View dragView = findViewById(R.id.circle);
        dragView.setOnTouchListener(touchListener);
    }
}








        /*final Button btn = findViewById(R.id.coordi_btn);
        final TextView txt = findViewById(R.id.coordi_txt);
        View view = findViewById(R.id.coordi_view);


        View.OnTouchListener touchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getX();
                final int y = (int) event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("TAG", "touched down");

                        break;
                    case MotionEvent.ACTION_MOVE:
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("TAG", "Coordinates are : (" + x + ", " + y + ")");
                                txt.setText(x + " , " + y);
                                Toast.makeText(coordi_tracker.this, "Co-ordinates Traced!", Toast.LENGTH_SHORT).show();
                            }
                        });

                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("TAG", "touched up");
                        break;
                }
                return true;
            }
        };
        view.setOnTouchListener(touchListener);*/
