package com.natalia.lab3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ActivityThree extends AppCompatActivity {

    public ArrayList gen( int n, int marker) {
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<Double> y1 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            x.add(0.2 * i);
        }

        for (int i = 0; i <= n; i++) {
            y1.add(Math.sin(x.get(i)));
        }
        for (int i = 0; i < x.size(); i++) {
            entries.add(new Entry(Float.parseFloat(x.get(i).toString()),
                    Float.parseFloat(y1.get(i).toString())));
        }
        if (marker == 1) {
            return x;
        }
        if (marker == 2) {
            return y1;
        }

        else {
            return entries;
        }
    }

    public  double  mistake(double param, int n, int marker){

        double p = lagrange.lagrange(param, 1, n);
        double p1 = lagrange.lagrange(param, 1, n+1);
        double p2 = lagrange.lagrange(param, 1, n+2);

        // оцінка похибки інтерполяції
        double  fl = p - p1;
        // оцінка похибки оцінки похибки
        double fl_fl = p1-p2;
        //# розмитість оцінки похбки
        double blur = 0.0;
        try {
            blur = Math.abs(fl_fl/fl);
        }
        catch (ArithmeticException e ){
            blur = 0.0;
        }
        if (marker==1){
            return fl;
        }
        if (marker==2){
            return fl_fl;
        }
        else{
            return blur;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ArrayList<Entry> entries2 = new ArrayList<>();
        ArrayList<Entry> entries3 = new ArrayList<>();
        ArrayList<Entry> entries4 = new ArrayList<>();
        ArrayList<Entry> entries5 = new ArrayList<>();
        ArrayList<Entry> entries6 = new ArrayList<>();
        ArrayList<Entry> entries7 = new ArrayList<>();
        ArrayList<Entry> entries8 = new ArrayList<>();

        LineDataSet dataset = new LineDataSet(gen(10,3), "SIN(X)");
        LineData data = new LineData(dataset);

        LineChart Graphsin = (LineChart) findViewById(R.id.Graphsin);

        Graphsin.setData(data);



        float n = 9;
        for (int i = 1; i < n; i++) {
            entries2.add(new Entry((float)i, (float)(mistake(0.1, i,1))));
        }

        LineDataSet dataset2 = new LineDataSet(entries2, "BLUR0.1");
        dataset2.setCircleColor(Color.parseColor("#FF0075"));
        dataset2.setColors(Color.parseColor("#FF0075"));
        dataset2.setAxisDependency(YAxis.AxisDependency.LEFT);

        for (int i = 1; i < n; i++) {
            entries3.add(new Entry((float)i, (float)(mistake(0.4, i,1))));
        }
        LineDataSet dataset3 = new LineDataSet(entries3, "BLUR0.4");
        dataset3.setCircleColor(Color.parseColor("#FFD700"));
        dataset3.setColors(Color.parseColor("#FFD700"));
        dataset3.setAxisDependency(YAxis.AxisDependency.LEFT);

        for (int i = 1; i < n; i++) {
            entries4.add(new Entry((float)i, (float)(mistake(0.8, i,1))));
        }
        LineDataSet dataset4 = new LineDataSet(entries4, "BLUR0.8");
        dataset4.setCircleColor(Color.parseColor("#FF9642"));
        dataset4.setColors(Color.parseColor("#FF9642"));
        dataset4.setAxisDependency(YAxis.AxisDependency.LEFT);

        for (int i = 1; i < n; i++) {
            entries5.add(new Entry((float)i, (float)(mistake(1.1, i,1))));
        }
        LineDataSet dataset5 = new LineDataSet(entries5, "BLUR1.1");

        dataset5.setCircleColor(Color.parseColor("#990066"));
        dataset5.setColors(Color.parseColor("#990066"));
        dataset5.setAxisDependency(YAxis.AxisDependency.LEFT);

        for (int i = 1; i < n; i++) {
            entries6.add(new Entry((float)i, (float)(mistake(1.4, i,1))));
        }
        LineDataSet dataset6 = new LineDataSet(entries6, "BLUR1.4");
        dataset6.setCircleColor(Color.parseColor("#00FFFF"));
        dataset6.setColors(Color.parseColor("#00FFFF"));
        dataset6.setAxisDependency(YAxis.AxisDependency.LEFT);

        for (int i = 1; i < n; i++) {
            entries7.add(new Entry((float)i, (float)(mistake(1.758, i,1))));
        }
        LineDataSet dataset7 = new LineDataSet(entries7, "BLUR0.1.758");
        dataset7.setCircleColor(Color.parseColor("#8DB600"));
        dataset7.setColors(Color.parseColor("#8DB600"));
        dataset7.setAxisDependency(YAxis.AxisDependency.LEFT);

        for (int i = 1; i < n; i++) {
            entries8.add(new Entry((float)i, (float)(mistake(1.99, i,1))));
        }
        LineDataSet dataset8 = new LineDataSet(entries8, "BLUR1.99");
        dataset8.setCircleColor(Color.parseColor("#3B444B"));
        dataset8.setColors(Color.parseColor("#3B444B"));
        dataset8.setAxisDependency(YAxis.AxisDependency.LEFT);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataset2);
        dataSets.add(dataset3);
        dataSets.add(dataset4);
        dataSets.add(dataset5);
        dataSets.add(dataset6);
        dataSets.add(dataset7);
        dataSets.add(dataset8);

        LineChart Graphblur = (LineChart) findViewById(R.id.Graphblur);
        LineData data2 = new LineData(dataSets);
        Graphblur.setData(data2);
        Graphblur.invalidate();

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityThree.this, ActivitySeven.class);
                startActivity(intent);
            }
        });




    }
}
