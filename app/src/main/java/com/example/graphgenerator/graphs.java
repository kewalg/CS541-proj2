package com.example.graphgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphs extends AppCompatActivity {
    LineGraphSeries<DataPoint> series,series1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphs);


        final GraphView graph = (GraphView) findViewById(R.id.graphviewtest);
        Button btn_submit = (Button) findViewById(R.id.sin_submit);
        Button btn_submit2 = (Button)findViewById(R.id.sin_submit1);

        series = new LineGraphSeries<DataPoint>();
        series1 = new LineGraphSeries<DataPoint>();


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMinX(-10);
                graph.getViewport().setMaxX(10);
                graph.getViewport().setScalable(true);
                graph.getViewport().setScrollable(true);
                graph.getViewport().setYAxisBoundsManual(true);
                graph.getViewport().setScalableY(true);
                graph.getViewport().setScrollableY(true);
                double x= -10,y;

                for (int i = 0; i < 200; i++) {
                    x = x + 0.1;
                    y = 0.5 * (Math.sin(x));
                    series.appendData(new DataPoint(x, y), true, 200);
                }
                graph.addSeries(series);

            }
        });


        btn_submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                series1.setColor(Color.BLACK);
                double v= -10,z;
                for (int j = 0; j < 200; j++) {
                    v = v + 0.1;
                    z = 3 * (Math.sin(v));
                    series.appendData(new DataPoint(v, z), true, 200);
                }
                graph.addSeries(series1);
            }
        });



    }
}
