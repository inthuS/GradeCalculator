package com.ut.gradecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import java.lang.Math;
import android.util.Log;

public class MainActivity extends AppCompatActivity //implements View.OnClickListener
{

    EditText iosGrade;
    EditText androidGrade;
    EditText swiftGrade;
    EditText javaGrade;
    String reportValue;
    String reportType;
    private final static String TAG = "GradeCalculator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iosGrade = findViewById(R.id.ios_grade);
        androidGrade = findViewById(R.id.android_grade);
        swiftGrade = findViewById(R.id.swift_grade);
        javaGrade = findViewById(R.id.java_grade);


    }

    public void onClick(View v) {

        Intent intent = new Intent ( MainActivity.this, ViewReportActivity.class);
        intent.putExtra("iosValue",iosGrade.getText().toString());
        intent.putExtra("androidValue",androidGrade.getText().toString());
        intent.putExtra("swiftValue",swiftGrade.getText().toString());
        intent.putExtra("javaValue",javaGrade.getText().toString());

        switch (v.getId()) {
            case R.id.max_button:
                reportValue = getMax();
                reportType = "MAX";
                Log.i("MyApp","MAX selected");
                break;
            case R.id.min_button:
                reportValue = getMin();
                reportType = "MIN";
                Log.i("MyApp","MIN selected");
                break;
            case R.id.avg_button:
                reportValue = getAverage();
                reportType = "AVG";
                Log.i("MyApp","AVG selected");
                break;
        }
        intent.putExtra("reportValue",reportValue);
        intent.putExtra("reportType",reportType);

        Log.i("MyApp","get report");

        startActivity(intent);
    }

/*
    private void generateReport(int id) {

    }

    private String getGrade(int id) {

    }
*/
    private String getAverage() {
        int iosGr = Integer.parseInt(iosGrade.getText().toString());
        int androidGr = Integer.parseInt(androidGrade.getText().toString());
        int swiftGr = Integer.parseInt(swiftGrade.getText().toString());
        int javaGr = Integer.parseInt(javaGrade.getText().toString());
        double avg = ( iosGr + androidGr + swiftGr + javaGr ) / 4.0;
        return String.valueOf(avg);
    }

    private String getMax() {
        int iosGr = Integer.parseInt(iosGrade.getText().toString());
        int androidGr = Integer.parseInt(androidGrade.getText().toString());
        int swiftGr = Integer.parseInt(swiftGrade.getText().toString());
        int javaGr = Integer.parseInt(javaGrade.getText().toString());
        return String.valueOf(Math.max( Math.max( iosGr , androidGr) , Math.max( swiftGr , javaGr) ));
    }

    private String getMin() {
        int iosGr = Integer.parseInt(iosGrade.getText().toString());
        int androidGr = Integer.parseInt(androidGrade.getText().toString());
        int swiftGr = Integer.parseInt(swiftGrade.getText().toString());
        int javaGr = Integer.parseInt(javaGrade.getText().toString());
        return String.valueOf(Math.min( Math.min( iosGr , androidGr) , Math.min( swiftGr , javaGr) ));
    }

}
