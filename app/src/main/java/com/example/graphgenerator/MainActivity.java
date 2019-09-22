package com.example.graphgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE); // for hiding title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button graph_btn = findViewById(R.id.btn1);
        Button canvas_btn = findViewById(R.id.btn2);
        final Button coordi_btn = findViewById(R.id.btn3);

        graph_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent graphs = new Intent(MainActivity.this, graphs.class);
                startActivity(graphs);
            }
        });

        canvas_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent canvas = new Intent(MainActivity.this, canvas.class);
                startActivity(canvas);
            }
        });

        coordi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent coordi = new Intent(MainActivity.this, coordi_tracker.class);
                startActivity(coordi);
            }
        });
    }
}
