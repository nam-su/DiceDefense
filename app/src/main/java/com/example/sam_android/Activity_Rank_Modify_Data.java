package com.example.sam_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Rank_Modify_Data extends AppCompatActivity {
    String TAG = "Rank_Modify_Data";
    EditText et_modifyId_inItem;
    EditText et_modifyScore_inItem;
    Button btn_modifyCheck;
    Button btn_modifyCancel;
    ArrayList<UserData> listData = new ArrayList<>();

    String id;
    String password;
    String score;

    SharedPreferences preferences;
    int p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_modify_data);

        preferences = getSharedPreferences("userData",MODE_PRIVATE);

        et_modifyId_inItem = (EditText) findViewById(R.id.et_modifyId_inItem);
        et_modifyScore_inItem = (EditText) findViewById(R.id.et_modifyScore_inItem);

        btn_modifyCheck = (Button) findViewById(R.id.btn_modifyCheck);
        btn_modifyCancel = (Button) findViewById(R.id.btn_modifyCancel);

        Intent getIntent = getIntent();

        p = getIntent.getIntExtra("positionNum",0);

        listData = (ArrayList<UserData>) getIntent.getSerializableExtra("Array");

        et_modifyScore_inItem.setText(listData.get(p).getScore());
        et_modifyId_inItem.setText(listData.get(p).getUserId());
        btn_modifyCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "수정버튼 눌렀음");
                id = preferences.getString("유저 아이디","");
                password = preferences.getString("유저 비밀번호","");
                score = preferences.getString("유저 점수","");

                SharedPreferences.Editor editor = preferences.edit();




                    String[] idS = id.split(",");
                    String[] passwordS = password.split(",");
                    String[] scoreS = score.split(",");


                    idS[p] = et_modifyId_inItem.getText().toString();
                    scoreS[p] = et_modifyScore_inItem.getText().toString();

                    Log.d(TAG, "onClick: 아이디 찢은거에서 포지션과 일치하는값 수정함" + idS[p]);
                    Log.d(TAG, "onClick: 점수 찢은거에서 포지션과 일치하는값 수정함" + scoreS[p]);
                    id = "";
                    score = "";
                    for (int i = 0; i < idS.length; i++) {

                        if (i == 0) {

                            id = id + idS[i];
                            score = score + scoreS[i];
                            Log.d(TAG, "onClick: 1번 찍혀야되는 로그임");
                        } else {
                            id = id + "," + idS[i];
                            score = score + "," + scoreS[i];

                        }
                    }
                    Log.d(TAG, "onClick: 반복후 아이디 출력" + id);
                    Log.d(TAG, "onClick: 반복후 스코어 출력" + score);
//                listData.get(p).setUserId(et_modifyId_inItem.getText().toString());
                    //listData.get(p).setScore(et_modifyScore_inItem.getText().toString());
                    editor.putString("유저 아이디", id);
                    editor.putString("유저 점수", score);
                    Intent intent = new Intent(getApplicationContext(), Activity_Ranking.class);
//                intent.putExtra("Array",listData);
                    editor.commit();
                    startActivity(intent);
                    finish();

            }
        });

        btn_modifyCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


//        listData.get(p).setUserId(et_modifyId_inItem.getText().toString());
//        listData.get(p).setScore(et_modifyScore_inItem.getText().toString());





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
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
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