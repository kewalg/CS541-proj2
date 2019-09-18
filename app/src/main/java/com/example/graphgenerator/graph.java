package com.example.graphgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class graph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Spinner list = findViewById(R.id.ddlist);
        Button btn = findViewById(R.id.submit_btn);

        ArrayList <String> functions = new ArrayList<String>();
        functions.add("Sine");
        functions.add("Cos");
        functions.add("Tan");

    }

}
