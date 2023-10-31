package com.example.sam_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Activity_InfinityStage extends AppCompatActivity {

    SharedPreferences preferences;


    ImageView iv_battleField;
    ImageView iv_effectDice1_1;
    ImageView iv_effectDice1_2;
    ImageView iv_effectDice1_3;
    ImageView iv_effectDice1_4;
    ImageView iv_effectDice1_5;
    ImageView iv_effectDice1_6;
    ArrayList<ImageView> iv_effectDice1s = new ArrayList<>();
    ImageView iv_effectDice2_1;
    ImageView iv_effectDice2_2;
    ImageView iv_effectDice2_3;
    ImageView iv_effectDice2_4;
    ImageView iv_effectDice2_5;
    ImageView iv_effectDice2_6;
    ArrayList<ImageView> iv_effectDice2s = new ArrayList<>();

    ImageView iv_effectDice3_1;
    ImageView iv_effectDice3_2;
    ImageView iv_effectDice3_3;
    ImageView iv_effectDice3_4;
    ImageView iv_effectDice3_5;
    ImageView iv_effectDice3_6;
    ArrayList<ImageView> iv_effectDice3s = new ArrayList<>();
    ImageView iv_effectDice4_1;
    ImageView iv_effectDice4_2;
    ImageView iv_effectDice4_3;
    ImageView iv_effectDice4_4;
    ImageView iv_effectDice4_5;
    ImageView iv_effectDice4_6;
    ArrayList<ImageView> iv_effectDice4s = new ArrayList<>();

    ImageView iv_enemy1;
    ImageView iv_enemy2;
    ImageView iv_enemy3;
    ImageView iv_enemy4;
    ImageView iv_enemy5;
    ImageView iv_enemy6;
    ImageView iv_enemy7;
    ImageView iv_enemy8;
    ImageView iv_enemy9;
    ImageView iv_enemy10;
    ImageView iv_enemyBoss;
//    ImageView iv_test;

    TextView tv_startCount;
    //    TextView tv_gameCount;
    ProgressBar pb_gameCount;


    TextView tv_score;
    TextView tv_gold;
    TextView tv_stage;

    TextView tv_buyGold;
    TextView tv_sellGold;
    Handler handler = new Handler();
    Paint paint = new Paint();

    Button btn_create;
    Button btn_sell;

    Button btn_backStage1;
    Button btn_upgrade;

    String choiceType;
    String TAG = "Stage1.life";
    Dice dice1 = new Dice(Activity_InfinityStage.this);
    Dice dice2 = new Dice(Activity_InfinityStage.this);
    Dice dice3 = new Dice(Activity_InfinityStage.this);
    Dice dice4 = new Dice(Activity_InfinityStage.this);

    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Bitmap> enemyBitmaps = new ArrayList<>();
    ArrayList<Canvas> enemyCanvases = new ArrayList<>();
    int score;
    Enemy enemy1 = new Enemy();
    Enemy enemy2 = new Enemy();
    Enemy enemy3 = new Enemy();
    Enemy enemy4 = new Enemy();
    Enemy enemy5 = new Enemy();
    Enemy enemy6 = new Enemy();
    Enemy enemy7 = new Enemy();
    Enemy enemy8 = new Enemy();
    Enemy enemy9 = new Enemy();
    Enemy enemy10 = new Enemy();
    Enemy enemyBoss = new Enemy();

    Canvas canvas;
    Bitmap downBitmap;

    Canvas canvasEffectDice1_1;
    Canvas canvasEffectDice1_2;
    Canvas canvasEffectDice1_3;
    Canvas canvasEffectDice1_4;
    Canvas canvasEffectDice1_5;
    Canvas canvasEffectDice1_6;

    ArrayList<Canvas> canvasEffectDice1s = new ArrayList<>();

    Canvas canvasEffectDice2_1;
    Canvas canvasEffectDice2_2;
    Canvas canvasEffectDice2_3;
    Canvas canvasEffectDice2_4;
    Canvas canvasEffectDice2_5;
    Canvas canvasEffectDice2_6;
    ArrayList<Canvas> canvasEffectDice2s = new ArrayList<>();

    Canvas canvasEffectDice3_1;
    Canvas canvasEffectDice3_2;
    Canvas canvasEffectDice3_3;
    Canvas canvasEffectDice3_4;
    Canvas canvasEffectDice3_5;
    Canvas canvasEffectDice3_6;
    ArrayList<Canvas> canvasEffectDice3s = new ArrayList<>();

    Canvas canvasEffectDice4_1;
    Canvas canvasEffectDice4_2;
    Canvas canvasEffectDice4_3;
    Canvas canvasEffectDice4_4;
    Canvas canvasEffectDice4_5;
    Canvas canvasEffectDice4_6;
    ArrayList<Canvas> canvasEffectDice4s = new ArrayList<>();
    Bitmap effectBitmapDice1_1;
    Bitmap effectBitmapDice1_2;
    Bitmap effectBitmapDice1_3;
    Bitmap effectBitmapDice1_4;
    Bitmap effectBitmapDice1_5;
    Bitmap effectBitmapDice1_6;
    ArrayList<Bitmap> effectBitmapDice1s = new ArrayList<>();

    Bitmap effectBitmapDice2_1;
    Bitmap effectBitmapDice2_2;
    Bitmap effectBitmapDice2_3;
    Bitmap effectBitmapDice2_4;
    Bitmap effectBitmapDice2_5;
    Bitmap effectBitmapDice2_6;
    ArrayList<Bitmap> effectBitmapDice2s = new ArrayList<>();

    Bitmap effectBitmapDice3_1;
    Bitmap effectBitmapDice3_2;
    Bitmap effectBitmapDice3_3;
    Bitmap effectBitmapDice3_4;
    Bitmap effectBitmapDice3_5;
    Bitmap effectBitmapDice3_6;
    ArrayList<Bitmap> effectBitmapDice3s = new ArrayList<>();

    Bitmap effectBitmapDice4_1;
    Bitmap effectBitmapDice4_2;
    Bitmap effectBitmapDice4_3;
    Bitmap effectBitmapDice4_4;
    Bitmap effectBitmapDice4_5;
    Bitmap effectBitmapDice4_6;
    ArrayList<Bitmap> effectBitmapDice4s = new ArrayList<>();
    Canvas canvasEnemy1;
    Canvas canvasEnemy2;
    Canvas canvasEnemy3;
    Canvas canvasEnemy4;
    Canvas canvasEnemy5;
    Canvas canvasEnemy6;
    Canvas canvasEnemy7;
    Canvas canvasEnemy8;
    Canvas canvasEnemy9;
    Canvas canvasEnemy10;
    Canvas canvasEnemyBoss;

    Bitmap enemy1Bitmap;
    Bitmap enemy2Bitmap;
    Bitmap enemy3Bitmap;
    Bitmap enemy4Bitmap;
    Bitmap enemy5Bitmap;
    Bitmap enemy6Bitmap;
    Bitmap enemy7Bitmap;
    Bitmap enemy8Bitmap;
    Bitmap enemy9Bitmap;
    Bitmap enemy10Bitmap;
    Bitmap enemyBossBitmap;

    Toast toast;
    Random random = new Random();

    int stage = 1;
    int index;

    boolean[] creates = new boolean[4];
    Dice[] dices;


    Animation animation;
    Animation animationHpBar;
    Animation animationGold;
    EnemyMoveThread enemy1MoveThread;
    EnemyMoveThread enemy2MoveThread;
    EnemyMoveThread enemy3MoveThread;
    EnemyMoveThread enemy4MoveThread;
    EnemyMoveThread enemy5MoveThread;
    EnemyMoveThread enemy6MoveThread;
    EnemyMoveThread enemy7MoveThread;
    EnemyMoveThread enemy8MoveThread;
    EnemyMoveThread enemy9MoveThread;
    EnemyMoveThread enemy10MoveThread;
    EnemyMoveThread enemyBossMoveThread;

    AttackEnemyThread dice1AttackEnemyThread;
    AttackEnemyThread dice2AttackEnemyThread;
    AttackEnemyThread dice3AttackEnemyThread;
    AttackEnemyThread dice4AttackEnemyThread;

    EnemyHpThread enemyHpThread;

    StartCountThread startCountThread;
    StartGameCountThread startGameCountThread;
    Intent getIntent;


    int gold;
    String[] idS;
    String[] scoreS;
    String resultID;
    String resultSCORE;

    ArrayList<ProgressBar> enemyHpBars = new ArrayList<>();
    ArrayList<LinearLayout> enemyHpBarLayouts = new ArrayList<>();

    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;
    MediaPlayer mediaPlayer4;

    AlertDialog.Builder dialog;

    ConstraintLayout CL_normalMod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity_stage);
        setView();

        score = 0;

        mediaPlayer1 = new MediaPlayer();
        mediaPlayer1.setLooping(false);
        mediaPlayer2 = new MediaPlayer();
        mediaPlayer2.setLooping(false);
        mediaPlayer3 = new MediaPlayer();
        mediaPlayer3.setLooping(false);
        mediaPlayer4 = new MediaPlayer();
        mediaPlayer4.setLooping(false);


        String idData = getIntent.getStringExtra("아이디");


        preferences = getSharedPreferences("userData", MODE_PRIVATE);
        resultID = preferences.getString("유저 아이디", "");
        resultSCORE = preferences.getString("유저 점수", "");


        idS = resultID.split(",");
        scoreS = resultSCORE.split(",");


        for (int i = 0; i < idS.length; i++) { // 아이디 스플릿 한거 배열 순회


            if (idS[i].equals(idData)) { //순회한 배열에서 일치하는지 안일치 하는지
                Log.d(TAG, "for문 안에서 조건만족: " + index);
                index = i;
            }
        }
