package com.example.sam_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    String name;
    Paint paint = new Paint();

    Random random = new Random();

    String choiceType;


    int attack;
    int[] choiceNums = new int[100];
    int border = 100;
    int choiceNum;
    TimeDelay timeDelay = new TimeDelay();
    int x;
    int y;
    Context context;

    public Dice(Context context) {
        this.context = context;
    }

    Animation animation;
    Animation animation0_1;
    Animation animation1;
    Animation animation2;
    Animation animation3;
    Animation animation4;
    Animation animation5;

    MediaPlayer mediaPlayer;


    public void drawDice(Canvas canvas, String choiceType, int x, int y) { // x,y 좌표값 을 받아서 좌표값 중심 으로 주사위 를 만듬.
        this.choiceType = choiceType;
        this.x = x;
        this.y = y;
        Log.e("Dice", "주사위 객체의 주사위 그리기 메소드 켜짐");
        Log.e("Dice", choiceType);
        for (int i = 0; i < 50; i++) {  // 주사위 눈 1 나올 확률 = 50%
            choiceNums[i] = 0;
        }
        for (int i = 50; i < 75; i++) { // 주사위 눈 2 나올 확률 = 25%
            choiceNums[i] = 1;
        }
        for (int i = 75; i < 90; i++) { // 주사위 눈 3 나올 확률 = 15%
            choiceNums[i] = 2;
        }
        for (int i = 90; i < 95; i++) {  // 주사위 눈 4 나올 확률 = 5%
            choiceNums[i] = 3;
        }
        for (int i = 95; i < 98; i++) { // 주사위 눈 5 나올 확률 = 3%
            choiceNums[i] = 4;
        }
        for (int i = 98; i < 100; i++) { // 주사위 눈 6 나올 확률 = 2%
            choiceNums[i] = 5;
        }


        Log.e("Dice", "배열 만들고 배열 안에 숫자 넣음");

        RectF Dice1 = new RectF(); // RectF를 이용해 사각형 틀을 가진 객체를 만듬.


        Dice1.set(x - border, y - border, x + border, y + border); // 중심 좌표로 한 변 200 짜리 정 사각형 세팅


        choiceNum = choiceNums[random.nextInt(100)]; // int 값을 지정 하고 랜덤값 뽑는게 안되는 경우가 없음.


        if (choiceType.equals("불")) { // 여기서 불 주사위 1부터 6까지 랜덤 으로 나오게 하는 로직이 실행 되게 한다.
            Log.e("Dice", "불 주사위 로 들어옴");

            if (choiceNum == 0) { // 주사위 눈 1 그림
                Log.e("Dice", "불 주사위 눈금 1 그림");
                attack = 4;

                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x, y, 30, paint);
            } else if (choiceNum == 1) { // 주사위 눈 2 그림
                Log.e("Dice", "불 주사위 눈금 2 그림");
                attack = 8;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);
                //                canvas.drawRect(275, 400, 475, 600, paint);

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            } else if (choiceNum == 2) { // 주사위 눈 3 그림
                Log.e("Dice", "불 주사위 눈금 3 그림");
                attack = 12;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint); //좌상
                canvas.drawCircle(x, y, 20, paint); // 가운데
                canvas.drawCircle(x + 50, y + 50, 20, paint); // 우하

            } else if (choiceNum == 3) { // 주사위 눈 4 그림
                Log.e("Dice", "불 주사위 눈금 4 그림");
                attack = 16;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 4) { // 주사위 눈 5 그림
                Log.e("Dice", "불 주사위 눈금 5 그림");
                attack = 20;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x, y, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 5) { // 주사위 눈 6 그림
                Log.e("Dice", "불 주사위 눈금 6 그림");
                attack = 24;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y, 20, paint);
                canvas.drawCircle(x - 50, y, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            }
        } else if (choiceType.equals("물")) { // 여기서 물 주사위 1부터 6까지 랜덤 으로 나오게 하는 로직이 실행 되게 한다.
            Log.e("Dice", "물 주사위 로 들어옴");
            if (choiceNum == 0) { // 주사위 눈 1 그림 = 80%
                Log.e("Dice", "물 주사위 눈금 1 그림");
                attack = 2;
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x, y, 30, paint);
            } else if (choiceNum == 1) { // 주사위 눈 2 그림 = 20%
                Log.e("Dice", "물 주사위 눈금 2 그림");
                attack = 4;
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);

            } else if (choiceNum == 2) { // 주사위 눈 3 그림
                Log.e("Dice", "물 주사위 눈금 3 그림");
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);
                attack = 6;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint); //좌상
                canvas.drawCircle(x, y, 20, paint); // 가운데
                canvas.drawCircle(x + 50, y + 50, 20, paint); // 우하

            } else if (choiceNum == 3) { // 주사위 눈 4 그림
                Log.e("Dice", "물 주사위 눈금 4 그림");
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);
                attack = 8;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 4) { // 주사위 눈 5 그림
                Log.e("Dice", "물 주사위 눈금 5 그림");
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);
                attack = 10;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x, y, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 5) { // 주사위 눈 6 그림
                Log.e("Dice", "물 주사위 눈금 6 그림");
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);
                attack = 12;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y, 20, paint);
                canvas.drawCircle(x - 50, y, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            }
        } else if (choiceType.equals("전기")) { // 여기서 전기 주사위 1부터 6까지 랜덤 으로 나오게 하는 로직이 실행 되게 한다.
            Log.e("Dice", "전기 주사위 로 들어옴");

            if (choiceNum == 0) { // 주사위 눈 1 그림 = 80%
                Log.e("Dice", "전기 주사위 눈금 1 그림");
                attack = 1;
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x, y, 30, paint);
            } else if (choiceNum == 1) { // 주사위 눈 2 그림 = 20%
                Log.e("Dice", "전기 주사위 눈금 2 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 2;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            } else if (choiceNum == 2) { // 주사위 눈 3 그림
                Log.e("Dice", "전기 주사위 눈금 3 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 3;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint); //좌상
                canvas.drawCircle(x, y, 20, paint); // 가운데
                canvas.drawCircle(x + 50, y + 50, 20, paint); // 우하

            } else if (choiceNum == 3) { // 주사위 눈 4 그림
                Log.e("Dice", "전기 주사위 눈금 4 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 4;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 4) { // 주사위 눈 5 그림
                Log.e("Dice", "전기 주사위 눈금 5 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 5;


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x, y, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 5) { // 주사위 눈 6 그림
                Log.e("Dice", "전기 주사위 눈금 6 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 6;


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y, 20, paint);
                canvas.drawCircle(x - 50, y, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            }
        }

    } // drawDice 메소드 끝

    public void drawDiceAttack(MediaPlayer mediaPlayer, ArrayList<ImageView> iv_effectDices, Bitmap enemyBitmap, ArrayList<Canvas> canvasEffectDices, Dice dice, Enemy enemy, ArrayList<Enemy> enemies, int index) { // 다이스 가 적을 공격 하는 메소드
        this.mediaPlayer = mediaPlayer;

        // 눈금의 수에 맞게 공격이 나가게한다.
        if (choiceType.equals("불")) {

            if (dice.choiceNum == 0) { // 주사위 눈금 1일 때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {

                    paint.setColor(Color.RED);
//                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {
                        animation = new TranslateAnimation(0, enemy.x - dice.x, 0, enemy.y - dice.y);
                        animation.setDuration(250);
                        animation.setFillAfter(false);
                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x, dice.y, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);


//

                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }
            } else if (dice.choiceNum == 1) { // 주사위 눈금 2일때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {
                    paint.setColor(Color.RED);

                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));


                        animation.setDuration(250);
                        animation1.setDuration(250);
                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }
            } else if (dice.choiceNum == 2) { // 주사위 눈금 3일때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.RED);
                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {
                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));
                        animation2 = new TranslateAnimation(0, enemy.x - dice.x, 0, enemy.y - dice.y);

                        animation.setDuration(250);
                        animation1.setDuration(250);
                        animation2.setDuration(250);

                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation2.setFillAfter(false);

                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation2.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(2).drawCircle(dice.x, dice.y, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);
                        iv_effectDices.get(2).startAnimation(animation2);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }

            } else if (dice.choiceNum == 3) { // 주사위 눈금 4일때
                if (enemy.x == 0 || enemy.y == 0 || enemy.getHp() <= 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.RED);
                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0) {
                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));
                        animation2 = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y + 50));
                        animation3 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y - 50));

                        animation.setDuration(250);
                        animation1.setDuration(250);
                        animation2.setDuration(250);
                        animation3.setDuration(250);

                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation2.setFillAfter(false);
                        animation3.setFillAfter(false);

                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation2.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation3.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(2).drawCircle(dice.x - 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(3).drawCircle(dice.x + 50, dice.y - 50, 15, paint);


                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);
                        iv_effectDices.get(2).startAnimation(animation2);
                        iv_effectDices.get(3).startAnimation(animation3);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }
            } else if (dice.choiceNum == 4) { // 주사위 눈금 5일때
                if (enemy.x == 0 || enemy.y == 0 || enemy.getHp() <= 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.RED);
                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0) {
                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));
                        animation2 = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y + 50));
                        animation3 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y - 50));
                        animation4 = new TranslateAnimation(0, enemy.x - dice.x, 0, enemy.y - dice.y);

                        animation.setDuration(250);
                        animation1.setDuration(250);
                        animation2.setDuration(250);
                        animation3.setDuration(250);
                        animation4.setDuration(250);

                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation2.setFillAfter(false);
                        animation3.setFillAfter(false);
                        animation4.setFillAfter(false);

                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation2.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation3.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation4.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(2).drawCircle(dice.x - 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(3).drawCircle(dice.x + 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(4).drawCircle(dice.x, dice.y, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);
                        iv_effectDices.get(2).startAnimation(animation2);
                        iv_effectDices.get(3).startAnimation(animation3);
                        iv_effectDices.get(4).startAnimation(animation4);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }
            } else if (dice.choiceNum == 5) { // 주사위 눈금  6 일때
                if (enemy.x == 0 || enemy.y == 0 || enemy.getHp() <= 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {

                    paint.setColor(Color.RED);
                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0) {
                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));
                        animation2 = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y + 50));
                        animation3 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y - 50));
                        animation4 = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - dice.y);
                        animation5 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - dice.y);

                        animation.setDuration(250);
                        animation1.setDuration(250);
                        animation2.setDuration(250);
                        animation3.setDuration(250);
                        animation4.setDuration(250);
                        animation5.setDuration(250);

                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation2.setFillAfter(false);
                        animation3.setFillAfter(false);
                        animation4.setFillAfter(false);
                        animation5.setFillAfter(false);

                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation2.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation3.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation4.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation5.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(2).drawCircle(dice.x - 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(3).drawCircle(dice.x + 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(4).drawCircle(dice.x - 50, dice.y, 15, paint);
                        canvasEffectDices.get(5).drawCircle(dice.x + 50, dice.y, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);
                        iv_effectDices.get(2).startAnimation(animation2);
                        iv_effectDices.get(3).startAnimation(animation3);
                        iv_effectDices.get(4).startAnimation(animation4);
                        iv_effectDices.get(5).startAnimation(animation5);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }

            }

        } else if (choiceType.equals("물")) {

            if (dice.choiceNum == 0) { // 주사위 눈금 1일 때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {

                    paint.setColor(Color.BLUE);
//                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {
                        animation = new TranslateAnimation(0, enemy.x - dice.x, 0, enemy.y - dice.y);
                        animation.setDuration(150);
                        animation.setFillAfter(false);
                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x, dice.y, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }
            } else if (dice.choiceNum == 1) { // 주사위 눈금 2일때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {
                    paint.setColor(Color.BLUE);

                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));

                        animation.setDuration(150);
                        animation1.setDuration(150);
                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }
            } else if (dice.choiceNum == 2) { // 주사위 눈금 3일때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.BLUE);
                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {
                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));
                        animation2 = new TranslateAnimation(0, enemy.x - dice.x, 0, enemy.y - dice.y);

                        animation.setDuration(150);
                        animation1.setDuration(150);
                        animation2.setDuration(150);

                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation2.setFillAfter(false);

                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation2.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(2).drawCircle(dice.x, dice.y, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);
                        iv_effectDices.get(2).startAnimation(animation2);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }

            } else if (dice.choiceNum == 3) { // 주사위 눈금 4일때
                if (enemy.x == 0 || enemy.y == 0 || enemy.getHp() <= 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.BLUE);
                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0) {
                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));
                        animation2 = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y + 50));
                        animation3 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y - 50));

                        animation.setDuration(150);
                        animation1.setDuration(150);
                        animation2.setDuration(150);
                        animation3.setDuration(150);

                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation2.setFillAfter(false);
                        animation3.setFillAfter(false);

                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation2.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation3.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(2).drawCircle(dice.x - 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(3).drawCircle(dice.x + 50, dice.y - 50, 15, paint);


                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);
                        iv_effectDices.get(2).startAnimation(animation2);
                        iv_effectDices.get(3).startAnimation(animation3);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }
            } else if (dice.choiceNum == 4) { // 주사위 눈금 5일때
                if (enemy.x == 0 || enemy.y == 0 || enemy.getHp() <= 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.BLUE);
                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0) {
                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));
                        animation2 = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y + 50));
                        animation3 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y - 50));
                        animation4 = new TranslateAnimation(0, enemy.x - dice.x, 0, enemy.y - dice.y);

                        animation.setDuration(150);
                        animation1.setDuration(150);
                        animation2.setDuration(150);
                        animation3.setDuration(150);
                        animation4.setDuration(150);

                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation2.setFillAfter(false);
                        animation3.setFillAfter(false);
                        animation4.setFillAfter(false);

                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation2.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation3.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation4.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(2).drawCircle(dice.x - 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(3).drawCircle(dice.x + 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(4).drawCircle(dice.x, dice.y, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);
                        iv_effectDices.get(2).startAnimation(animation2);
                        iv_effectDices.get(3).startAnimation(animation3);
                        iv_effectDices.get(4).startAnimation(animation4);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }
            } else if (dice.choiceNum == 5) { // 주사위 눈금  6 일때
                if (enemy.x == 0 || enemy.y == 0 || enemy.getHp() <= 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {

                    paint.setColor(Color.BLUE);
                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0) {
                    } else {
                        animation = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y - 50));
                        animation1 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y + 50));
                        animation2 = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - (dice.y + 50));
                        animation3 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - (dice.y - 50));
                        animation4 = new TranslateAnimation(0, enemy.x - (dice.x - 50), 0, enemy.y - dice.y);
                        animation5 = new TranslateAnimation(0, enemy.x - (dice.x + 50), 0, enemy.y - dice.y);

                        animation.setDuration(150);
                        animation1.setDuration(150);
                        animation2.setDuration(150);
                        animation3.setDuration(150);
                        animation4.setDuration(150);
                        animation5.setDuration(150);

                        animation.setFillAfter(false);
                        animation1.setFillAfter(false);
                        animation2.setFillAfter(false);
                        animation3.setFillAfter(false);
                        animation4.setFillAfter(false);
                        animation5.setFillAfter(false);

                        animation.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation1.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation2.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation3.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation4.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));
                        animation5.setInterpolator(AnimationUtils.loadInterpolator(context, android.R.anim.decelerate_interpolator));

                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(2).drawCircle(dice.x - 50, dice.y + 50, 15, paint);
                        canvasEffectDices.get(3).drawCircle(dice.x + 50, dice.y - 50, 15, paint);
                        canvasEffectDices.get(4).drawCircle(dice.x - 50, dice.y, 15, paint);
                        canvasEffectDices.get(5).drawCircle(dice.x + 50, dice.y, 15, paint);

                        iv_effectDices.get(0).startAnimation(animation);
                        iv_effectDices.get(1).startAnimation(animation1);
                        iv_effectDices.get(2).startAnimation(animation2);
                        iv_effectDices.get(3).startAnimation(animation3);
                        iv_effectDices.get(4).startAnimation(animation4);
                        iv_effectDices.get(5).startAnimation(animation5);

                        enemy.setHp(enemy.getHp() - dice.attack);


                        if (enemy.getHp() <= 0) {

                            enemy.drawEnemyDie(enemyBitmap);

                        }
                    }
                }

            }

        } else if (choiceType.equals("전기")) {

            if (dice.choiceNum == 0) { // 주사위 눈금 1일 떄

                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.YELLOW);
                    paint.setStrokeWidth(5);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {

                        canvasEffectDices.get(0).drawLine(dice.x, dice.y, enemy.x, enemy.y, paint);

                        if (enemies.get(10).getHp() > 0) {  // 보스몬스터 있는 경우

                            for (int i = index; i < enemies.size() - 1; i++) {
                                canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                if (enemies.get(i).getHp() <= 0) {

                                    enemies.get(i).drawEnemyDie(enemyBitmap);

                                }
                            }

                            mediaPlayer.start();

                            for (int i = 0; i < enemies.size(); i++) {
                                enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                if (enemy.getHp() <= 0) {

                                    enemy.drawEnemyDie(enemyBitmap);

                                }
                            }
                        } else {  // 보스몬스터 없는 경우
                            if (enemies.get(index).x == 0 || enemies.get(index).y == 0 || enemies.get(index).getHp() == 0) {

                            } else {
                                for (int i = index; i < enemies.size() - 2; i++) { // 보스 아닐때 돌아가는 전체 공격

                                    canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);


                                }

                                mediaPlayer.start();

                                for (int i = 0; i < enemies.size(); i++) {
                                    enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                    if (enemy.getHp() <= 0) {

                                        enemy.drawEnemyDie(enemyBitmap);

                                    }
                                }
                            }

                        }


                    }

                }


            } else if (dice.choiceNum == 1) { // 주사위 눈금 2일때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.YELLOW);
                    paint.setStrokeWidth(8);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {

                        canvasEffectDices.get(0).drawLine(dice.x, dice.y, enemy.x, enemy.y, paint);

                        if (enemies.get(10).getHp() > 0) {  // 보스몬스터 있는 경우

                            for (int i = index; i < enemies.size() - 1; i++) {
                                canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                if (enemies.get(i).getHp() <= 0) {

                                    enemies.get(i).drawEnemyDie(enemyBitmap);
                                }
                            }

                            mediaPlayer.start();


                            for (int i = 0; i < enemies.size(); i++) {
                                enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                if (enemy.getHp() <= 0) {

                                    enemy.drawEnemyDie(enemyBitmap);

                                }
                            }
                        } else {  // 보스몬스터 없는 경우
                            if (enemies.get(index).x == 0 || enemies.get(index).y == 0 || enemies.get(index).getHp() == 0) {

                            } else {
                                for (int i = index; i < enemies.size() - 2; i++) { // 보스 아닐때 돌아가는 전체 공격

                                    canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                    if (enemies.get(i).getHp() <= 0) {

                                        enemies.get(i).drawEnemyDie(enemyBitmap);
                                    }

                                }

                                mediaPlayer.start();

                                for (int i = 0; i < enemies.size(); i++) {
                                    enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                    if (enemy.getHp() <= 0) {

                                        enemy.drawEnemyDie(enemyBitmap);

                                    }
                                }
                            }

                        }


                    }

                }

            } else if (dice.choiceNum == 2) { // 주사위 눈금 3일때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.YELLOW);
                    paint.setStrokeWidth(11);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {

                        canvasEffectDices.get(0).drawLine(dice.x, dice.y, enemy.x, enemy.y, paint);

                        if (enemies.get(10).getHp() > 0) {  // 보스몬스터 있는 경우

                            for (int i = index; i < enemies.size() - 1; i++) {
                                canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                if (enemies.get(i).getHp() <= 0) {

                                    enemies.get(i).drawEnemyDie(enemyBitmap);
                                }
                            }

                            mediaPlayer.start();

                            for (int i = 0; i < enemies.size(); i++) {
                                enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                if (enemy.getHp() <= 0) {

                                    enemy.drawEnemyDie(enemyBitmap);

                                }
                            }
                        } else {  // 보스몬스터 없는 경우
                            if (enemies.get(index).x == 0 || enemies.get(index).y == 0 || enemies.get(index).getHp() == 0) {

                            } else {
                                for (int i = index; i < enemies.size() - 2; i++) { // 보스 아닐때 돌아가는 전체 공격

                                    canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                    if (enemies.get(i).getHp() <= 0) {

                                        enemies.get(i).drawEnemyDie(enemyBitmap);
                                    }

                                }

                                mediaPlayer.start();

                                for (int i = 0; i < enemies.size(); i++) {
                                    enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                    if (enemy.getHp() <= 0) {

                                        enemy.drawEnemyDie(enemyBitmap);

                                    }
                                }
                            }

                        }


                    }

                }
            } else if (dice.choiceNum == 3) { // 주사위 눈금 4일때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.YELLOW);
                    paint.setStrokeWidth(14);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {

                        canvasEffectDices.get(0).drawLine(dice.x, dice.y, enemy.x, enemy.y, paint);

                        if (enemies.get(10).getHp() > 0) {  // 보스몬스터 있는 경우

                            for (int i = index; i < enemies.size() - 1; i++) {
                                canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                if (enemies.get(i).getHp() <= 0) {

                                    enemies.get(i).drawEnemyDie(enemyBitmap);
                                }
                            }

                            mediaPlayer.start();

                            for (int i = 0; i < enemies.size(); i++) {
                                enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                if (enemy.getHp() <= 0) {

                                    enemy.drawEnemyDie(enemyBitmap);

                                }
                            }
                        } else {  // 보스몬스터 없는 경우
                            if (enemies.get(index).x == 0 || enemies.get(index).y == 0 || enemies.get(index).getHp() == 0) {

                            } else {
                                for (int i = index; i < enemies.size() - 2; i++) { // 보스 아닐때 돌아가는 전체 공격

                                    canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                    if (enemies.get(i).getHp() <= 0) {

                                        enemies.get(i).drawEnemyDie(enemyBitmap);
                                    }

                                }

                                mediaPlayer.start();

                                for (int i = 0; i < enemies.size(); i++) {
                                    enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                    if (enemy.getHp() <= 0) {

                                        enemy.drawEnemyDie(enemyBitmap);

                                    }
                                }
                            }

                        }


                    }

                }
            } else if (dice.choiceNum == 4) { // 주사위 눈금 5 일때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.YELLOW);
                    paint.setStrokeWidth(17);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {

                        canvasEffectDices.get(0).drawLine(dice.x, dice.y, enemy.x, enemy.y, paint);

                        if (enemies.get(10).getHp() > 0) {  // 보스몬스터 있는 경우

                            for (int i = index; i < enemies.size() - 1; i++) {
                                canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                if (enemies.get(i).getHp() <= 0) {

                                    enemies.get(i).drawEnemyDie(enemyBitmap);
                                }
                            }

                            mediaPlayer.start();

                            for (int i = 0; i < enemies.size(); i++) {
                                enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                if (enemy.getHp() <= 0) {

                                    enemy.drawEnemyDie(enemyBitmap);

                                }
                            }
                        } else {  // 보스몬스터 없는 경우
                            if (enemies.get(index).x == 0 || enemies.get(index).y == 0 || enemies.get(index).getHp() == 0) {

                            } else {
                                for (int i = index; i < enemies.size() - 2; i++) { // 보스 아닐때 돌아가는 전체 공격

                                    canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                    if (enemies.get(i).getHp() <= 0) {

                                        enemies.get(i).drawEnemyDie(enemyBitmap);
                                    }

                                }

                                mediaPlayer.start();

                                for (int i = 0; i < enemies.size(); i++) {
                                    enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                    if (enemy.getHp() <= 0) {

                                        enemy.drawEnemyDie(enemyBitmap);

                                    }
                                }
                            }

                        }


                    }

                }
            } else if (dice.choiceNum == 5) { // 주사위 눈금 6 일때
                if (enemy.x == 0 || enemy.y == 0) {
                    enemy.x = 0;
                    enemy.y = 0;
                } else {


                    paint.setColor(Color.YELLOW);
                    paint.setStrokeWidth(20);
                    if (dice.x == 0 || dice.y == 0 || enemy.getHp() <= 0) {

                    } else {

                        canvasEffectDices.get(0).drawLine(dice.x, dice.y, enemy.x, enemy.y, paint);

                        if (enemies.get(10).getHp() > 0) {  // 보스몬스터 있는 경우

                            for (int i = index; i < enemies.size() - 1; i++) {
                                canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                if (enemies.get(i).getHp() <= 0) {

                                    enemies.get(i).drawEnemyDie(enemyBitmap);
                                }
                            }

                            mediaPlayer.start();

                            for (int i = 0; i < enemies.size(); i++) {
                                enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                if (enemy.getHp() <= 0) {

                                    enemy.drawEnemyDie(enemyBitmap);

                                }
                            }
                        } else {  // 보스몬스터 없는 경우
                            if (enemies.get(index).x == 0 || enemies.get(index).y == 0 || enemies.get(index).getHp() == 0) {

                            } else {
                                for (int i = index; i < enemies.size() - 2; i++) { // 보스 아닐때 돌아가는 전체 공격

                                    canvasEffectDices.get(0).drawLine(enemies.get(i).x, enemies.get(i).y, enemies.get(i + 1).x, enemies.get(i + 1).y, paint);
                                    if (enemies.get(i).getHp() <= 0) {

                                        enemies.get(i).drawEnemyDie(enemyBitmap);
                                    }

                                }

                                mediaPlayer.start();

                                for (int i = 0; i < enemies.size(); i++) {
                                    enemies.get(i).setHp(enemies.get(i).getHp() - dice.attack);

                                    if (enemy.getHp() <= 0) {

                                        enemy.drawEnemyDie(enemyBitmap);

                                    }
                                }
                            }

                        }


                    }

                }

            }

        }
    }

    public void sellDice(Canvas canvas, String choiceType, int x, int y) { // 사용 보류중
        Log.e("Dice", "주사위 판매");
        this.choiceType = choiceType;
        this.x = x;
        this.y = y;
        RectF Dice1 = new RectF(); // RectF를 이용해 사각형 틀을 가진 객체를 만듬.
        Dice1.set(x - border, y - border, x + border, y + border);

        if (choiceType.equals("불")) { // 여기서 불 주사위 1부터 6까지 랜덤 으로 나오게 하는 로직이 실행 되게 한다.
            Log.e("Dice", "불 주사위 로 들어옴");
            if (choiceNum == 0) { // 주사위 눈 1 그림
                Log.e("Dice", "불 주사위 눈금 1 그림");


                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);

                paint.setColor(Color.WHITE);
                canvas.drawCircle(x, y, 30, paint);
            } else if (choiceNum == 1) { // 주사위 눈 2 그림
                Log.e("Dice", "불 주사위 눈금 2 그림");

                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);
                //                canvas.drawRect(275, 400, 475, 600, paint);

                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            } else if (choiceNum == 2) { // 주사위 눈 3 그림
                Log.e("Dice", "불 주사위 눈금 3 그림");

                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint); //좌상
                canvas.drawCircle(x, y, 20, paint); // 가운데
                canvas.drawCircle(x + 50, y + 50, 20, paint); // 우하

            } else if (choiceNum == 3) { // 주사위 눈 4 그림
                Log.e("Dice", "불 주사위 눈금 4 그림");

                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 4) { // 주사위 눈 5 그림
                Log.e("Dice", "불 주사위 눈금 5 그림");

                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x, y, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 5) { // 주사위 눈 6 그림
                Log.e("Dice", "불 주사위 눈금 6 그림");

                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y, 20, paint);
                canvas.drawCircle(x - 50, y, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            }
        } else if (choiceType.equals("물")) { // 여기서 물 주사위 1부터 6까지 랜덤 으로 나오게 하는 로직이 실행 되게 한다.
            Log.e("Dice", "물 주사위 로 들어옴");
            if (choiceNum == 0) { // 주사위 눈 1 그림 = 80%
                Log.e("Dice", "물 주사위 눈금 1 그림");

                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);

                paint.setColor(Color.WHITE);
                canvas.drawCircle(x, y, 30, paint);
            } else if (choiceNum == 1) { // 주사위 눈 2 그림 = 20%
                Log.e("Dice", "물 주사위 눈금 2 그림");

                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);
                //                canvas.drawRect(275, 400, 475, 600, paint);

                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            } else if (choiceNum == 2) { // 주사위 눈 3 그림
                Log.e("Dice", "물 주사위 눈금 3 그림");
                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint); //좌상
                canvas.drawCircle(x, y, 20, paint); // 가운데
                canvas.drawCircle(x + 50, y + 50, 20, paint); // 우하

            } else if (choiceNum == 3) { // 주사위 눈 4 그림
                Log.e("Dice", "물 주사위 눈금 4 그림");
                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 4) { // 주사위 눈 5 그림
                Log.e("Dice", "물 주사위 눈금 5 그림");
                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x, y, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 5) { // 주사위 눈 6 그림
                Log.e("Dice", "물 주사위 눈금 6 그림");
                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y, 20, paint);
                canvas.drawCircle(x - 50, y, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            }
        } else if (choiceType.equals("전기")) { // 여기서 전기 주사위 1부터 6까지 랜덤 으로 나오게 하는 로직이 실행 되게 한다.
            Log.e("Dice", "전기 주사위 로 들어옴");
            if (choiceNum == 0) { // 주사위 눈 1 그림 = 80%
                Log.e("Dice", "전기 주사위 눈금 1 그림");

                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);

                paint.setColor(Color.WHITE);
                canvas.drawCircle(x, y, 30, paint);
            } else if (choiceNum == 1) { // 주사위 눈 2 그림 = 20%
                Log.e("Dice", "전기 주사위 눈금 2 그림");
                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            } else if (choiceNum == 2) { // 주사위 눈 3 그림
                Log.e("Dice", "전기 주사위 눈금 3 그림");
                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE); // 주사위 눈금
                canvas.drawCircle(x - 50, y - 50, 20, paint); //좌상
                canvas.drawCircle(x, y, 20, paint); // 가운데
                canvas.drawCircle(x + 50, y + 50, 20, paint); // 우하

            } else if (choiceNum == 3) { // 주사위 눈 4 그림
                Log.e("Dice", "전기 주사위 눈금 4 그림");
                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 4) { // 주사위 눈 5 그림
                Log.e("Dice", "전기 주사위 눈금 5 그림");
                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x, y, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 5) { // 주사위 눈 6 그림
                Log.e("Dice", "전기 주사위 눈금 6 그림");
                paint.setColor(Color.WHITE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y, 20, paint);
                canvas.drawCircle(x - 50, y, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            }
        }

        this.attack = 0;
        this.x = 0;
        this.y = 0;
    }

    public void upgradeDice(int upgradeNum, Canvas canvas , String choiceType,int x ,int y) {
        this.x = x;
        this.y = y;
        this.choiceNum = upgradeNum;

        RectF Dice1 = new RectF(); // RectF를 이용해 사각형 틀을 가진 객체를 만듬.


        Dice1.set(x - border, y - border, x + border, y + border); // 중심 좌표로 한 변 200 짜리 정 사각형 세팅


        if (this.choiceType.equals("불")) { // 선택된 주사위가 불주사위 일 경우

            if (upgradeNum == 1) { // 주사위 눈 2 그림
                Log.e("Dice", "불 주사위 눈금 2 그림");
                attack = 8;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);

            } else if (upgradeNum == 2) { // 주사위 눈 3 그림
                Log.e("Dice", "불 주사위 눈금 3 그림");
                attack = 12;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint); //좌상
                canvas.drawCircle(x, y, 20, paint); // 가운데
                canvas.drawCircle(x + 50, y + 50, 20, paint); // 우하

            } else if (upgradeNum == 3) { // 주사위 눈 4 그림
                Log.e("Dice", "불 주사위 눈금 4 그림");
                attack = 16;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (upgradeNum == 4) { // 주사위 눈 5 그림
                Log.e("Dice", "불 주사위 눈금 5 그림");
                attack = 20;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x, y, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (upgradeNum == 5) { // 주사위 눈 6 그림
                Log.e("Dice", "불 주사위 눈금 6 그림");
                attack = 24;
                paint.setColor(Color.RED);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y, 20, paint);
                canvas.drawCircle(x - 50, y, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            }

        } else if (this.choiceType.equals("물")) { // 선택된 주사위가 물주사위 일 경우

            if (choiceNum == 1) { // 주사위 눈 2 그림 = 20%
                Log.e("Dice", "물 주사위 눈금 2 그림");
                attack = 4;
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);

            } else if (choiceNum == 2) { // 주사위 눈 3 그림
                Log.e("Dice", "물 주사위 눈금 3 그림");
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);
                attack = 6;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint); //좌상
                canvas.drawCircle(x, y, 20, paint); // 가운데
                canvas.drawCircle(x + 50, y + 50, 20, paint); // 우하

            } else if (choiceNum == 3) { // 주사위 눈 4 그림
                Log.e("Dice", "물 주사위 눈금 4 그림");
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);
                attack = 8;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 4) { // 주사위 눈 5 그림
                Log.e("Dice", "물 주사위 눈금 5 그림");
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);
                attack = 10;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x, y, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 5) { // 주사위 눈 6 그림
                Log.e("Dice", "물 주사위 눈금 6 그림");
                paint.setColor(Color.BLUE);
                canvas.drawRect(Dice1, paint);
                attack = 12;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y, 20, paint);
                canvas.drawCircle(x - 50, y, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            }

        } else if (this.choiceType.equals("전기")) { // 선택된 주사위가 전기주사위 일 경우
            Log.e("Dice", "전기 주사위 로 들어옴");

            if (choiceNum == 1) { // 주사위 눈 2 그림 = 20%
                Log.e("Dice", "전기 주사위 눈금 2 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 2;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            } else if (choiceNum == 2) { // 주사위 눈 3 그림
                Log.e("Dice", "전기 주사위 눈금 3 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 3;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint); //좌상
                canvas.drawCircle(x, y, 20, paint); // 가운데
                canvas.drawCircle(x + 50, y + 50, 20, paint); // 우하

            } else if (choiceNum == 3) { // 주사위 눈 4 그림
                Log.e("Dice", "전기 주사위 눈금 4 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 4;

                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 4) { // 주사위 눈 5 그림
                Log.e("Dice", "전기 주사위 눈금 5 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 5;


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x, y, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
            } else if (choiceNum == 5) { // 주사위 눈 6 그림
                Log.e("Dice", "전기 주사위 눈금 6 그림");
                paint.setColor(Color.YELLOW);
                canvas.drawRect(Dice1, paint);
                attack = 6;


                paint.setColor(Color.BLACK);
                canvas.drawCircle(x - 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y - 50, 20, paint);
                canvas.drawCircle(x + 50, y, 20, paint);
                canvas.drawCircle(x - 50, y, 20, paint);
                canvas.drawCircle(x - 50, y + 50, 20, paint);
                canvas.drawCircle(x + 50, y + 50, 20, paint);
            }

        }


    }


}
