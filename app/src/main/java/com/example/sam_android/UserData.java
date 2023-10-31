package com.example.sam_android;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;

import java.io.Serializable;

public class UserData implements Serializable,Comparable<UserData> {
    int profile = R.drawable.explanation;
    SharedPreferences preferences;
    String score;
    String userId;
    int password;





    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public void test(){

    }

    @Override
    public int compareTo(UserData o) {
        int traditionalScore = Integer.parseInt(this.score);
        int newScore = Integer.parseInt(o.score);
        if (traditionalScore < newScore){

			return 1; //이렇게 하면 내림 차순



        } else if (traditionalScore == newScore){

            return 0;

        } else {

			return -1; //이렇게 하면 오름 차순

//            return -1; //이렇게 하면 내림git l 차순

        }
    }
}