//        userScore = Integer.parseInt(scoreS[index]); // 유저의 점수값


        gold = 1000;

        for (int i = 0; i < 4; i++) {
            creates[i] = false;
        }


        canvas.drawRect(250, 325, 750, 975, paint);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ((!creates[0] || !creates[1] || !creates[2] || !creates[3]) && gold >= 200) {
                    animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                    tv_buyGold.setText("-200G");
                    tv_buyGold.startAnimation(animationGold);
                    String[] choiceTypes = new String[3];
                    choiceTypes[0] = "불";
                    choiceTypes[1] = "물";
                    choiceTypes[2] = "전기";
                    choiceType = choiceTypes[random.nextInt(3)];

                    if (!creates[0]) { // 지정한 첫번쨰 좌표에 주사위를 그린다.
                        gold -= 200;
                        tv_gold.setText("골드 : " + gold + "G");

                        Log.e(TAG, "첫번째 타워 설치");
                        creates[0] = true;
                        dice1.drawDice(canvas, choiceType, 375, 500);
                        Log.d(TAG, "dice1의 눈금(찍힌 숫자 +1) : " + dice1.choiceNum); //

                        dice1.name = "1번 주사위";
                        if (dice1.choiceType.equals("불")) {
                            mediaPlayer1 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.fire_dice_effect);
                            dice1AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer1, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice1s, handler, enemies, enemyCanvases, enemyBitmaps, dice1, canvasEffectDice1s, effectBitmapDice1s);
                            dice1AttackEnemyThread.start();
                        } else if (dice1.choiceType.equals("물")) {
                            mediaPlayer1 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.blue_dice_effect);
                            dice1AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer1, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice1s, handler, enemies, enemyCanvases, enemyBitmaps, dice1, canvasEffectDice1s, effectBitmapDice1s);
                            dice1AttackEnemyThread.start();
                        } else if (dice1.choiceType.equals("전기")) {
                            mediaPlayer1 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.yellow_dice_effect);
                            dice1AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer1, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice1s, handler, enemies, enemyCanvases, enemyBitmaps, dice1, canvasEffectDice1s, effectBitmapDice1s);
                            dice1AttackEnemyThread.start();
                        }


                    } else if (!creates[1]) {
                        gold -= 200;
                        tv_gold.setText("골드 : " + gold + "G");
                        creates[1] = true;
                        Log.e(TAG, "두번째 타워 설치");
                        dice2.drawDice(canvas, choiceType, 600, 800);
                        dice2.name = "2번 주사위";

                        if (dice2.choiceType.equals("불")) {
                            mediaPlayer2 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.fire_dice_effect);
                            dice2AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer2, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice2s, handler, enemies, enemyCanvases, enemyBitmaps, dice2, canvasEffectDice2s, effectBitmapDice2s);
                            dice2AttackEnemyThread.start();

                        } else if (dice2.choiceType.equals("물")) {
                            mediaPlayer2 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.blue_dice_effect);
                            dice2AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer2, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice2s, handler, enemies, enemyCanvases, enemyBitmaps, dice2, canvasEffectDice2s, effectBitmapDice2s);
                            dice2AttackEnemyThread.start();
                        } else if (dice2.choiceType.equals("전기")) {
                            mediaPlayer2 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.yellow_dice_effect);
                            dice2AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer2, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice2s, handler, enemies, enemyCanvases, enemyBitmaps, dice2, canvasEffectDice2s, effectBitmapDice2s);
                            dice2AttackEnemyThread.start();
                        }


                    } else if (!creates[2]) {
                        gold -= 200;
                        tv_gold.setText("골드 : " + gold + "G");
                        creates[2] = true;
                        Log.e(TAG, "세번째 타워 설치");
                        dice3.drawDice(canvas, choiceType, 600, 500);
                        dice3.name = "3번 주사위";

                        if (dice3.choiceType.equals("불")) {
                            mediaPlayer3 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.fire_dice_effect);
                            dice3AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer3, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice3s, handler, enemies, enemyCanvases, enemyBitmaps, dice3, canvasEffectDice3s, effectBitmapDice3s);
                            dice3AttackEnemyThread.start();
                        } else if (dice3.choiceType.equals("물")) {
                            mediaPlayer3 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.blue_dice_effect);
                            dice3AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer3, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice3s, handler, enemies, enemyCanvases, enemyBitmaps, dice3, canvasEffectDice3s, effectBitmapDice3s);
                            dice3AttackEnemyThread.start();
                        } else if (dice3.choiceType.equals("전기")) {
                            mediaPlayer3 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.yellow_dice_effect);
                            dice3AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer3, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice3s, handler, enemies, enemyCanvases, enemyBitmaps, dice3, canvasEffectDice3s, effectBitmapDice3s);
                            dice3AttackEnemyThread.start();
                        }

                    } else if (!creates[3]) {
                        gold -= 200;
                        tv_gold.setText("골드 : " + gold + "G");
                        creates[3] = true;
                        Log.e(TAG, "네번째 타워 설치");
                        dice4.name = "4번 주사위";
                        dice4.drawDice(canvas, choiceType, 375, 800);

                        if (dice4.choiceType.equals("불")) {
                            mediaPlayer4 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.fire_dice_effect);
                            dice4AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer4, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice4s, handler, enemies, enemyCanvases, enemyBitmaps, dice4, canvasEffectDice4s, effectBitmapDice4s);
                            dice4AttackEnemyThread.start();

                        } else if (dice4.choiceType.equals("물")) {
                            mediaPlayer4 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.blue_dice_effect);
                            dice4AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer4, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice4s, handler, enemies, enemyCanvases, enemyBitmaps, dice4, canvasEffectDice4s, effectBitmapDice4s);
                            dice4AttackEnemyThread.start();

                        } else if (dice4.choiceType.equals("전기")) {
                            mediaPlayer4 = MediaPlayer.create(Activity_InfinityStage.this, R.raw.yellow_dice_effect);
                            dice4AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer4, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice4s, handler, enemies, enemyCanvases, enemyBitmaps, dice4, canvasEffectDice4s, effectBitmapDice4s);
                            dice4AttackEnemyThread.start();
                        }


                    } else { // 주사위 4개 다 소환함 -> 토스트 메시지나옴
                        if (creates[0] && creates[1] && creates[2] && creates[3] && gold >= 200) {
                            Toast toast = Toast.makeText(Activity_InfinityStage.this, "더이상 소환할 수 없습니다.", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    }
                } else if (gold < 200) {
                    Toast toast = Toast.makeText(Activity_InfinityStage.this, "골드가 부족해서 만들 수 없습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        btn_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "판매 버튼 눌렀음");
                //4가지 불리안중 하나가 켜지게 로직 짤것.


                if (creates[0] || creates[1] || creates[2] || creates[3]) {
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    int count = 0;
                    for (int i = 0; i < creates.length; i++) {

                        if (creates[i]) {

                            arrayList.add(i);
                            count += 1;
                        }

                    }

                    int index = arrayList.get(random.nextInt(count));
                    creates[index] = false;

                    dices[index].sellDice(canvas, choiceType, dices[index].x, dices[index].y);
                    if (dices[index] == dice1) { // 1번 주사위 팔릴때
                        Log.d(TAG, "dice1 팔리고 interrupt");
                        mediaPlayer1.stop();
                        if (dice1.choiceNum == 0) {  // 1눈금 주사위 팔릴때
                            gold += 100;
                            tv_sellGold.setText("+100G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice1.choiceNum == 1) { // 2눈금 주사위 팔릴때
                            gold += 200;
                            tv_sellGold.setText("+200G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice1.choiceNum == 2) { // 3눈금 주사위 팔릴때
                            gold += 300;
                            tv_sellGold.setText("+300G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice1.choiceNum == 3) { // 4눈금 주사위 팔릴때
                            gold += 400;
                            tv_sellGold.setText("+400G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice1.choiceNum == 4) { // 5눈금 주사위 팔릴때
                            gold += 500;
                            tv_sellGold.setText("+500G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice1.choiceNum == 5) { // 6눈금 주사위 팔릴때
                            gold += 600;
                            tv_sellGold.setText("+600G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        }

                        dice1AttackEnemyThread.interrupt();

                    } else if (dices[index] == dice2) { //2번 주사위 팔릴때
                        mediaPlayer2.stop();
                        if (dice2.choiceNum == 0) {  // 1눈금 주사위 팔릴때

                            gold += 100;
                            tv_sellGold.setText("+100G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice2.choiceNum == 1) { // 2눈금 주사위 팔릴때

                            gold += 200;
                            tv_sellGold.setText("+200G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice2.choiceNum == 2) { // 3눈금 주사위 팔릴때

                            gold += 300;
                            tv_sellGold.setText("+300G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice2.choiceNum == 3) { // 4눈금 주사위 팔릴때

                            gold += 400;
                            tv_sellGold.setText("+400G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice2.choiceNum == 4) { // 5눈금 주사위 팔릴때

                            gold += 500;
                            tv_sellGold.setText("+500G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice2.choiceNum == 5) { // 6눈금 주사위 팔릴때

                            gold += 600;
                            tv_sellGold.setText("+600G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        }
                        Log.d(TAG, "dice2 팔리고 interrupt");
                        dice2AttackEnemyThread.interrupt();

                    } else if (dices[index] == dice3) {    // 3번 주사위 팔릴때
                        mediaPlayer3.stop();
                        if (dice3.choiceNum == 0) {  // 1눈금 주사위 팔릴때

                            gold += 100;
                            tv_sellGold.setText("+100G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice3.choiceNum == 1) { // 2눈금 주사위 팔릴때

                            gold += 200;
                            tv_sellGold.setText("+200G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice3.choiceNum == 2) { // 3눈금 주사위 팔릴때

                            gold += 300;
                            tv_sellGold.setText("+300G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice3.choiceNum == 3) { // 4눈금 주사위 팔릴때

                            gold += 400;
                            tv_sellGold.setText("+400G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice3.choiceNum == 4) { // 5눈금 주사위 팔릴때

                            gold += 500;
                            tv_sellGold.setText("+500G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                        } else if (dice3.choiceNum == 5) { // 6눈금 주사위 팔릴때

                            gold += 600;
                            tv_sellGold.setText("+600G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        }
                        Log.d(TAG, "dice3 팔리고 interrupt");
                        dice3AttackEnemyThread.interrupt();

                    } else if (dices[index] == dice4) { // 4번주사위 팔릴때
                        mediaPlayer4.stop();
                        if (dice4.choiceNum == 0) {  // 1눈금 주사위 팔릴때
                            gold += 100;
                            tv_sellGold.setText("+100G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice4.choiceNum == 1) { // 2눈금 주사위 팔릴때
                            gold += 200;
                            tv_sellGold.setText("+200G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice4.choiceNum == 2) { // 3눈금 주사위 팔릴때
                            gold += 300;
                            tv_sellGold.setText("+300G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice4.choiceNum == 3) { // 4눈금 주사위 팔릴때
                            gold += 400;
                            tv_sellGold.setText("+400G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice4.choiceNum == 4) { // 5눈금 주사위 팔릴때
                            gold += 500;
                            tv_sellGold.setText("+500G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        } else if (dice4.choiceNum == 5) { // 6눈금 주사위 팔릴때
                            gold += 600;
                            tv_sellGold.setText("+600G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                        }
                        Log.d(TAG, "dice4 팔리고 interrupt");

                        dice4AttackEnemyThread.interrupt();
                    }
                } else {
                    toast = Toast.makeText(Activity_InfinityStage.this, "더이상 판매할 수 없습니다", Toast.LENGTH_SHORT);
                    toast.show();
                }

                tv_gold.setText("골드 : " + gold + "G");
            }
        });


        btn_upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int createsCount = 0;

                ArrayList<Integer> indexes = new ArrayList<>();

                if ((creates[0] || creates[1] || creates[2] || creates[3]) && gold >= 300) { // 하나라도 설치되어 있는 경우

                    for (int i = 0; i < creates.length; i++) { // 몇개 설치되어 있는지 배열 순회해서 알아냄.
                        if (creates[i]) {

                            createsCount += 1;      // 몇개 설치 되어 있는지 카운트 했음.
                            indexes.add(i);       //인덱스값을 어레이리스트에 담아놨음.

                        }
                    }

                    ArrayList<MediaPlayer> mediaPlayers = new ArrayList<>();
                    mediaPlayers.add(mediaPlayer1);
                    mediaPlayers.add(mediaPlayer2);
                    mediaPlayers.add(mediaPlayer3);
                    mediaPlayers.add(mediaPlayer4);

                    ArrayList<ArrayList<ImageView>> iv_effects = new ArrayList<>();
                    iv_effects.add(iv_effectDice1s);
                    iv_effects.add(iv_effectDice2s);
                    iv_effects.add(iv_effectDice3s);
                    iv_effects.add(iv_effectDice4s);

                    ArrayList<ArrayList<Canvas>> canvasEffectDices = new ArrayList<>();
                    canvasEffectDices.add(canvasEffectDice1s);
                    canvasEffectDices.add(canvasEffectDice2s);
                    canvasEffectDices.add(canvasEffectDice3s);
                    canvasEffectDices.add(canvasEffectDice4s);

                    ArrayList<ArrayList<Bitmap>> effectBitmapDices = new ArrayList<>();
                    effectBitmapDices.add(effectBitmapDice1s);
                    effectBitmapDices.add(effectBitmapDice2s);
                    effectBitmapDices.add(effectBitmapDice3s);
                    effectBitmapDices.add(effectBitmapDice4s);
                    int[] randomNums = new int[2];
                    randomNums[0] = 0;
                    randomNums[1] = 1;
                    int randomNum = randomNums[random.nextInt(2)];




                    if (createsCount >= 2) { // 설치된게 2개 이상일 때"만" 합체가 일어난다.
                        // 카운트가 2일때 3일때 4일때의 경우가 있을 것임

                        if (createsCount == 2) {    // 두개인 경우



                            gold -= 300;
                            tv_gold.setText("골드 : " + gold + "G");
                            tv_sellGold.setText("-300G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                            Log.d(TAG, "업그레이드 누르고 두개인 경우");
                            Log.d(TAG, "첫번째 다이스 넘버" + dices[indexes.get(0)].name + dices[indexes.get(0)].choiceNum);
                            Log.d(TAG, "두번째 다이스 넘버" + dices[indexes.get(1)].name + dices[indexes.get(1)].choiceNum);


                            //랜덤으로 둘중 하나를 뽑는다 0이나올지 1이 나올지는 모름
                            int choice1 = indexes.get(random.nextInt(2));
                            int choice2 = indexes.get(random.nextInt(2));

                            while (choice2 == choice1) {
                                choice2 = indexes.get(random.nextInt(2));
                                if (choice2 != choice1) {
                                    break;
                                }
                            }

                            Log.d(TAG, "각기 다른 랜덤 값을 가진다 랜덤값 : " + choice1 + "," + choice2);
                            // 초이스 된 주사위 두개를 하나를 upgrade 하고 하나를 interrupt 시키면 될듯함.
                            int upgradeNum = ((dices[choice1].choiceNum + 1) + (dices[choice2].choiceNum + 1)) - 1;
                            if (upgradeNum > 5) {
                                upgradeNum = 5; // 6눈금만 나오게
                            }

                            // AttackEnemyThread 를 interrupt 시켜줘야 한다.
                            // 몇번째 에너미 스레드인지 확인해봐야됨 ....

                            creates[choice1] = false;

                            int upgradeX = dices[choice2].x;
                            int upgradeY = dices[choice2].y;

                            if (choice1 == 0 || choice2 == 0) {
                                if(dice1AttackEnemyThread != null) {
                                    dice1AttackEnemyThread.interrupt();
                                }
//                                Log.d(TAG, "1 " +dice1AttackEnemyThread.isAlive());
                            }
                            if (choice1 == 1 || choice2 == 1) {
                                if(dice2AttackEnemyThread != null) {
                                    dice2AttackEnemyThread.interrupt();
                                }
//                                Log.d(TAG, "2 " +dice2AttackEnemyThread.isAlive());
                            }
                            if (choice1 == 2 || choice2 == 2) {
                                if(dice3AttackEnemyThread != null) {
                                    dice3AttackEnemyThread.interrupt();
                                }
//                                Log.d(TAG, "3 " +dice3AttackEnemyThread.isAlive());
                            }
                            if (choice1 == 3 || choice2 == 3) {
                                if(dice4AttackEnemyThread != null) {
                                    dice4AttackEnemyThread.interrupt();
                                }
//                                Log.d(TAG, "4 " +dice4AttackEnemyThread.isAlive());
                            }

                            Log.d(TAG, "합체할때 없어지는 주사위 좌표 값 : " + dices[choice1].x +" , " + dices[choice1].y);
                            dices[choice1].sellDice(canvas, dices[choice1].choiceType, dices[choice1].x, dices[choice1].y); // 주사위 하나 날린다
                            dices[choice2].sellDice(canvas, dices[choice2].choiceType, dices[choice2].x, dices[choice2].y);

                            String[] choiceTypes = new String[3];

                            choiceTypes[0] = "불";
                            choiceTypes[1] = "물";
                            choiceTypes[2] = "전기";
                            choiceType = choiceTypes[random.nextInt(3)];

                            dices[choice2].choiceType = choiceType;
                            Log.d(TAG, "합체할때 그려지는 주사위 좌표 값 : " + upgradeX +" , " + upgradeY);

                            dices[choice2].upgradeDice(upgradeNum, canvas, choiceType, upgradeX, upgradeY);

                            MediaPlayer mediaPlayer = new MediaPlayer();
                            mediaPlayer.setLooping(false);
                            mediaPlayer = mediaPlayers.get(choice2);
                            if (choiceType.equals("불")) {
                                mediaPlayer = MediaPlayer.create(Activity_InfinityStage.this, R.raw.fire_dice_effect);
                            } else if (choiceType.equals("물")) {
                                mediaPlayer = MediaPlayer.create(Activity_InfinityStage.this, R.raw.blue_dice_effect);
                            } else if (choiceType.equals("전기")) {
                                mediaPlayer = MediaPlayer.create(Activity_InfinityStage.this, R.raw.yellow_dice_effect);
                            }

                            if (choice2 == 0) {

                                dice1AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice1s, handler, enemies, enemyCanvases, enemyBitmaps, dice1, canvasEffectDice1s, effectBitmapDice1s);
                                dice1AttackEnemyThread.start();

                            } else if (choice2 == 1) {

                                dice2AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice2s, handler, enemies, enemyCanvases, enemyBitmaps, dice2, canvasEffectDice2s, effectBitmapDice2s);
                                dice2AttackEnemyThread.start();

                            } else if (choice2 == 2) {

                                dice3AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice3s, handler, enemies, enemyCanvases, enemyBitmaps, dice3, canvasEffectDice3s, effectBitmapDice3s);
                                dice3AttackEnemyThread.start();

                            } else if (choice2 == 3) {

                                dice4AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice4s, handler, enemies, enemyCanvases, enemyBitmaps, dice4, canvasEffectDice4s, effectBitmapDice4s);
                                dice4AttackEnemyThread.start();

                            }


                        } else if (createsCount == 3) {  //  세개인 경우
                            gold -= 300;
                            tv_sellGold.setText("-300G");
                            tv_gold.setText("골드 : " + gold + "G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);
                            Log.d(TAG, "업그레이드 누르고 세개인 경우");
                            Log.d(TAG, "첫번째 다이스 넘버" + dices[indexes.get(0)].name + dices[indexes.get(0)].choiceNum);
                            Log.d(TAG, "두번째 다이스 넘버" + dices[indexes.get(1)].name + dices[indexes.get(1)].choiceNum);
                            Log.d(TAG, "세번째 다이스 넘버" + dices[indexes.get(2)].name + dices[indexes.get(2)].choiceNum);

                            //랜덤으로 셋중 둘을 뽑는다 뭐가 나올지는 모름

                            int choice1 = indexes.get(random.nextInt(3));
                            int choice2 = indexes.get(random.nextInt(3));

                            while (choice2 == choice1) {
                                choice2 = random.nextInt(3);
                                if (choice2 != choice1) {
                                    break;
                                }
                            }
                            Log.d(TAG, "각기 다른 랜덤 값을 가진다 랜덤값 : " + choice1 + "," + choice2);
                            int upgradeNum = ((dices[choice1].choiceNum + 1) + (dices[choice2].choiceNum + 1)) - 1;
                            if (upgradeNum > 5) {
                                upgradeNum = 5;
                            }

                            creates[choice1] = false;

                            int upgradeX = dices[choice2].x;
                            int upgradeY = dices[choice2].y;

                            if (choice1 == 0 || choice2 == 0) {
                                if(dice1AttackEnemyThread != null){
                                    dice1AttackEnemyThread.interrupt();
                                }


//                                Log.d(TAG, "1 " +dice1AttackEnemyThread.isAlive());
                            }
                            if (choice1 == 1 || choice2 == 1) {
                                if(dice2AttackEnemyThread != null){
                                    dice2AttackEnemyThread.interrupt();
                                }

//                                Log.d(TAG, "2 " +dice2AttackEnemyThread.isAlive());
                            }
                            if (choice1 == 2 || choice2 == 2) {
                                if(dice3AttackEnemyThread != null){
                                    dice3AttackEnemyThread.interrupt();
                                }

//                                Log.d(TAG, "3 " +dice3AttackEnemyThread.isAlive());
                            }
                            if (choice1 == 3 || choice2 == 3) {
                                if(dice4AttackEnemyThread != null){
                                    dice4AttackEnemyThread.interrupt();
                                }

//                                Log.d(TAG, "4 " +dice4AttackEnemyThread.isAlive());
                            }

                            Log.d(TAG, "합체할때 없어지는 주사위 좌표 값 : " + dices[choice1].x +" , " + dices[choice1].y);

                            dices[choice1].sellDice(canvas, dices[choice1].choiceType, dices[choice1].x, dices[choice1].y); // 주사위 하나 날린다
                            dices[choice2].sellDice(canvas, dices[choice2].choiceType, dices[choice2].x, dices[choice2].y);

                            String[] choiceTypes = new String[3];

                            choiceTypes[0] = "불";
                            choiceTypes[1] = "물";
                            choiceTypes[2] = "전기";
                            choiceType = choiceTypes[random.nextInt(3)];

                            dices[choice2].choiceType = choiceType;
                            Log.d(TAG, "합체할때 그려지는 주사위 좌표 값 : " + upgradeX + " , " + upgradeY);
                            dices[choice2].upgradeDice(upgradeNum, canvas, choiceType, upgradeX, upgradeY);

                            MediaPlayer mediaPlayer = new MediaPlayer();
                            mediaPlayer.setLooping(false);
                            mediaPlayer = mediaPlayers.get(choice2);
                            if (choiceType.equals("불")) {
                                mediaPlayer = MediaPlayer.create(Activity_InfinityStage.this, R.raw.fire_dice_effect);
                            } else if (choiceType.equals("물")) {
                                mediaPlayer = MediaPlayer.create(Activity_InfinityStage.this, R.raw.blue_dice_effect);
                            } else if (choiceType.equals("전기")) {
                                mediaPlayer = MediaPlayer.create(Activity_InfinityStage.this, R.raw.yellow_dice_effect);
                            }

                            if (choice2 == 0) {
                                dice1AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice1s, handler, enemies, enemyCanvases, enemyBitmaps, dice1, canvasEffectDice1s, effectBitmapDice1s);
                                dice1AttackEnemyThread.start();
                            } else if (choice2 == 1) {
                                dice2AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice2s, handler, enemies, enemyCanvases, enemyBitmaps, dice2, canvasEffectDice2s, effectBitmapDice2s);
                                dice2AttackEnemyThread.start();
                            } else if (choice2 == 2) {
                                dice3AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice3s, handler, enemies, enemyCanvases, enemyBitmaps, dice3, canvasEffectDice3s, effectBitmapDice3s);
                                dice3AttackEnemyThread.start();
                            } else if (choice2 == 3) {
                                dice4AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice4s, handler, enemies, enemyCanvases, enemyBitmaps, dice4, canvasEffectDice4s, effectBitmapDice4s);
                                dice4AttackEnemyThread.start();
                            }



                        } else if (createsCount == 4) { // 네개인 경우
                            gold -= 300;
                            tv_sellGold.setText("-300G");
                            tv_gold.setText("골드 : " + gold + "G");
                            animationGold = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.gold_set);
                            tv_sellGold.startAnimation(animationGold);

                            Log.d(TAG, "업그레이드 누르고 네개인 경우");
                            Log.d(TAG, "첫번째 다이스 넘버" + dices[indexes.get(0)].name + dices[indexes.get(0)].choiceNum);
                            Log.d(TAG, "두번째 다이스 넘버" + dices[indexes.get(1)].name + dices[indexes.get(1)].choiceNum);
                            Log.d(TAG, "세번째 다이스 넘버" + dices[indexes.get(2)].name + dices[indexes.get(2)].choiceNum);
                            Log.d(TAG, "네번째 다이스 넘버" + dices[indexes.get(3)].name + dices[indexes.get(3)].choiceNum);
                            //랜덤으로 넷중 둘을 뽑는다 뭐가 나올지는 모름

                            int choice1 = indexes.get(random.nextInt(4));
                            int choice2 = indexes.get(random.nextInt(4));

                            while (choice2 == choice1) {
                                choice2 = random.nextInt(4);
                                if (choice2 != choice1) {
                                    break;
                                }
                            }
                            Log.d(TAG, "각기 다른 랜덤 값을 가진다 랜덤값 : " + choice1 + "," + choice2);

                            int upgradeNum = ((dices[choice1].choiceNum + 1) + (dices[choice2].choiceNum + 1)) - 1;
                            if (upgradeNum > 5) {
                                upgradeNum = 5;
                            }

                            creates[choice1] = false;

                            int upgradeX = dices[choice2].x;
                            int upgradeY = dices[choice2].y;

                            if (choice1 == 0 || choice2 == 0) {
                                if(dice1AttackEnemyThread != null) {
                                    dice1AttackEnemyThread.interrupt();
                                }
//                                Log.d(TAG, "1 " +dice1AttackEnemyThread.isAlive());
                            }
                            if (choice1 == 1 || choice2 == 1) {
                                if(dice2AttackEnemyThread != null) {
                                    dice2AttackEnemyThread.interrupt();
                                }
//                                Log.d(TAG, "2 " +dice2AttackEnemyThread.isAlive());
                            }
                            if (choice1 == 2 || choice2 == 2) {
                                if(dice3AttackEnemyThread != null) {
                                    dice3AttackEnemyThread.interrupt();
                                }
//                                Log.d(TAG, "3 " +dice3AttackEnemyThread.isAlive());
                            }
                            if (choice1 == 3 || choice2 == 3) {
                                if(dice4AttackEnemyThread != null) {
                                    dice4AttackEnemyThread.interrupt();
                                }
//                                Log.d(TAG, "4 " +dice4AttackEnemyThread.isAlive());
                            }

                            Log.d(TAG, "합체할때 없어지는 주사위 좌표 값 : " + dices[choice1].x +" , " + dices[choice1].y);

                            dices[choice1].sellDice(canvas, dices[choice1].choiceType, dices[choice1].x, dices[choice1].y); // 주사위 하나 날린다
                            dices[choice2].sellDice(canvas, dices[choice2].choiceType, dices[choice2].x, dices[choice2].y);
                            String[] choiceTypes = new String[3];

                            choiceTypes[0] = "불";
                            choiceTypes[1] = "물";
                            choiceTypes[2] = "전기";
                            choiceType = choiceTypes[random.nextInt(3)];

                            dices[choice2].choiceType = choiceType;
                            Log.d(TAG, "합체할때 그려지는 주사위 좌표 값 : " + upgradeX +" , " + upgradeY);
                            dices[choice2].upgradeDice(upgradeNum, canvas, choiceType, upgradeX, upgradeY);

                            MediaPlayer mediaPlayer = new MediaPlayer();
                            mediaPlayer.setLooping(false);
                            mediaPlayer = mediaPlayers.get(choice2);

                            if (choiceType.equals("불")) {
                                mediaPlayer = MediaPlayer.create(Activity_InfinityStage.this, R.raw.fire_dice_effect);
                            } else if (choiceType.equals("물")) {
                                mediaPlayer = MediaPlayer.create(Activity_InfinityStage.this, R.raw.blue_dice_effect);
                            } else if (choiceType.equals("전기")) {
                                mediaPlayer = MediaPlayer.create(Activity_InfinityStage.this, R.raw.yellow_dice_effect);
                            }

                            if (choice2 == 0) {
                                dice1AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice1s, handler, enemies, enemyCanvases, enemyBitmaps, dice1, canvasEffectDice1s, effectBitmapDice1s);
                                dice1AttackEnemyThread.start();
                            } else if (choice2 == 1) {
                                dice2AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice2s, handler, enemies, enemyCanvases, enemyBitmaps, dice2, canvasEffectDice2s, effectBitmapDice2s);
                                dice2AttackEnemyThread.start();
                            } else if (choice2 == 2) {
                                dice3AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice3s, handler, enemies, enemyCanvases, enemyBitmaps, dice3, canvasEffectDice3s, effectBitmapDice3s);
                                dice3AttackEnemyThread.start();
                            } else if (choice2 == 3) {
                                dice4AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice4s, handler, enemies, enemyCanvases, enemyBitmaps, dice4, canvasEffectDice4s, effectBitmapDice4s);
                                dice4AttackEnemyThread.start();
                            }




                        }


                    } else {

                        Log.d(TAG, "업그레이드 눌렀는데 createCount가 조건에 못미치는 경우" + createsCount);
                        toast = Toast.makeText(Activity_InfinityStage.this, "두개 이상의 타워가 존재해야 합니다.", Toast.LENGTH_SHORT);
                        toast.show();

                    }


                } else if(gold < 300){
                    toast = Toast.makeText(Activity_InfinityStage.this, "골드가 모자랍니다.", Toast.LENGTH_SHORT);
                    toast.show();

                }else {
                    Log.d(TAG, "타워가 하나라도 설치되어 있지 않은 경우");
                    toast = Toast.makeText(Activity_InfinityStage.this, "두개 이상의 타워가 존재해야 합니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });


    }

    @Override
    protected void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "onResume");
        super.onResume();

        startCountThread = new StartCountThread(score);
        startCountThread.start();
        btn_backStage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startCountThread.isAlive()) {
                    startCountThread.interrupt();
//                    Intent intent = new Intent(Activity_Stage1.this, Activity_StageChoice.class);
//                    intent.putExtra("아이디", idS[index]);
//
//                    startActivity(intent);
                    finish();

                } else if (startGameCountThread.isAlive()) {
                    startGameCountThread.interrupt();
//                    Intent intent = new Intent(Activity_Stage1.this, Activity_StageChoice.class);
//                    intent.putExtra("아이디", idS[index]);
//
//                    startActivity(intent);
                    finish();
                }


            }
        });

    }

    @Override
    protected void onPause() {


        mediaPlayer1.stop();
        mediaPlayer2.stop();
        mediaPlayer3.stop();
        mediaPlayer4.stop();

        Log.e(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {

        Log.e(TAG, "onStop");
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();

        finish();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "onRestart");
        super.onRestart();
    }

    public void setView() {  // 초기 설정값들 빼논 메소드

        getIntent = getIntent();

        CL_normalMod =(ConstraintLayout) findViewById(R.id.CL_normalMod);

        iv_battleField = (ImageView) findViewById(R.id.iv_battleField);
        iv_effectDice1_1 = (ImageView) findViewById(R.id.iv_effectDice1_1);
        iv_effectDice1_2 = (ImageView) findViewById(R.id.iv_effectDice1_2);
        iv_effectDice1_3 = (ImageView) findViewById(R.id.iv_effectDice1_3);
        iv_effectDice1_4 = (ImageView) findViewById(R.id.iv_effectDice1_4);
        iv_effectDice1_5 = (ImageView) findViewById(R.id.iv_effectDice1_5);
        iv_effectDice1_6 = (ImageView) findViewById(R.id.iv_effectDice1_6);

        iv_effectDice1s.add(iv_effectDice1_1);
        iv_effectDice1s.add(iv_effectDice1_2);
        iv_effectDice1s.add(iv_effectDice1_3);
        iv_effectDice1s.add(iv_effectDice1_4);
        iv_effectDice1s.add(iv_effectDice1_5);
        iv_effectDice1s.add(iv_effectDice1_6);


        iv_effectDice2_1 = (ImageView) findViewById(R.id.iv_effectDice2_1);
        iv_effectDice2_2 = (ImageView) findViewById(R.id.iv_effectDice2_2);
        iv_effectDice2_3 = (ImageView) findViewById(R.id.iv_effectDice2_3);
        iv_effectDice2_4 = (ImageView) findViewById(R.id.iv_effectDice2_4);
        iv_effectDice2_5 = (ImageView) findViewById(R.id.iv_effectDice2_5);
        iv_effectDice2_6 = (ImageView) findViewById(R.id.iv_effectDice2_6);

        iv_effectDice2s.add(iv_effectDice2_1);
        iv_effectDice2s.add(iv_effectDice2_2);
        iv_effectDice2s.add(iv_effectDice2_3);
        iv_effectDice2s.add(iv_effectDice2_4);
        iv_effectDice2s.add(iv_effectDice2_5);
        iv_effectDice2s.add(iv_effectDice2_6);

        iv_effectDice3_1 = (ImageView) findViewById(R.id.iv_effectDice3_1);
        iv_effectDice3_2 = (ImageView) findViewById(R.id.iv_effectDice3_2);
        iv_effectDice3_3 = (ImageView) findViewById(R.id.iv_effectDice3_3);
        iv_effectDice3_4 = (ImageView) findViewById(R.id.iv_effectDice3_4);
        iv_effectDice3_5 = (ImageView) findViewById(R.id.iv_effectDice3_5);
        iv_effectDice3_6 = (ImageView) findViewById(R.id.iv_effectDice3_6);

        iv_effectDice3s.add(iv_effectDice3_1);
        iv_effectDice3s.add(iv_effectDice3_2);
        iv_effectDice3s.add(iv_effectDice3_3);
        iv_effectDice3s.add(iv_effectDice3_4);
        iv_effectDice3s.add(iv_effectDice3_5);
        iv_effectDice3s.add(iv_effectDice3_6);

        iv_effectDice4_1 = (ImageView) findViewById(R.id.iv_effectDice4_1);
        iv_effectDice4_2 = (ImageView) findViewById(R.id.iv_effectDice4_2);
        iv_effectDice4_3 = (ImageView) findViewById(R.id.iv_effectDice4_3);
        iv_effectDice4_4 = (ImageView) findViewById(R.id.iv_effectDice4_4);
        iv_effectDice4_5 = (ImageView) findViewById(R.id.iv_effectDice4_5);
        iv_effectDice4_6 = (ImageView) findViewById(R.id.iv_effectDice4_6);

        iv_effectDice4s.add(iv_effectDice4_1);
        iv_effectDice4s.add(iv_effectDice4_2);
        iv_effectDice4s.add(iv_effectDice4_3);
        iv_effectDice4s.add(iv_effectDice4_4);
        iv_effectDice4s.add(iv_effectDice4_5);
        iv_effectDice4s.add(iv_effectDice4_6);

        iv_enemy1 = (ImageView) findViewById(R.id.iv_enemy1);
        iv_enemy2 = (ImageView) findViewById(R.id.iv_enemy2);
        iv_enemy3 = (ImageView) findViewById(R.id.iv_enemy3);
        iv_enemy4 = (ImageView) findViewById(R.id.iv_enemy4);
        iv_enemy5 = (ImageView) findViewById(R.id.iv_enemy5);
        iv_enemy6 = (ImageView) findViewById(R.id.iv_enemy6);
        iv_enemy7 = (ImageView) findViewById(R.id.iv_enemy7);
        iv_enemy8 = (ImageView) findViewById(R.id.iv_enemy8);
        iv_enemy9 = (ImageView) findViewById(R.id.iv_enemy9);
        iv_enemy10 = (ImageView) findViewById(R.id.iv_enemy10);
        iv_enemyBoss = (ImageView) findViewById(R.id.iv_enemyBoss);

//        iv_test = (ImageView) findViewById(R.id.iv_test);

        tv_startCount = (TextView) findViewById(R.id.tv_startCount);
//        tv_gameCount = (TextView) findViewById(R.id.tv_gameCount);

        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_gold = (TextView) findViewById(R.id.tv_gold);
        tv_stage = (TextView) findViewById(R.id.tv_stage);

        pb_gameCount = (ProgressBar) findViewById(R.id.pb_gameCount);
        pb_gameCount.setMax(60);
        pb_gameCount.setProgress(60);

        btn_create = (Button) findViewById(R.id.btn_create);

        btn_sell = (Button) findViewById(R.id.btn_sell);

        btn_backStage1 = (Button) findViewById(R.id.btn_backStage1);
        btn_upgrade = (Button) findViewById(R.id.btn_upgrade);


        enemy1Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemy2Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemy3Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemy4Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemy5Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemy6Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemy7Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemy8Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemy9Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemy10Bitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        enemyBossBitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);


        effectBitmapDice1_1 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice1_2 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice1_3 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice1_4 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice1_5 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice1_6 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);

        effectBitmapDice1s.add(effectBitmapDice1_1);
        effectBitmapDice1s.add(effectBitmapDice1_2);
        effectBitmapDice1s.add(effectBitmapDice1_3);
        effectBitmapDice1s.add(effectBitmapDice1_4);
        effectBitmapDice1s.add(effectBitmapDice1_5);
        effectBitmapDice1s.add(effectBitmapDice1_6);

        effectBitmapDice2_1 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice2_2 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice2_3 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice2_4 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice2_5 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice2_6 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);

        effectBitmapDice2s.add(effectBitmapDice2_1);
        effectBitmapDice2s.add(effectBitmapDice2_2);
        effectBitmapDice2s.add(effectBitmapDice2_3);
        effectBitmapDice2s.add(effectBitmapDice2_4);
        effectBitmapDice2s.add(effectBitmapDice2_5);
        effectBitmapDice2s.add(effectBitmapDice2_6);

        effectBitmapDice3_1 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice3_2 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice3_3 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice3_4 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice3_5 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice3_6 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);

        effectBitmapDice3s.add(effectBitmapDice3_1);
        effectBitmapDice3s.add(effectBitmapDice3_2);
        effectBitmapDice3s.add(effectBitmapDice3_3);
        effectBitmapDice3s.add(effectBitmapDice3_4);
        effectBitmapDice3s.add(effectBitmapDice3_5);
        effectBitmapDice3s.add(effectBitmapDice3_6);

        effectBitmapDice4_1 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice4_2 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice4_3 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice4_4 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice4_5 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        effectBitmapDice4_6 = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);

        effectBitmapDice4s.add(effectBitmapDice4_1);
        effectBitmapDice4s.add(effectBitmapDice4_2);
        effectBitmapDice4s.add(effectBitmapDice4_3);
        effectBitmapDice4s.add(effectBitmapDice4_4);
        effectBitmapDice4s.add(effectBitmapDice4_5);
        effectBitmapDice4s.add(effectBitmapDice4_6);

        canvasEnemy1 = new Canvas(enemy1Bitmap);
        canvasEnemy2 = new Canvas(enemy2Bitmap);
        canvasEnemy3 = new Canvas(enemy3Bitmap);
        canvasEnemy4 = new Canvas(enemy4Bitmap);
        canvasEnemy5 = new Canvas(enemy5Bitmap);
        canvasEnemy6 = new Canvas(enemy6Bitmap);
        canvasEnemy7 = new Canvas(enemy7Bitmap);
        canvasEnemy8 = new Canvas(enemy8Bitmap);
        canvasEnemy9 = new Canvas(enemy9Bitmap);
        canvasEnemy10 = new Canvas(enemy10Bitmap);
        canvasEnemyBoss = new Canvas(enemyBossBitmap);

        canvasEffectDice1_1 = new Canvas(effectBitmapDice1_1);
        canvasEffectDice1_2 = new Canvas(effectBitmapDice1_2);
        canvasEffectDice1_3 = new Canvas(effectBitmapDice1_3);
        canvasEffectDice1_4 = new Canvas(effectBitmapDice1_4);
        canvasEffectDice1_5 = new Canvas(effectBitmapDice1_5);
        canvasEffectDice1_6 = new Canvas(effectBitmapDice1_6);

        canvasEffectDice1s.add(canvasEffectDice1_1);
        canvasEffectDice1s.add(canvasEffectDice1_2);
        canvasEffectDice1s.add(canvasEffectDice1_3);
        canvasEffectDice1s.add(canvasEffectDice1_4);
        canvasEffectDice1s.add(canvasEffectDice1_5);
        canvasEffectDice1s.add(canvasEffectDice1_6);


        canvasEffectDice2_1 = new Canvas(effectBitmapDice2_1);
        canvasEffectDice2_2 = new Canvas(effectBitmapDice2_2);
        canvasEffectDice2_3 = new Canvas(effectBitmapDice2_3);
        canvasEffectDice2_4 = new Canvas(effectBitmapDice2_4);
        canvasEffectDice2_5 = new Canvas(effectBitmapDice2_5);
        canvasEffectDice2_6 = new Canvas(effectBitmapDice2_6);

        canvasEffectDice2s.add(canvasEffectDice2_1);
        canvasEffectDice2s.add(canvasEffectDice2_2);
        canvasEffectDice2s.add(canvasEffectDice2_3);
        canvasEffectDice2s.add(canvasEffectDice2_4);
        canvasEffectDice2s.add(canvasEffectDice2_5);
        canvasEffectDice2s.add(canvasEffectDice2_6);


        canvasEffectDice3_1 = new Canvas(effectBitmapDice3_1);
        canvasEffectDice3_2 = new Canvas(effectBitmapDice3_2);
        canvasEffectDice3_3 = new Canvas(effectBitmapDice3_3);
        canvasEffectDice3_4 = new Canvas(effectBitmapDice3_4);
        canvasEffectDice3_5 = new Canvas(effectBitmapDice3_5);
        canvasEffectDice3_6 = new Canvas(effectBitmapDice3_6);

        canvasEffectDice3s.add(canvasEffectDice3_1);
        canvasEffectDice3s.add(canvasEffectDice3_2);
        canvasEffectDice3s.add(canvasEffectDice3_3);
        canvasEffectDice3s.add(canvasEffectDice3_4);
        canvasEffectDice3s.add(canvasEffectDice3_5);
        canvasEffectDice3s.add(canvasEffectDice3_6);

        canvasEffectDice4_1 = new Canvas(effectBitmapDice4_1);
        canvasEffectDice4_2 = new Canvas(effectBitmapDice4_2);
        canvasEffectDice4_3 = new Canvas(effectBitmapDice4_3);
        canvasEffectDice4_4 = new Canvas(effectBitmapDice4_4);
        canvasEffectDice4_5 = new Canvas(effectBitmapDice4_5);
        canvasEffectDice4_6 = new Canvas(effectBitmapDice4_6);

        canvasEffectDice4s.add(canvasEffectDice4_1);
        canvasEffectDice4s.add(canvasEffectDice4_2);
        canvasEffectDice4s.add(canvasEffectDice4_3);
        canvasEffectDice4s.add(canvasEffectDice4_4);
        canvasEffectDice4s.add(canvasEffectDice4_5);
        canvasEffectDice4s.add(canvasEffectDice4_6);

        downBitmap = Bitmap.createBitmap(1000, 1300, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(downBitmap);

        canvasEnemy1.drawColor(Color.TRANSPARENT);
        canvasEnemy2.drawColor(Color.TRANSPARENT);
        canvasEnemy3.drawColor(Color.TRANSPARENT);
        canvasEnemy4.drawColor(Color.TRANSPARENT);
        canvasEnemy5.drawColor(Color.TRANSPARENT);
        canvasEnemy6.drawColor(Color.TRANSPARENT);
        canvasEnemy7.drawColor(Color.TRANSPARENT);
        canvasEnemy8.drawColor(Color.TRANSPARENT);
        canvasEnemy9.drawColor(Color.TRANSPARENT);
        canvasEnemy10.drawColor(Color.TRANSPARENT);
        canvasEnemyBoss.drawColor(Color.TRANSPARENT);

        canvas.drawColor(Color.BLACK);


        for (int i = 0; i < canvasEffectDice1s.size(); i++) {
            canvasEffectDice1s.get(i).drawColor(Color.TRANSPARENT);
        }

        for (int i = 0; i < canvasEffectDice2s.size(); i++) {
            canvasEffectDice2s.get(i).drawColor(Color.TRANSPARENT);
        }

        for (int i = 0; i < canvasEffectDice3s.size(); i++) {
            canvasEffectDice3s.get(i).drawColor(Color.TRANSPARENT);
        }

        for (int i = 0; i < canvasEffectDice4s.size(); i++) {
            canvasEffectDice4s.get(i).drawColor(Color.TRANSPARENT);
        }

        iv_battleField.setImageBitmap(downBitmap);

        iv_effectDice1_1.setImageBitmap(effectBitmapDice1_1);
        iv_effectDice1_2.setImageBitmap(effectBitmapDice1_2);
        iv_effectDice1_3.setImageBitmap(effectBitmapDice1_3);
        iv_effectDice1_4.setImageBitmap(effectBitmapDice1_4);
        iv_effectDice1_5.setImageBitmap(effectBitmapDice1_5);
        iv_effectDice1_6.setImageBitmap(effectBitmapDice1_6);


        iv_effectDice2_1.setImageBitmap(effectBitmapDice2_1);
        iv_effectDice2_2.setImageBitmap(effectBitmapDice2_2);
        iv_effectDice2_3.setImageBitmap(effectBitmapDice2_3);
        iv_effectDice2_4.setImageBitmap(effectBitmapDice2_4);
        iv_effectDice2_5.setImageBitmap(effectBitmapDice2_5);
        iv_effectDice2_6.setImageBitmap(effectBitmapDice2_6);


        iv_effectDice3_1.setImageBitmap(effectBitmapDice3_1);
        iv_effectDice3_2.setImageBitmap(effectBitmapDice3_2);
        iv_effectDice3_3.setImageBitmap(effectBitmapDice3_3);
        iv_effectDice3_4.setImageBitmap(effectBitmapDice3_4);
        iv_effectDice3_5.setImageBitmap(effectBitmapDice3_5);
        iv_effectDice3_6.setImageBitmap(effectBitmapDice3_6);


        iv_effectDice4_1.setImageBitmap(effectBitmapDice4_1);
        iv_effectDice4_2.setImageBitmap(effectBitmapDice4_2);
        iv_effectDice4_3.setImageBitmap(effectBitmapDice4_3);
        iv_effectDice4_4.setImageBitmap(effectBitmapDice4_4);
        iv_effectDice4_5.setImageBitmap(effectBitmapDice4_5);
        iv_effectDice4_6.setImageBitmap(effectBitmapDice4_6);


        iv_enemy1.setImageBitmap(enemy1Bitmap);
        iv_enemy2.setImageBitmap(enemy2Bitmap);
        iv_enemy3.setImageBitmap(enemy3Bitmap);
        iv_enemy4.setImageBitmap(enemy4Bitmap);
        iv_enemy5.setImageBitmap(enemy5Bitmap);
        iv_enemy6.setImageBitmap(enemy6Bitmap);
        iv_enemy7.setImageBitmap(enemy7Bitmap);
        iv_enemy8.setImageBitmap(enemy8Bitmap);
        iv_enemy9.setImageBitmap(enemy9Bitmap);
        iv_enemy10.setImageBitmap(enemy10Bitmap);
        iv_enemyBoss.setImageBitmap(enemyBossBitmap);

        paint.setColor(Color.WHITE);

        enemyBitmaps.add(enemy1Bitmap);
        enemyBitmaps.add(enemy2Bitmap);
        enemyBitmaps.add(enemy3Bitmap);
        enemyBitmaps.add(enemy4Bitmap);
        enemyBitmaps.add(enemy5Bitmap);
        enemyBitmaps.add(enemy6Bitmap);
        enemyBitmaps.add(enemy7Bitmap);
        enemyBitmaps.add(enemy8Bitmap);
        enemyBitmaps.add(enemy9Bitmap);
        enemyBitmaps.add(enemy10Bitmap);
        enemyBitmaps.add(enemyBossBitmap);

        enemyCanvases.add(canvasEnemy1);
        enemyCanvases.add(canvasEnemy2);
        enemyCanvases.add(canvasEnemy3);
        enemyCanvases.add(canvasEnemy4);
        enemyCanvases.add(canvasEnemy5);
        enemyCanvases.add(canvasEnemy6);
        enemyCanvases.add(canvasEnemy7);
        enemyCanvases.add(canvasEnemy8);
        enemyCanvases.add(canvasEnemy9);
        enemyCanvases.add(canvasEnemy10);
        enemyCanvases.add(canvasEnemyBoss);

        dices = new Dice[4];
        dices[0] = dice1;
        dices[1] = dice2;
        dices[2] = dice3;
        dices[3] = dice4;


        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
        enemies.add(enemy5);
        enemies.add(enemy6);
        enemies.add(enemy7);
        enemies.add(enemy8);
        enemies.add(enemy9);
        enemies.add(enemy10);
        enemies.add(enemyBoss);


        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy1HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy2HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy3HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy4HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy5HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy6HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy7HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy8HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy9HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemy10HpBar));
        enemyHpBarLayouts.add((LinearLayout) findViewById(R.id.LL_enemyBossHpBar));

        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy1HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy2HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy3HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy4HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy5HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy6HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy7HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy8HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy9HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemy10HpBar));
        enemyHpBars.add((ProgressBar) findViewById(R.id.pb_enemyBossHpBar));

        tv_buyGold = (TextView) findViewById(R.id.tv_buyGold);
        tv_sellGold = (TextView) findViewById(R.id.tv_sellGold);

//        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) enemyHpBars.get(0).getLayoutParams();
//        enemyHpBars.get(0).setLayoutParams(layoutParams);
    }

    public class StartGameCountThread extends Thread { // 인게임 60초 카운트 스레드

        String count;
        int timeScore = 0;

        @Override
        public void run() {
            super.run();
            timeScore = 0;
            try {


                for (int i = 59; i >= 0; i--) {
                    int j = i;
                    try {
                        sleep(1000);   // 인게임 카운트 1초씩 떨어짐.
                        if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() <= 0) {  // 카운트 도중 10번째 적이 죽었을때

                            interrupt();

                        }


                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (stage % 5 != 0) {
                        for (int k = 0; k < enemies.size() - 1; k++) {
                            if (enemies.get(k).getHp() == 0 && !enemies.get(k).life) {
                                enemies.get(k).life = true;
                                score += 100;
                            }
                        }
                    } else if (stage % 5 == 0) {
                        for (int k = 0; k < enemies.size(); k++) {
                            if (enemies.get(k).getHp() == 0 && !enemies.get(k).life) {
                                enemies.get(k).life = true;
                                score += 100;
                            }
                        }
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            count = Integer.toString(j);
                            pb_gameCount.incrementProgressBy(-1);
//                            tv_gameCount.setText(count);
                            timeScore = j;
                            gold += 50;
                            tv_score.setText("점수 : " + score);
                            tv_gold.setText("골드 : " + gold + "G");
                            tv_stage.setText("스테이지 : " + stage);

                        }
                    });
                }
                Log.d(TAG, "타임 오버"); // 시간오버 되서 죽을때
                Intent intent = new Intent(Activity_InfinityStage.this, Activity_Ranking.class);
                // 쉐어드에 유저 점수 값 넣어서 저장

                scoreS[index] = Integer.toString(score);

                resultSCORE = "";
                for (int i = 0; i < scoreS.length; i++) {

                    if (i == 0) {

                        resultSCORE = resultSCORE + scoreS[i];

                        Log.d(TAG, "onClick: 1번 찍혀야되는 로그임");
                    } else {
                        resultSCORE = resultSCORE + "," + scoreS[i];

                    }
                }
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("유저 점수", resultSCORE);

                editor.commit();
                enemyHpThread.interrupt();

                if(dice1AttackEnemyThread != null){
                    dice1AttackEnemyThread.interrupt();

                }if(dice2AttackEnemyThread != null){
                    dice2AttackEnemyThread.interrupt();

                }if(dice3AttackEnemyThread != null){
                    dice3AttackEnemyThread.interrupt();

                }if(dice4AttackEnemyThread != null){
                    dice4AttackEnemyThread.interrupt();

                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        dialog = new AlertDialog.Builder(Activity_InfinityStage.this);
                        Log.d(TAG, "run: 클리어 실패하면 여기로들어오고 다이얼로그 실행됨.");
                        dialog.setTitle("클리어 실패");
                        dialog.setMessage("" + idS[index] + "님 : " + score + " 점");

                        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                intent.putExtra("아이디", idS[index]);
                                startActivity(intent);
                                finish();
                            }
                        });
                        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                intent.putExtra("아이디", idS[index]);
                                startActivity(intent);
                                finish();
                            }
                        });

                        dialog.show();


                    }
                });


            } catch (Exception e) {
                Log.d(TAG, "일단 인터럽트됐음");

                int sum = 0;
                for (int i = 0; i < enemies.size(); i++) {
                    sum += enemies.get(i).getHp();
                }
                if (sum > 0) {


                    Log.d(TAG, "클리어 이외의 interrupt");


                } else {
                    Log.d(TAG, "타이머 전에 클리어 했을때 여기로 들어옴");
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb_gameCount.setProgress(60);
                            score += timeScore * 10;// 시간 점수가 여기서 들어가야됨


                            tv_score.setText("점수 : " + score);
                            tv_gold.setText("골드 : " + gold + "G");

                            for (int i = 0; i < 10; i++) {
                                enemyHpBarLayouts.get(i).setVisibility(View.GONE);
                                enemyHpBars.get(i).setVisibility(View.GONE);
                            }

//                        tv_gameCount.setText(count);
                            enemy1MoveThread.interrupt();
                            enemy2MoveThread.interrupt();
                            enemy3MoveThread.interrupt();
                            enemy4MoveThread.interrupt();
                            enemy5MoveThread.interrupt();
                            enemy6MoveThread.interrupt();
                            enemy7MoveThread.interrupt();
                            enemy8MoveThread.interrupt();
                            enemy9MoveThread.interrupt();
                            enemy10MoveThread.interrupt();

                            if (stage % 5 == 0) {
                                enemyHpBarLayouts.get(10).setVisibility(View.GONE);
                                enemyBossMoveThread.interrupt();
                            }
                            stage++;
                            tv_stage.setText("스테이지 : " + stage);
                            tv_score.setText("점수 : " + score);
                            startCountThread = new StartCountThread(score);
                            Log.d(TAG, "startCountThread 새로 초기화 후 시작");
                            startCountThread.start();


                        }
                    });
                }
            }

        }
    }

    public class EnemyMoveThread extends Thread { // 적이 움직이는 스레드
        Enemy enemy;
        ImageView iv_enemy;

        LinearLayout enemyHpBarLayout;

        EnemyMoveThread(Enemy enemy, ImageView iv_enemy, LinearLayout enemyHpBarLayout) {
            this.enemy = enemy;
            this.iv_enemy = iv_enemy;
            this.enemyHpBarLayout = enemyHpBarLayout;
        }


        @Override
        public void run() {
            super.run();
            try {


                for (int i = 0; i < 5; i++) { // 12초 5번 반복 -> 1분

                    handler.post(new Runnable() {   // 아래로 이동하는 메서드
                        @Override
                        public void run() {


                            animation = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_down);
                            animationHpBar = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_down);

                            iv_enemy.startAnimation(animation);
                            enemyHpBarLayout.startAnimation(animationHpBar);

                        }
                    });
                    for (int j = 0; j < 30; j++) {     // 3초 동안 3.25x300px 이동 = y + 975px
                        try {
                            enemy.y = enemy.y + 32.5f;
                            sleep(100);


                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }


                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            animation = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_right);
                            animationHpBar = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_right);
                            iv_enemy.startAnimation(animation);
                            enemyHpBarLayout.startAnimation(animationHpBar);


                        }
                    });
                    for (int j = 0; j < 30; j++) { // 3초 동안 2.5x300px 이동 = x + 750px
                        try {

                            enemy.x = enemy.x + 25f;
                            sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }


                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            animation = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_up);
                            animationHpBar = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_up);
                            iv_enemy.startAnimation(animation);
                            enemyHpBarLayout.startAnimation(animationHpBar);


                        }
                    });
                    for (int j = 0; j < 30; j++) {        // 위쪽으로 이동 y-975
                        try {
                            enemy.y = enemy.y - 32.5f;
                            sleep(100);

                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }


                    handler.post(new Runnable() {     //왼쪽으로 이동 x - 750px
                        @Override
                        public void run() {
                            animation = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_left);
                            animationHpBar = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_left);
                            iv_enemy.startAnimation(animation);
                            enemyHpBarLayout.startAnimation(animationHpBar);

                        }
                    });
                    for (int j = 0; j < 30; j++) {
                        try {

                            enemy.x = enemy.x - 25f;
                            sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }


                }
            } catch (Exception e) { // interrupt 됐을때 여기로 들어옴.
                enemyHpBarLayout.setVisibility(View.GONE);

                enemy.setHp(0);
                enemy.x = 0;
                enemy.y = 0;
            }
        }

    }

    public class StartCountThread extends Thread {  // 시작 카운트
        int score;

        StartCountThread(int score) {
            this.score = score;
        }


        @Override
        public void run() {

            try {

//                if (stage == 21) {
//                    interrupt();
//                }

                super.run();
                int startCount = 3;
                String startCounts = Integer.toString(startCount);

                handler.post(new Runnable() {          // 카운트때 버튼 비활성화
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                animation = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_reset);
                                animationHpBar = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_reset);
                                for (int i = 0; i < 11; i++) {
                                    enemyHpBarLayouts.get(i).startAnimation(animationHpBar);
                                }
                                iv_enemy1.startAnimation(animation);
                                iv_enemy2.startAnimation(animation);
                                iv_enemy3.startAnimation(animation);
                                iv_enemy4.startAnimation(animation);
                                iv_enemy5.startAnimation(animation);
                                iv_enemy6.startAnimation(animation);
                                iv_enemy7.startAnimation(animation);
                                iv_enemy8.startAnimation(animation);
                                iv_enemy9.startAnimation(animation);
                                iv_enemy10.startAnimation(animation);
                                iv_enemyBoss.startAnimation(animation);
                            }
                        });


                        tv_score.setText("점수 : " + score);
                        tv_startCount.setText(startCounts);
                        tv_startCount.setVisibility(View.VISIBLE);

                        btn_create.setEnabled(false);
                        btn_sell.setEnabled(false);
                        btn_upgrade.setEnabled(false);

                    }
                });

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                for (int i = 3; i >= 0; i--) {

                    int j = i;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String stages = Integer.toString(stage);

                            String count;
                            count = Integer.toString(j);
                            if (j == 0) {
                                tv_score.setText("점수 : " + score);
                                tv_gold.setText("골드 : " + gold + "G");
                                tv_startCount.setText("Stage " + stages);
                            } else {
                                tv_startCount.setText(count);
                            }
                        }
                    });


                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                }

                startGameCountThread = new StartGameCountThread();
                startGameCountThread.start();

                handler.post(new Runnable() {
                    @Override
                    public void run() {             // 3초 카운트 끝나고 버튼 활성화

                        btn_create.setEnabled(true);
                        btn_sell.setEnabled(true);
                        btn_upgrade.setEnabled(true);
                        tv_startCount.setVisibility(View.INVISIBLE);
                        animation = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_reset); // 이미지뷰 위치 초기화 애니메이션
                        animationHpBar = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_reset); // 이미지뷰 위치 초기화 애니메이션

                        for (int i = 0; i < 11; i++) {
                            enemyHpBarLayouts.get(i).startAnimation(animationHpBar);
                        }

                        iv_enemy1.startAnimation(animation);
                        iv_enemy2.startAnimation(animation);
                        iv_enemy3.startAnimation(animation);
                        iv_enemy4.startAnimation(animation);
                        iv_enemy5.startAnimation(animation);
                        iv_enemy6.startAnimation(animation);
                        iv_enemy7.startAnimation(animation);
                        iv_enemy8.startAnimation(animation);
                        iv_enemy9.startAnimation(animation);
                        iv_enemy10.startAnimation(animation);
                        iv_enemyBoss.startAnimation(animation);
                    }
                });


                enemy1.drawEnemy(canvasEnemy1, 125.0f, 162.5f, stage);
                enemy2.drawEnemy(canvasEnemy2, 125.0f, 162.5f, stage);
                enemy3.drawEnemy(canvasEnemy3, 125.0f, 162.5f, stage);
                enemy4.drawEnemy(canvasEnemy4, 125.0f, 162.5f, stage);
                enemy5.drawEnemy(canvasEnemy5, 125.0f, 162.5f, stage);
                enemy6.drawEnemy(canvasEnemy6, 125.0f, 162.5f, stage);
                enemy7.drawEnemy(canvasEnemy7, 125.0f, 162.5f, stage);
                enemy8.drawEnemy(canvasEnemy8, 125.0f, 162.5f, stage);
                enemy9.drawEnemy(canvasEnemy9, 125.0f, 162.5f, stage);
                enemy10.drawEnemy(canvasEnemy10, 125.0f, 162.5f, stage);


                if (stage % 5 == 0) {
                    enemyBoss.drawEnemyBoss(canvasEnemyBoss, 125.0f, 162.5f, stage);
                }

                enemyHpThread = new EnemyHpThread();
                enemyHpThread.start();


                if (dice1.attack != 0 || dice2.attack != 0 || dice3.attack != 0 || dice4.attack != 0) {
                    if(dice1.attack != 0){
                        dice1AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer1, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice1s, handler, enemies, enemyCanvases, enemyBitmaps, dice1, canvasEffectDice1s, effectBitmapDice1s);
                        dice1AttackEnemyThread.start();
                    }
                    if(dice2.attack != 0){
                        dice2AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer2, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice2s, handler, enemies, enemyCanvases, enemyBitmaps, dice2, canvasEffectDice2s, effectBitmapDice2s);
                        dice2AttackEnemyThread.start();

                    }
                    if(dice3.attack != 0){
                        dice3AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer3, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice3s, handler, enemies, enemyCanvases, enemyBitmaps, dice3, canvasEffectDice3s, effectBitmapDice3s);
                        dice3AttackEnemyThread.start();

                    }
                    if(dice4.attack != 0){
                        dice4AttackEnemyThread = new AttackEnemyThread(tv_score, score, enemyHpBars, mediaPlayer4, Activity_InfinityStage.this, enemyHpBarLayouts, iv_effectDice4s, handler, enemies, enemyCanvases, enemyBitmaps, dice4, canvasEffectDice4s, effectBitmapDice4s);
                        dice4AttackEnemyThread.start();

                    }


                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (stage % 5 == 0) {     //보스 스테이지의 경우 체력바 세팅
                            for (int i = 0; i < 11; i++) {
                                enemyHpBars.get(i).setMax(enemies.get(i).getHp());
                                enemyHpBars.get(i).setProgress(enemies.get(i).getHp());
                                enemyHpBarLayouts.get(i).setVisibility(View.VISIBLE);
                                enemyHpBars.get(i).setVisibility(View.VISIBLE);
                            }
                        } else {
                            for (int i = 0; i < 10; i++) { // 보스 스테이지 아닐 경우 체력바 세팅
                                enemyHpBars.get(i).setMax(enemies.get(i).getHp());
                                enemyHpBars.get(i).setProgress(enemies.get(i).getHp());
                                enemyHpBarLayouts.get(i).setVisibility(View.VISIBLE);
                                enemyHpBars.get(i).setVisibility(View.VISIBLE);
                            }
                        }


                    }
                });
                enemy1MoveThread = new EnemyMoveThread(enemy1, iv_enemy1, enemyHpBarLayouts.get(0));
                enemy1MoveThread.start();

