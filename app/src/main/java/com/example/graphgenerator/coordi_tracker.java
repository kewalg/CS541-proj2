package com.example.graphgenerator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class coordi_tracker extends AppCompatActivity {
    float dX, dY;
    int lastAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // for fullscreen view
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_coordi_tracker);
        View.OnTouchListener touchListener;
        touchListener = new View.OnTouchListener() {
            float dx = 0, dy = 0, x = 0, y = 0;
            RelativeLayout.LayoutParams parms;
            LinearLayout.LayoutParams par;
            View view = findViewById(R.id.circle);

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                Button btn = findViewById(R.id.coordi_btn);
                final TextView txt = findViewById(R.id.coordi_txt);
                switch (event.getAction()) {

                    //on touch detection
                    case MotionEvent.ACTION_DOWN: {
                        parms = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        //par = (LinearLayout.LayoutParams) getWindow().findViewById(Window.ID_ANDROID_CONTENT).getLayoutParams();
                        dx = event.getRawX() - parms.leftMargin;
                        dy = event.getRawY() - parms.topMargin;
                        Log.i("Position 1", "position 1 is:" + dx + " , " + dy);
                    }
                    break;
                    //on finger movement
                    case MotionEvent.ACTION_MOVE: {
                        x = event.getRawX();
                        y = event.getRawY();
                        parms.leftMargin = (int) (x - dx);
                        parms.topMargin = (int) (y - dy);
                        view.setLayoutParams(parms);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                txt.setText("Co-ordinates are: " + dx + " , " + dy);
                            }
                        });
                    }
                    break;
                    //on touch release
                    case MotionEvent.ACTION_UP: {
                    }
                    break;
                }
                return true;
            }
        };
        final View dragView = findViewById(R.id.circle);
        dragView.setOnTouchListener(touchListener);
    }
}