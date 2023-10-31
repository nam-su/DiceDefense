package com.example.sam_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class Activity_Rank_input_Data extends AppCompatActivity implements Serializable {

    MyAdapter adapter;

    EditText et_inputId_inItem;
    EditText et_inputScore_inItem;

    Button btn_addCheck;
    Button btn_addCancel;
    ArrayList<UserData> listData = new ArrayList<>();
    SharedPreferences preferences;

    int inputProfile = R.drawable.ic_launcher_foreground;
    String inputProfileS;
    String inputId;
    String inputScore;
    String check;
    String TAG ="Rank_input_Data.rank";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_input_data);

//        preferences = getSharedPreferences("유저 데이터",MODE_PRIVATE);

        Intent getIntent = getIntent();
        listData = (ArrayList<UserData>) getIntent.getSerializableExtra("Array");

        et_inputId_inItem = (EditText) findViewById(R.id.et_inputId_inItem);
        et_inputScore_inItem = (EditText) findViewById(R.id.et_inputScore_inItem);

        btn_addCancel = (Button) findViewById(R.id.btn_addCancel);
        btn_addCheck = (Button) findViewById(R.id.btn_addCheck);

        inputProfileS = Integer.toString(inputProfile);

        btn_addCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity_Ranking.class);
                UserData userData = new UserData();
                inputId = et_inputId_inItem.getText().toString();
                inputScore = et_inputScore_inItem.getText().toString();

                userData.setUserId(inputId);
                userData.setScore(inputScore);
                userData.setProfile(inputProfile);
                Log.d(TAG, "추가버튼으로 배열에 데이터를 보냄 : "+listData+"/"+userData.getScore()+"/"+userData.getProfile());

                listData.add(userData);

                Log.d(TAG, "추가버튼으로 배열에 데이터를 보냄 : "+userData.getUserId()+"/"+userData.getScore()+"/"+userData.getProfile());

                intent.putExtra("Array",listData);

                Log.d(TAG, "보낼 배열 있는지 확인"+listData);

                startActivity(intent);
                finish();
//
//                Intent intent = new Intent();
//
//                intent.putExtra("추가 아이디",inputId);
//
//                intent.putExtra("추가 점수",inputScore);
//
//                intent.putExtra("추가 프로필",inputProfileS);
//
//                Log.d(TAG, "추가버튼으로 데이터를 보냄 : "+inputId+"/"+inputScore+"/"+inputProfileS);
//
//                setResult(RESULT_OK,intent);
//                finish();
            }
        });
        btn_addCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}