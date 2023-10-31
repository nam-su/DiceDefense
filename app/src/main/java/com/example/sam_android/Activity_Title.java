package com.example.sam_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Activity_Title extends AppCompatActivity {
    String TAG = "Title.life";
    ImageView iv_titleDice;
    EditText et_password;
    EditText et_login;

    TextView tv_id;
    TextView tv_password;
    TextView textView3;
    TextView textView4;
    TextView tv_autoLogout;

    Button btn_signUp;
    Button loginButton;
    Button btn_autoLogin;


    String inputID;
    String inputPassword;
    String id;
    String password;

    int index = 0;
    SharedPreferences preferences;

    SharedPreferences AutoLoginPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);


        AutoLoginPreferences = getSharedPreferences("autoLogin", MODE_PRIVATE);
        preferences = getSharedPreferences("userData", MODE_PRIVATE);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.title_rotate);
        iv_titleDice = (ImageView) findViewById(R.id.iv_titleDice);
        iv_titleDice.startAnimation(animation);
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_password = (TextView) findViewById(R.id.tv_password);
        et_login = (EditText) findViewById(R.id.et_login);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_signUp = (Button) findViewById(R.id.btn_signUp);
        loginButton = (Button) findViewById(R.id.loginButton);
        btn_autoLogin = (Button) findViewById(R.id.btn_autoLogin);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        tv_autoLogout = (TextView) findViewById(R.id.tv_autoLogout);
        btn_autoLogin.setEnabled(false);
        tv_autoLogout.setEnabled(false);
        if (!AutoLoginPreferences.getString("autoID", "").equals("")) {
            Log.d(TAG, "onCreate: 오토 로그인 null 아닐때 ");

            et_login.setVisibility(View.INVISIBLE);
            et_password.setVisibility(View.INVISIBLE);
            tv_password.setVisibility(View.INVISIBLE);
            tv_id.setVisibility(View.INVISIBLE);
            btn_signUp.setVisibility(View.INVISIBLE);
            loginButton.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);
            btn_autoLogin.setVisibility(View.VISIBLE);
            tv_autoLogout.setVisibility(View.VISIBLE);
            btn_autoLogin.setEnabled(true);
            tv_autoLogout.setEnabled(true);
        }


            btn_autoLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Activity_Title.this, Activity_StageChoice.class);
                    inputID = AutoLoginPreferences.getString("autoID", "");

                    intent.putExtra("아이디", inputID);

                    startActivity(intent);
                    finish();

                }
            });


            tv_autoLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    et_login.setVisibility(View.VISIBLE);
                    et_password.setVisibility(View.VISIBLE);
                    tv_password.setVisibility(View.VISIBLE);
                    tv_id.setVisibility(View.VISIBLE);
                    btn_signUp.setVisibility(View.VISIBLE);
                    loginButton.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                    textView4.setVisibility(View.VISIBLE);
                    btn_autoLogin.setVisibility(View.INVISIBLE);
                    btn_autoLogin.setEnabled(false);
                    tv_autoLogout.setVisibility(View.INVISIBLE);
                    tv_autoLogout.setEnabled(false);

                }
            });


            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                id = getIntent.getStringExtra("아이디");
                    id = preferences.getString("유저 아이디", "");
                    password = preferences.getString("유저 비밀번호", "");


                    String[] idS = id.split(",");
                    String[] passwordS = password.split(",");


                    Log.d(TAG, "onClick: 아이디 스플릿한거 합치기?" + Arrays.toString(idS)); // 쉐어드에 저장된 스트링값을 split한 후 다시 합치기?
                    Log.d(TAG, "onClick: 비밀번호 스플릿한거 합치기?" + Arrays.toString(passwordS));
                    Log.d(TAG, "onClick: 쉐어드에서 가져온데이터" + id);
                    Log.d(TAG, "onClick: 쉐어드에서 가져온 비밀번호" + password);


                    inputID = et_login.getText().toString();
                    inputPassword = et_password.getText().toString();


                    for (int i = 0; i < idS.length; i++) { // 배열 순회

                        Log.d(TAG, "onClick: 반복문 실행");

                        if (idS[i].equals(inputID)) { //순회한 배열에서 일치하는지 안일치 하는지
                            Log.d(TAG, "for문 안에서 조건만족: " + index);
                            index = i;
                        }
                    }

                    Log.d(TAG, "onClick: " + index);
                    Log.d(TAG, "onClick: 비밀번호 인덱스 넣어줌" + passwordS[index]);

                    if (inputID.equals("")) {

                        Log.e(TAG, "로그인 버튼 클릭 후 입력값 없을때");

                        Toast toast = Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT);
                        toast.show();
                    } else if (idS[index].equals(inputID)) {
                        if (passwordS[index].equals(inputPassword)) { //아이디 인덱스에 맞는 비밀번호 인덱스값을 가져온다.

                            Log.e("Title", "아이디 비밀번호 일치");

                            Intent intent = new Intent(Activity_Title.this, Activity_StageChoice.class);

                            AutoLoginPreferences.getString("autoID", "");
                            AutoLoginPreferences.getString("autoPASSWORD", "");
                            SharedPreferences.Editor AutoLoginEditor = AutoLoginPreferences.edit();

                            AutoLoginEditor.putString("autoID", idS[index]);
                            AutoLoginEditor.putString("autoPASSWORD", passwordS[index]);
                            AutoLoginEditor.commit();

                            intent.putExtra("아이디", inputID);
                            intent.putExtra("비밀번호", inputPassword);


                            startActivity(intent);
                            finish();

                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 잘못되었습니다.", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    } else { // 회원 가입 에서 가져온 데이터 가 일치 하지 않을 때
                        Log.d(TAG, "onClick: 쉐어드에서 가져온 아이디가 일치하지 않는다.");
                        Toast toast = Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 잘못되었습니다.", Toast.LENGTH_SHORT);
                        toast.show();

                    }

                }
            });

            //a

            btn_signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Activity_SignUp.class);
                    startActivity(intent);
                    finish();
                }
            });


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

}