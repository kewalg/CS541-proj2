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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordi_tracker);
        final Button btn = findViewById(R.id.coordi_btn);
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
        view.setOnTouchListener(touchListener);
    }
}
