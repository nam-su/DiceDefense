package com.example.sam_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Activity_Ranking extends AppCompatActivity implements Serializable {
    RecyclerView recyclerView;
    MyAdapter adapter;
    //    String addId;
//
//    String addScore;
//
//    String addImageS;
//
//    int addImage;
    Button btn_check;

    Button btn_modify;
    Intent getIntent;

    SharedPreferences preferences;
    String resultSCORE;
    String resultID;
    ArrayList<UserData> listData = new ArrayList<>();
    String TAG = "Ranking.rank";
    String check;
    String[] ID_list;
    String[] SCORE_list;
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        adapter = new MyAdapter();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        preferences = getSharedPreferences("userData", MODE_PRIVATE);

        getIntent = getIntent();
        String id = getIntent.getStringExtra("아이디");


        if(preferences != null && !preferences.getString("유저 아이디", "").equals("")) {

            resultSCORE = preferences.getString("유저 점수", "");
            resultID = preferences.getString("유저 아이디", "");
            Log.d(TAG, " 쉐어드에서 아이디랑 점수 받아옴" + resultID + resultSCORE);
            ID_list = resultID.split(",");
            SCORE_list = resultSCORE.split(",");


            Log.d(TAG, "받은걸 찢음" + Arrays.toString(ID_list) + Arrays.toString(SCORE_list));





            for (int i = 0; i < ID_list.length; i++) {
                UserData userData = new UserData();
                userData.setUserId(ID_list[i]);
                userData.setScore(SCORE_list[i]);
                listData.add(userData);
                Log.d(TAG, "반복하면서 이름값불러옴" + userData.getUserId());

            }

            Collections.sort(listData);

            Log.d(TAG, "add 다한 리스트임 " + listData);

            adapter.listData = listData;
        }



        btn_check = (Button) findViewById(R.id.btn_check);

//        btn_modify = adapter.btn_modify;

        recyclerView = (RecyclerView) findViewById(R.id.rv_ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        getIntent = getIntent();

        if (getIntent.getSerializableExtra("Array") != null) {

            Log.d(TAG, "배열 비어있는지 확인");
            listData = (ArrayList<UserData>) getIntent.getSerializableExtra("Array");
            adapter.listData = listData;
            Log.d(TAG, "리사이클러뷰 액티비티에서 배열 받아온거 확인" + listData);
        }

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Activity_Ranking.this , Activity_StageChoice.class);
//                intent.putExtra("아이디",id);


                finish();
            }
        });
//                           추가는 회원가입을 통해 자동으로 진행하게 해놨음.

//        btn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//                Intent intent = new Intent(Activity_Ranking.this, Activity_Rank_input_Data.class);
//                intent.putExtra("Array", listData);
////               Log.d(TAG, "런치 인텐트 발동");
//                startActivity(intent);
//               launcher.launch(intent);
//            }
//        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
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
    // registerforActivityresult를 이용해서 리사이클러뷰 쌓기
//        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            result -> {
//               // 서브 액티비티로 부터 돌아올 때의 서브엑티비티에서 벌어진 어떠한 결과값을 받아 올 수 있는 통로
//                if(result.getResultCode() == RESULT_OK){
//
//                    addId = result.getData().getStringExtra("추가 아이디");
//                   addScore = result.getData().getStringExtra("추가 점수");
//                   addImageS = result.getData().getStringExtra("추가 프로필");
//                    Log.d(TAG, "추가 액티비티에서  데이터 받아옴 : "+addId+"/"+addScore+"/"+addImageS);
//
//                    addImage = Integer.parseInt(addImageS);
//                    UserData userData = new UserData();
//                    userData.setUserId(addId);
//                    userData.setScore(addScore);
//                    userData.setProfile(addImage);
//
//                    adapter.addItem(userData);
//
//                    adapter.notifyDataSetChanged();
//                }
//            }
//    );

}