//                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) enemyHpBars.get(0).getLayoutParams();
//                enemyHpBars.get(0).setLayoutParams(layoutParams);

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                enemy2MoveThread = new EnemyMoveThread(enemy2, iv_enemy2, enemyHpBarLayouts.get(1));
                enemy2MoveThread.start();

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                enemy3MoveThread = new EnemyMoveThread(enemy3, iv_enemy3, enemyHpBarLayouts.get(2));
                enemy3MoveThread.start();

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                enemy4MoveThread = new EnemyMoveThread(enemy4, iv_enemy4, enemyHpBarLayouts.get(3));
                enemy4MoveThread.start();

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                enemy5MoveThread = new EnemyMoveThread(enemy5, iv_enemy5, enemyHpBarLayouts.get(4));
                enemy5MoveThread.start();

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                enemy6MoveThread = new EnemyMoveThread(enemy6, iv_enemy6, enemyHpBarLayouts.get(5));
                enemy6MoveThread.start();

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                enemy7MoveThread = new EnemyMoveThread(enemy7, iv_enemy7, enemyHpBarLayouts.get(6));
                enemy7MoveThread.start();

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                enemy8MoveThread = new EnemyMoveThread(enemy8, iv_enemy8, enemyHpBarLayouts.get(7));
                enemy8MoveThread.start();


                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                enemy9MoveThread = new EnemyMoveThread(enemy9, iv_enemy9, enemyHpBarLayouts.get(8));
                enemy9MoveThread.start();


                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                enemy10MoveThread = new EnemyMoveThread(enemy10, iv_enemy10, enemyHpBarLayouts.get(9));
                enemy10MoveThread.start();
                if (stage % 5 == 0) {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    enemyBossMoveThread = new EnemyMoveThread(enemyBoss, iv_enemyBoss, enemyHpBarLayouts.get(10));
                    enemyBossMoveThread.start();

                }
            } catch (Exception e) {   // interrupt 됐을 때 일로옴.
                if (startCountThread.isAlive() && stage != 21) {
                    int sum = 0;
                    for (int i = 0; i < enemies.size(); i++) {
                        sum += enemies.get(i).getHp();
                    }

                    if (sum > 0) {
                        Log.d(TAG, "startGameCountThread 살아있으면 여기서 죽이고감");
                        startGameCountThread.interrupt();
                    }
                    Log.d(TAG, "버튼으로 인터럽트");


                }
//                else if (stage == 21) {
//
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//
//
//                            Log.d(TAG, "스테이지 전부 클리어하면 여기로옴");
//                            Intent intent = new Intent(Activity_InfinityStage.this, Activity_Ranking.class);
//                            animation = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_reset); // 이미지뷰 위치 초기화 애니메이션
//                            animationHpBar = AnimationUtils.loadAnimation(Activity_InfinityStage.this, R.anim.enemy_translate_reset); // 이미지뷰 위치 초기화 애니메이션
//
//                            for (int i = 0; i < 11; i++) {
//                                enemyHpBarLayouts.get(i).startAnimation(animationHpBar);
//                            }
//
//                            iv_enemy1.startAnimation(animation);
//                            iv_enemy2.startAnimation(animation);
//                            iv_enemy3.startAnimation(animation);
//                            iv_enemy4.startAnimation(animation);
//                            iv_enemy5.startAnimation(animation);
//                            iv_enemy6.startAnimation(animation);
//                            iv_enemy7.startAnimation(animation);
//                            iv_enemy8.startAnimation(animation);
//                            iv_enemy9.startAnimation(animation);
//                            iv_enemy10.startAnimation(animation);
//                            iv_enemyBoss.startAnimation(animation);
//
//                            enemyHpThread.interrupt();
//                            dice1AttackEnemyThread.interrupt();
//                            dice2AttackEnemyThread.interrupt();
//                            dice3AttackEnemyThread.interrupt();
//                            dice4AttackEnemyThread.interrupt();
//                            scoreS[index] = Integer.toString(score);
//
//                            resultSCORE = "";
//                            for (int i = 0; i < scoreS.length; i++) {
//
//                                if (i == 0) {
//
//                                    resultSCORE = resultSCORE + scoreS[i];
//
//                                    Log.d(TAG, "onClick: 1번 찍혀야되는 로그임");
//                                } else {
//                                    resultSCORE = resultSCORE + "," + scoreS[i];
//
//                                }
//                            }
//                            SharedPreferences.Editor editor = preferences.edit();
//                            editor.putString("유저 점수", resultSCORE);
//
//                            editor.commit();
//                            dialog = new AlertDialog.Builder(Activity_InfinityStage.this);
//                            dialog.setTitle("클리어 성공");
//                            dialog.setMessage("" + idS[index] + "님 : " + score + " 점");
//                            dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    intent.putExtra("아이디", idS[index]);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            });
//                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                                @Override
//                                public void onDismiss(DialogInterface dialog) {
//                                    intent.putExtra("아이디", idS[index]);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            });
//
//                            dialog.show();
//                        }
//                    });
//
//                    // 클리어 했을때
//                }


            }


        }
    }

    public class EnemyHpThread extends Thread {

        @Override
        public void run() {
            try {


                super.run();
                Log.d("적 HP", "적 HP 보여주는 스레드 들어왔음" + enemies.size());
                for (int i = 0; i < enemies.size(); i++) {

                    while (enemies.get(i).getHp() > 0) {
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        String enemyHp = Integer.toString(enemies.get(i).getHp());

                        handler.post(new Runnable() {
                            @Override
                            public void run() {


                                for (int j = 0; j < 11; j++) {
                                    enemyHpBars.get(j).setProgress(enemies.get(j).getHp());

                                }

                            }
                        });


                        if (enemies.get(i).getHp() <= 0) {             // 다음적으로 가기위한 break;
                            break;
                        }

                    }
                }


            } catch (Exception e) {

            }

        }
    }


}