package com.example.sam_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Enemy {



    TimeDelay timeDelay;
    int hp;
    float x;
    float y;
    boolean life = true;
    boolean live = false;
    Context context;
    Bitmap enemyBitmap;
    Paint paint = new Paint();

    Animation animation;
    int score;


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp <= 0) {
            this.hp = 0;

        } else {
            this.hp = hp;
        }
    }

    public void drawEnemy(Canvas canvasEnemy, float x, float y, int stage) {
        this.x = x;
        this.y = y;
        this.setHp(stage * 20);
        life = true;
        paint.setColor(Color.GREEN);
        canvasEnemy.drawCircle(x, y, 20, paint);

    }


    public void drawEnemyBoss(Canvas canvasEnemy, float x, float y, int stage) {
        this.x = x;
        this.y = y;
        this.setHp(stage * 20);
        life = true;
        paint.setColor(Color.MAGENTA);
        canvasEnemy.drawCircle(x, y, 50, paint);

    }

    public void drawEnemyDie(Bitmap enemyBitmap) {
        life = false;

        this.x = 0;
        this.y = 0;
        enemyBitmap.eraseColor(Color.TRANSPARENT);


    }


}
