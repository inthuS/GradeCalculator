package com.ut.gradecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewReportActivity extends AppCompatActivity {

    TextView iosValue;
    TextView androidValue;
    TextView swiftValue;
    TextView javaValue;
    TextView reportValue;
    TextView reportType;


    private static String TAG = "GradeCalculator";
    private Bundle bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);
        iosValue = findViewById(R.id.ios_value);
        iosValue.setText(getIntent().getExtras().getString("iosValue"));
        androidValue = findViewById(R.id.android_value);
        androidValue.setText(getIntent().getExtras().getString("androidValue"));
        swiftValue = findViewById(R.id.swift_value);
        swiftValue.setText(getIntent().getExtras().getString("swiftValue"));
        javaValue = findViewById(R.id.java_value);
        javaValue.setText(getIntent().getExtras().getString("javaValue"));
        reportValue = findViewById(R.id.report_value);
        reportValue.setText(getIntent().getExtras().getString("reportValue"));
        reportType = findViewById(R.id.report_type);
        reportType.setText(getIntent().getExtras().getString("reportType"));
    }
/*
    private void setGrade(String name, int id) {

    }
*/
}
