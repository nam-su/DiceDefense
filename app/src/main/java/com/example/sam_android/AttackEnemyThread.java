package com.example.sam_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;

public class AttackEnemyThread extends Thread {

    String TAG = "AttackEnemyThread";
    ImageView iv_effectDice;

    ArrayList<LinearLayout> enemyHpBarLayouts = new ArrayList<>();
    ArrayList<ProgressBar> enemyHpBars = new ArrayList<>();
    Context context;
    Handler handler;
    ArrayList<Enemy> enemies;
    ArrayList<Canvas> enemyCanvases;
    ArrayList<Bitmap> enemyBitmaps;
    ArrayList<Canvas> canvasEffectDices;
    ArrayList<ImageView> iv_effectDices = new ArrayList<>();
    ArrayList<Bitmap> effectBitmapDices = new ArrayList<>();
    TextView tv_score;
    int score;
    Dice dice;
    Canvas canvasEffectDice;
    Paint paint = new Paint();
    MediaPlayer mediaPlayer;


    AttackEnemyThread(TextView tv_score, int score, ArrayList<ProgressBar> enemyHpBars, MediaPlayer mediaPlayer, Context context, ArrayList<LinearLayout> enemyHpBarLayouts, ArrayList<ImageView> iv_effectDices, Handler handler, ArrayList<Enemy> enemies, ArrayList<Canvas> enemyCanvases, ArrayList<Bitmap> enemyBitmaps, Dice dice, ArrayList<Canvas> canvasEffectDices, ArrayList<Bitmap> effectBitmapDices) {
        this.iv_effectDices = iv_effectDices;
        this.handler = handler;
        this.enemies = enemies;
        this.enemyCanvases = enemyCanvases;
        this.enemyBitmaps = enemyBitmaps;
        this.dice = dice;
        this.canvasEffectDices = canvasEffectDices;
        this.effectBitmapDices = effectBitmapDices;
        this.enemyHpBarLayouts = enemyHpBarLayouts;
        this.mediaPlayer = mediaPlayer;
        this.enemyHpBars = enemyHpBars;
        this.tv_score = tv_score;
        this.score = score;
    }

