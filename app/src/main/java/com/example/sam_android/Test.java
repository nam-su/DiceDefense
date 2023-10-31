package com.example.sam_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Test extends AppCompatActivity {

    ProgressBar progressBar;
    Button btn_testP;
    Button btn_testP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        progressBar = (ProgressBar) findViewById(R.id.pB_test);
        btn_testP = (Button) findViewById(R.id.btn_test1);
        btn_testP2 = (Button) findViewById(R.id.btn_test2);

        progressBar.setMax(60);
        progressBar.setProgress(0);



        btn_testP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.incrementProgressBy(10);
            }
        });


        btn_testP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.incrementProgressBy(-10);
            }
        });




    }
}