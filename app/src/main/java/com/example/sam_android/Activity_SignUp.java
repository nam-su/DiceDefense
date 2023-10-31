package com.example.sam_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_SignUp extends AppCompatActivity {
    EditText et_signUpId;
    EditText et_signUpPassword;

    String resultSCORE;
    String userID;
    String resultID;
    String userPASSWORD;
    String resultPASSWORD;

    String checkID;


    boolean checkDuplicate = false;

    String TAG = "SignUp.life";


    ArrayList<UserData> listData = new ArrayList<>();

    Button btn_checkDuplicates;
    Button btn_signUpCancel;
    Button btn_signUpCheck;

    SharedPreferences preferences;

    String onTextChanged;
    String afterTextChanged;
    String beforeTextChanged;

    boolean a = false;
    boolean b = false;
    boolean c = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setView();


        preferences = getSharedPreferences("userData", MODE_PRIVATE);

        resultSCORE = preferences.getString("유저 점수","");
        resultID = preferences.getString("유저 아이디", "");
        resultPASSWORD = preferences.getString("유저 비밀번호", "");

        et_signUpId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "beforeTextChanged: " + et_signUpId.getText());
                beforeTextChanged = et_signUpId.getText().toString();
                a = false;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: " + et_signUpId.getText());
                onTextChanged = et_signUpId.getText().toString();
                b = false;
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: " + et_signUpId.getText());
                afterTextChanged = et_signUpId.getText().toString();
                c = false;
            }
        });
        

        btn_signUpCancel.setOnClickListener(new View.OnClickListener() { // 취소버튼
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Activity_Title.class);
            startActivity(intent);
            }
        });


        btn_checkDuplicates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userID = et_signUpId.getText().toString();
                
                checkDuplicate = false;
                a = true;
                b = true;
                c = true;

                if(userID.equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),"아이디를 입력하셔야 합니다.",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(userID.contains(",")){
                    Toast toast = Toast.makeText(getApplicationContext()," \",\" 는 사용할 수 없는 기호입니다.",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(resultID.contains(userID)){
                    Toast toast = Toast.makeText(getApplicationContext(),"이미 존재하는 아이디 입니다",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"사용 가능한 아이디 입니다",Toast.LENGTH_SHORT);
                    toast.show();
                    checkID = userID;
                    checkDuplicate = true;
                }
                Log.d(TAG, "중복확인 : " +checkDuplicate);
            }
        });


        btn_signUpCheck.setOnClickListener(new View.OnClickListener() { //회원 가입 창에서 확인 버튼을 눌렀을 때
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                Intent intent = new Intent(getApplicationContext(), Activity_Title.class);


                userID = et_signUpId.getText().toString();
                userPASSWORD = et_signUpPassword.getText().toString();

                if(userID.equals("") && userPASSWORD.equals("")){
                    
                    Toast toast = Toast.makeText(getApplicationContext(),"사용할 아이디와 비밀번호를 입력하셔야 합니다.",Toast.LENGTH_SHORT);
                    toast.show();
                    
                }
                else if(userID.equals("")){
                    
                    Toast toast = Toast.makeText(getApplicationContext(),"사용할 아이디를 입력하셔야 합니다.",Toast.LENGTH_SHORT);
                    toast.show();
                    
                }
                else if(userPASSWORD.equals("")){
                    
                    Toast toast = Toast.makeText(getApplicationContext(),"사용할 비밀번호를 입력하셔야 합니다.",Toast.LENGTH_SHORT);
                    toast.show();
                    
                }
                else if(checkDuplicate && !checkID.equals(userID)){
                    
                    Toast toast = Toast.makeText(getApplicationContext(),"아이디 중복확인을 해주세요",Toast.LENGTH_SHORT);
                    toast.show();
                    
                }
                
                else if(checkDuplicate && checkID.equals(userID) && a && b && c){
                    if(resultID.equals("")){
                        resultID = userID;

                    }
                    else {
                        resultID += ","+ userID;

                    }


                    if(resultPASSWORD.equals("")){
                        resultPASSWORD = userPASSWORD;
                    }
                    else {
                        resultPASSWORD += "," + userPASSWORD;
                    }

                    if(resultSCORE.equals("")){
                        resultSCORE = "0";
                    }
                    else{
                        
                        resultSCORE += "," + "0";

                    }


                    editor.putString("유저 아이디",resultID);
                    editor.putString("유저 비밀번호",resultPASSWORD);
                    editor.putString("유저 점수",resultSCORE);

                    editor.commit();
                    startActivity(intent);

                }
                else if(!checkDuplicate){
                    
                    Toast toast = Toast.makeText(getApplicationContext(),"아이디 중복확인을 해주세요",Toast.LENGTH_SHORT);
                    toast.show();

                } else if(checkDuplicate && !a && !b && !c){
                    Toast toast = Toast.makeText(getApplicationContext(),"아이디 중복확인을 해주세요",Toast.LENGTH_SHORT);
                    toast.show();

                }
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
    protected void onDestroy() {
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG,"onRestart");
        super.onRestart();
    }

    public void setView(){
        et_signUpId = (EditText) findViewById(R.id.et_signUpId);
        et_signUpPassword = (EditText) findViewById(R.id.et_signUpPassword);

        btn_checkDuplicates = (Button) findViewById(R.id.btn_checkDuplicates);
        btn_signUpCancel = (Button) findViewById(R.id.btn_signUpCancel);
        btn_signUpCheck = (Button) findViewById(R.id.btn_signUpCheck);
        
        
    }
}