    @Override
    public void run() {
        super.run();

        try {
            if (dice.choiceType.equals("불")) {   // 불 주사위 일 때 공격 스레드
                Log.d(TAG, "불 주사위 공격 실행 다이스 넘버 : " + dice.name);


                if (dice.choiceNum == 0) {  // 주사위 눈금 1일 때

                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(800);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });
                            mediaPlayer.start();
                            try {
                                sleep(200);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            if (dice.x != 0) {

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        paint.setColor(Color.RED);
                                        canvasEffectDices.get(0).drawCircle(dice.x, dice.y, 30, paint);
                                    }
                                });

                            }
                            sleep(50);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }

                                }
                            });

                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        
                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);


                                    }
                                });


                                break;
                            }

                        }  //while문 끝

                    } // for 문 끝남


                } else if (dice.choiceNum == 1) {//주사위 눈금 2일때
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(750);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(200);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if (dice.x != 0) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        paint.setColor(Color.RED);

                                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 30, paint);
                                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 30, paint);
                                    }
                                });
                            }
                            sleep(50);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });
                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        
                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);


                                    }
                                });

                                break;
                            }

                        }  //while문 끝


                    } // for 문 끝남

                } else if (dice.choiceNum == 2) {  // 주사위 눈금 3 일때
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(750);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(200);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            if(dice.x != 0){
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    paint.setColor(Color.RED);
                                    canvasEffectDices.get(2).drawCircle(dice.x, dice.y, 30, paint);
                                }
                            });}

                            sleep(50);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });

                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        
                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);


                                    }
                                });
                                break;
                            }

                        }  //while문 끝


                    } // for 문 끝남


                } else if (dice.choiceNum == 3) { // 주사위 눈금 4 일때
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(750);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(200);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            if(dice.x != 0 ) {

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        paint.setColor(Color.RED);


                                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 30, paint);
                                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 30, paint);
                                        canvasEffectDices.get(2).drawCircle(dice.x - 50, dice.y + 50, 30, paint);
                                        canvasEffectDices.get(3).drawCircle(dice.x + 50, dice.y - 50, 30, paint);
                                    }
                                });
                            }
                            sleep(50);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });
                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        

                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);


                                    }
                                });
                                break;
                            }

                        }  //while문 끝


                    } // for 문 끝남

                } else if (dice.choiceNum == 4) { // 주사위 눈금 5일 때
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(750);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(200);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            if(dice.x != 0){

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    paint.setColor(Color.RED);
                                    canvasEffectDices.get(4).drawCircle(dice.x, dice.y, 30, paint);
                                }
                            });}

                            sleep(50);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });
                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        

                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);


                                    }
                                });
                                break;
                            }

                        }  //while문 끝

                    } // for 문 끝남

                } else if (dice.choiceNum == 5) { // 주사위 눈금 6일 때
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(750);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(200);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            if(dice.x != 0){

                            if (dice.x != 0) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        paint.setColor(Color.RED);


                                        canvasEffectDices.get(0).drawCircle(dice.x - 50, dice.y - 50, 30, paint);
                                        canvasEffectDices.get(1).drawCircle(dice.x + 50, dice.y + 50, 30, paint);
                                        canvasEffectDices.get(2).drawCircle(dice.x - 50, dice.y + 50, 30, paint);
                                        canvasEffectDices.get(3).drawCircle(dice.x + 50, dice.y - 50, 30, paint);
                                        canvasEffectDices.get(4).drawCircle(dice.x - 50 , dice.y , 30, paint);
                                        canvasEffectDices.get(5).drawCircle(dice.x + 50 , dice.y , 30, paint);


                                    }
                                });
                            }}
                            sleep(50);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });

                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        

                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);


                                    }
                                });
                                break;
                            }

                        }  //while문 끝

                    } // for 문 끝남

                }
            } else if (dice.choiceType.equals("물")) {   // 물 주사위 일때 공격 스레드
                Log.d(TAG, "물 주사위 공격 실행 다이스 넘버 : " + dice.name);
                if (dice.choiceNum == 0) {   // 눈금 1 주사위

                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(150);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });
                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);

                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        

                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);

                                    }
                                });
                                break;
                            }

                        }  //while문 끝

                    } // for 문 끝남


                } else if (dice.choiceNum == 1) { // 눈금 2 주사위
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(500);
                            } catch (InterruptedException e) {

                                throw new RuntimeException(e);

                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });


                            mediaPlayer.start();

                            try {
                                sleep(150);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }


                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });
                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);

                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        

                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);

                                    }
                                });
                                break;
                            }

                        }  //while문 끝


                    } // for 문 끝남

                } else if (dice.choiceNum == 2) { // 눈금 3 주사위
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(150);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });
                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);

                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        

                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);

                                    }
                                });
                                break;
                            }

                        }  //while문 끝


                    } // for 문 끝남


                } else if (dice.choiceNum == 3) { // 눈금 4 주사위
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(150);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }


                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });
                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);

                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        

                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);

                                    }
                                });
                                break;
                            }

                        }  //while문 끝


                    } // for 문 끝남

                } else if (dice.choiceNum == 4) { // 눈금 5 주사위
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(150);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }


                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });
                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);

                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        

                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);

                                    }
                                });
                                break;
                            }

                        }  //while문 끝

                    } // for 문 끝남

                } else if (dice.choiceNum == 5) { // 눈금 6 죽사위
                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);

                                }
                            });

                            mediaPlayer.start();

                            try {
                                sleep(150);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }


                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {
                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);

                                    }
                                }
                            });
                            enemies.get(j).setHp(enemies.get(j).getHp() - dice.attack);

                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 while문 탈출 후 for문 으로 들어감.
                                score += 100;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        
                                        

                                        enemies.get(j).drawEnemyDie(enemyBitmaps.get(j));
                                        enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                        enemyHpBars.get(j).setVisibility(View.GONE);

                                    }
                                });
                                break;
                            }

                        }  //while문 끝

                    } // for 문 끝남

                }
            } else if (dice.choiceType.equals("전기")) {   // 전기 주사위 일때 공격 스레드
                Log.d(TAG, "전기 주사위 공격 실행 다이스 넘버 : " + dice.name);
                int sum = 0;
                if (dice.choiceNum == 0) { // 눈금 1 주사위

                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(900);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {

                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);
                                }
                            });


                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {

                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);


                                    }
                                }
                            });


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 여기로 들어옴


                                if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() > 0) { // 보스가 살아 있는 경우
                                    Log.d("전기", "보스 제외 다른 적들 죽었을경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = j; k < enemies.size() - 1; k++) {

                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });
                                    break;
                                } else if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() <= 0) { //
                                    Log.d("전기", "한놈을 죽임과 동시에 마지막놈이 죽었을 경우");

                                    Log.d("전기", "보스 스테이지 아닐때 전부 죽인경우");

                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = j; k < enemies.size(); k++) {

                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });
                                    break;
                                } else {
                                    score += 100;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {

                                            
                                            

                                            enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                            enemyHpBars.get(j).setVisibility(View.GONE);
                                            enemyBitmaps.get(j).eraseColor(Color.TRANSPARENT);
                                        }
                                    });

                                    break;
                                }


                            }
                        } // while문 끝

                    } // for문 긑
                } else if (dice.choiceNum == 1) { // 눈금 2 주사위

                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(900);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {

                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);
                                }
                            });



                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {

                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);


                                    }
                                }
                            });


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 여기로 들어옴
                                Log.d("전기", "여기로 몇번 들어오는가?");

                                if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() > 0) { // 보스가 살아 있는 경우
                                    Log.d("전기", "보스 제외 다른 적들 죽었을경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size() - 1; k++) {

                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() <= 0) { //
                                    Log.d("전기", "한놈을 죽임과 동시에 마지막놈이 죽었을 경우");

                                    Log.d("전기", "보스 스테이지 아닐때 전부 죽인경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size(); k++) {
                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else {
                                    score += 100;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {

                                            
                                            
                                            enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                            enemyHpBars.get(j).setVisibility(View.GONE);
                                            enemyBitmaps.get(j).eraseColor(Color.TRANSPARENT);
                                        }
                                    });


                                }


                            }
                        } // while문 끝

                    } // for문 긑

                } else if (dice.choiceNum == 2) { // 눈금 3 주사위

                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(900);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {

                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);
                                }
                            });




                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {

                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);


                                    }
                                }
                            });


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 여기로 들어옴
                                Log.d("전기", "여기로 몇번 들어오는가?");

                                if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() > 0) { // 보스가 살아 있는 경우
                                    Log.d("전기", "보스 제외 다른 적들 죽었을경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size() - 1; k++) {

                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() <= 0) { //
                                    Log.d("전기", "한놈을 죽임과 동시에 마지막놈이 죽었을 경우");

                                    Log.d("전기", "보스 스테이지 아닐때 전부 죽인경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size(); k++) {
                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else {
                                    score += 100;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {

                                            
                                            
                                            enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                            enemyHpBars.get(j).setVisibility(View.GONE);
                                            enemyBitmaps.get(j).eraseColor(Color.TRANSPARENT);
                                        }
                                    });


                                }


                            }
                        } // while문 끝

                    } // for문 긑


                } else if (dice.choiceNum == 3) { // 눈금 4 주사위

                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(900);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {

                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);
                                }
                            });




                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {

                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);


                                    }
                                }
                            });


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 여기로 들어옴
                                Log.d("전기", "여기로 몇번 들어오는가?");

                                if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() > 0) { // 보스가 살아 있는 경우
                                    Log.d("전기", "보스 제외 다른 적들 죽었을경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size() - 1; k++) {

                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() <= 0) { //
                                    Log.d("전기", "한놈을 죽임과 동시에 마지막놈이 죽었을 경우");

                                    Log.d("전기", "보스 스테이지 아닐때 전부 죽인경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size(); k++) {
                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else {
                                    score += 100;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {

                                            
                                            
                                            enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                            enemyHpBars.get(j).setVisibility(View.GONE);
                                            enemyBitmaps.get(j).eraseColor(Color.TRANSPARENT);
                                        }
                                    });


                                }


                            }
                        } // while문 끝

                    } // for문 긑

                } else if (dice.choiceNum == 4) { // 눈금 5 주사위


                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(900);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {

                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);
                                }
                            });




                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {

                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);


                                    }
                                }
                            });


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 여기로 들어옴
                                Log.d("전기", "여기로 몇번 들어오는가?");

                                if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() > 0) { // 보스가 살아 있는 경우
                                    Log.d("전기", "보스 제외 다른 적들 죽었을경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size() - 1; k++) {

                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() <= 0) { //
                                    Log.d("전기", "한놈을 죽임과 동시에 마지막놈이 죽었을 경우");

                                    Log.d("전기", "보스 스테이지 아닐때 전부 죽인경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size(); k++) {
                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else {
                                    score += 100;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {

                                            
                                            
                                            enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                            enemyHpBars.get(j).setVisibility(View.GONE);
                                            enemyBitmaps.get(j).eraseColor(Color.TRANSPARENT);
                                        }
                                    });


                                }


                            }
                        } // while문 끝

                    } // for문 긑
                } else if (dice.choiceNum == 5) { // 눈금 6 주사위

                    for (int i = 0; i < enemies.size(); i++) {

                        int j = i;

                        while (enemies.get(j).getHp() > 0) {

                            try {
                                sleep(900);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {

                                @Override
                                public void run() {

                                    dice.drawDiceAttack(mediaPlayer,iv_effectDices, enemyBitmaps.get(j), canvasEffectDices, dice, enemies.get(j), enemies, j);
                                }
                            });




                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    for (int k = 0; k < dice.choiceNum + 1; k++) {

                                        effectBitmapDices.get(k).eraseColor(Color.TRANSPARENT);


                                    }
                                }
                            });


                            if (enemies.get(j).getHp() <= 0) { // j번째 적이 죽었을때 여기로 들어옴
                                Log.d("전기", "여기로 몇번 들어오는가?");

                                if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() > 0) { // 보스가 살아 있는 경우
                                    Log.d("전기", "보스 제외 다른 적들 죽었을경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size() - 1; k++) {

                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else if (enemies.get(9).getHp() <= 0 && enemies.get(10).getHp() <= 0) { //
                                    Log.d("전기", "한놈을 죽임과 동시에 마지막놈이 죽었을 경우");

                                    Log.d("전기", "보스 스테이지 아닐때 전부 죽인경우");
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int k = 0; k < enemies.size(); k++) {
                                                enemies.get(k).drawEnemyDie(enemyBitmaps.get(k));
                                                enemyHpBarLayouts.get(k).setVisibility(View.GONE);
                                                enemyHpBars.get(k).setVisibility(View.GONE);
                                            }
                                        }
                                    });

                                } else {
                                    score += 100;

                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            
                                            
                                            enemyHpBarLayouts.get(j).setVisibility(View.GONE);
                                            enemyHpBars.get(j).setVisibility(View.GONE);
                                            enemyBitmaps.get(j).eraseColor(Color.TRANSPARENT);
                                        }
                                    });


                                }


                            }
                        } // while문 끝

                    } // for문 긑
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "AttackEnemyThread interrupt 됐을때");
            for (int i = 0; i < effectBitmapDices.size(); i++) {

                effectBitmapDices.get(i).eraseColor(Color.TRANSPARENT);


            }
            mediaPlayer.stop();

        }

    }

}