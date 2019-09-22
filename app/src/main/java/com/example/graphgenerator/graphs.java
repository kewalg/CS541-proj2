package com.example.graphgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class graphs extends AppCompatActivity {

    String[] functions = {"Sine", "Cosine", "Tangent"};

    ArrayAdapter<String> adapter;

    Spinner list;
    GraphView graph;
    Button btn;
    private boolean isSpinnerInitial = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // for fullscreen view
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_graphs);


        list = findViewById(R.id.ddlist);
        graph = findViewById(R.id.graphviewtest);
        final Button btn = findViewById(R.id.submit);
        final Button clear_btn = findViewById(R.id.clear);
        final EditText edt_submit = (EditText) findViewById(R.id.edtext);

        final LineGraphSeries<DataPoint> series, series1, series2;
        series = new LineGraphSeries<DataPoint>();
        series1 = new LineGraphSeries<DataPoint>();
        series2 = new LineGraphSeries<DataPoint>();

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, functions);
        list.setAdapter(adapter);

        //clear all graphs button
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                graph.removeAllSeries();
                Toast.makeText(graphs.this, "Graphs Cleared!", Toast.LENGTH_SHORT).show();
            }
        });


        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, final int i, long l) {

                //to avoid spinner from fetching list position at start of activity
                if (isSpinnerInitial) {
                    isSpinnerInitial = false;
                    return;
                }

                if (i == 0) {
                    edt_submit.setHint("Enter value of m in y = m sin x ");
                } else if (i == 1) {
                    edt_submit.setHint("Enter value of m in y = m cos x ");
                } else {
                    edt_submit.setHint("Enter value of m in y = m tan x ");
                }

                View.OnClickListener phaseHandler = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (i == 0) {
                            Toast.makeText(graphs.this, "Sine", Toast.LENGTH_SHORT).show();

                            //make graph scrollable and zoomable
                            graph.getViewport().setXAxisBoundsManual(true);
                            graph.getViewport().setScalable(true);
                            graph.getViewport().setScrollable(true);
                            graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                                @Override
                                public String formatLabel(double value, boolean isValueX) {
                                    if (isValueX) {
                                        return super.formatLabel(value, isValueX) + "π";
                                    }
                                    return super.formatLabel(value, isValueX);
                                }
                            });
                            series.setColor(Color.RED);
                            double x = -5, func1_inputdfinal;
                            EditText edt_submit = (EditText) findViewById(R.id.edtext);
                            double func1_inputd = Double.parseDouble(edt_submit.getText().toString());

                            //generating and adding data points to graph
                            for (int i = 0; i < 100; i++) {
                                x = x + 0.1;
                                func1_inputdfinal = func1_inputd * Math.sin(x);
                                series.appendData(new DataPoint(x, func1_inputdfinal), true, 100);
                            }
                            graph.addSeries(series);

                        } else if (i == 1) {
                            Toast.makeText(graphs.this, "Cosine", Toast.LENGTH_SHORT).show();

                            graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                                @Override
                                public String formatLabel(double value, boolean isValueX) {
                                    if (isValueX) {
                                        return super.formatLabel(value, isValueX) + "π";
                                    }
                                    return super.formatLabel(value, isValueX);
                                }
                            });
                            //make graph scrollable and zoomable
                            graph.getViewport().setXAxisBoundsManual(true);
                            graph.getViewport().setScalable(true);
                            graph.getViewport().setScrollable(true);
                            series1.setColor(Color.BLUE);
                            double v = -5, func2_inputdfinal;

                            EditText edt_submit = (EditText) findViewById(R.id.edtext);
                            double func2_inputd = Double.parseDouble(edt_submit.getText().toString());

                            //generating and adding data points to graph
                            for (int i = 0; i < 100; i++) {
                                v = v + 0.1;
                                func2_inputdfinal = func2_inputd * Math.cos(v);
                                series1.appendData(new DataPoint(v, func2_inputdfinal), true, 100);
                            }
                            graph.addSeries(series1);
                        } else {
                            Toast.makeText(graphs.this, "Tangent", Toast.LENGTH_SHORT).show();
                            graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                                @Override
                                public String formatLabel(double value, boolean isValueX) {
                                    if (isValueX) {
                                        return super.formatLabel(value, isValueX) + "π";
                                    }
                                    return super.formatLabel(value, isValueX);
                                }
                            });
                            //make graph scrollable and zoomable
                            graph.getViewport().setXAxisBoundsManual(true);
                            graph.getViewport().setScalable(true);
                            graph.getViewport().setScrollable(true);

                            double w = -5, func3_inputdfinal;
                            EditText edt_submit = (EditText) findViewById(R.id.edtext);
                            double func3_inputd = Double.parseDouble(edt_submit.getText().toString());

                            //generating and adding data points to graph
                            for (int k = 0; k < 100; k++) {
                                w = w + 0.1;
                                func3_inputdfinal = func3_inputd * Math.tan(w);
                                series2.appendData(new DataPoint(w, func3_inputdfinal), true, 100);
                            }
                            graph.addSeries(series2);

                        }
                    }
                };
                btn.setOnClickListener(phaseHandler);
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(graphs.this, "test", Toast.LENGTH_SHORT).show();
            }
        });
    }
}






















        /*list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isSpinnerInitial){
                    isSpinnerInitial = false;
                    return;
                }

                switch (i) {

                    case 0:
                        //Toast.makeText(graphs.this, "Position is:" +i, Toast.LENGTH_SHORT).show();
                        btn.setOnClickListener(new View.OnClickListener() {


                            @Override
                            public void onClick(View view) {

                                graph.getViewport().setXAxisBoundsManual(true);
                                graph.getViewport().setScalable(true);
                                graph.getViewport().setScrollable(true);
                                //graph.getViewport().setYAxisBoundsManual(true);
                                //graph.getViewport().setScalableY(true);
                                //graph.getViewport().setScrollableY(true);
                                graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                                    @Override
                                    public String formatLabel(double value, boolean isValueX) {
                                        if (isValueX) {
                                            return super.formatLabel(value, isValueX) + "π";
                                        }
                                        return super.formatLabel(value, isValueX);
                                    }
                                });
                                series.setColor(Color.RED);
                                double x = -5, func1_inputdfinal;
                                double func1_inputd = Double.parseDouble(edt_submit.getText().toString());

                                for (int i = 0; i < 100; i++) {
                                    x = x + 0.1;
                                    func1_inputdfinal = func1_inputd * Math.sin(x);
                                    series.appendData(new DataPoint(x, func1_inputdfinal), true, 100);
                                }
                                graph.addSeries(series);
                            }
                        });
                        break;
                    case 1:
                        Toast.makeText(graphs.this, "Position is:" +i, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(graphs.this, "Position is:" +i, Toast.LENGTH_SHORT).show();
                        break;
                }
                btn.setOnClickListener(phaseHandler);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
