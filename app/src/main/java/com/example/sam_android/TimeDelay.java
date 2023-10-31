package com.example.sam_android;

public class TimeDelay extends Thread{


    public void timeDelay(int time){
        try {
            this.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
