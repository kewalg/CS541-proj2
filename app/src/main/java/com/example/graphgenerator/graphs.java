package com.example.graphgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class graphs extends AppCompatActivity {
    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Button sin_btn = (Button) findViewById(R.id.sin_submit);
        EditText sin_edttxt = (EditText)findViewById(R.id.sin_edtext);

        sin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double x,y;
                x=0.0;
                GraphView graph = (GraphView)findViewById(R.id.graphviewtest);
                series = new LineGraphSeries<DataPoint>();
                for (int i =0;i<250;i++){
                    x = x+0.1;
                    y = Math.sin(x);
                    series.appendData(new DataPoint(x,y), true, 250);
                }
                graph.addSeries(series);
            }
        });



    }
}
