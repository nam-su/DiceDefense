package com.example.sam_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_StageChoice extends AppCompatActivity {
    Button btn_choiceStage1;
    Button btn_back;
    Button btn_ranking;
    Button btn_tutorial;
    Button btn_InfinityMod;
    String TAG = "StageChoice.life";
    String userID;
    TextView tv_introduce;

    SharedPreferences AutoLoginPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_choice);
        setView();

        Intent intent = getIntent();

        userID = intent.getStringExtra("아이디");
        AutoLoginPreferences = getSharedPreferences("autoLogin", MODE_PRIVATE);


        tv_introduce.setText(userID+"님 환영합니다.");

        btn_ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Activity_Ranking.class);
                intent.putExtra("아이디",userID);
                startActivity(intent);


            }
        });


        btn_choiceStage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Activity_Stage1.class);
                intent.putExtra("아이디",userID);


                startActivity(intent);

            }
        });

        btn_InfinityMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_StageChoice.this,Activity_InfinityStage.class);
                intent.putExtra("아이디",userID);


                startActivity(intent);


            }
        });




        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Activity_Title.class);
                intent.putExtra("아이디",userID);
                SharedPreferences.Editor AutoLoginEditor = AutoLoginPreferences.edit();
                AutoLoginPreferences.getString("autoID","");
                AutoLoginPreferences.getString("autoPASSWORD","");

                AutoLoginEditor.putString("autoID","");
                AutoLoginEditor.putString("autoPASSWORD","");
                AutoLoginEditor.commit();

                startActivity(intent);

            }
        });

        btn_tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity_Tutorial.class);
                intent.putExtra("아이디",userID);


                startActivity(intent);



            }
        });




    }

    @Override
    protected void onStart() {
        Log.e(TAG,"onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG,"onResume");
        super.onResume();


    }

    @Override
    protected void onPause() {
        Log.e(TAG,"onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG,"onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG,"onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }
    void setView(){
        btn_back =(Button) findViewById(R.id.btn_back);
        btn_InfinityMod = (Button) findViewById(R.id.btn_InfinityMod);
        btn_ranking = (Button) findViewById(R.id.btn_ranking);
        btn_choiceStage1 = (Button) findViewById(R.id.btn_normalMod);
        btn_tutorial = (Button) findViewById(R.id.btn_tutorial);
        tv_introduce = (TextView)findViewById(R.id.userName);
    }
}