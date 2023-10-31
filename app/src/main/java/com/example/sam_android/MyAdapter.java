package com.example.sam_android;


import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String TAG = "MyAdapter";
//    Button btn_modify;
//    Button btn_remove;
    public ArrayList<UserData> listData = new ArrayList<>();
    SharedPreferences preferences;
    String resultPASSWORD;
    String resultSCORE;
    String resultID;


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        int p = position;
        holder.onBind(listData.get(p));

//        btn_remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "삭제 버튼 눌렀음");
//                preferences = v.getContext().getSharedPreferences("userData", MODE_PRIVATE);
//                SharedPreferences.Editor editor = preferences.edit();
//                resultSCORE = preferences.getString("유저 점수", "");
//                resultID = preferences.getString("유저 아이디", "");
//                resultPASSWORD = preferences.getString("유저 비밀번호", "");
//
//                String[] idS = resultID.split(",");
//                String[] scoreS = resultSCORE.split(",");
//                String[] passwordS = resultPASSWORD.split(",");
//
//                resultSCORE = "";
//                resultID = "";
//                resultPASSWORD = "";
//
//                idS[p] = "";
//                passwordS[p] = "";
//                scoreS[p] = "";
//                for (int i = 0; i < idS.length; i++) {
//                    if (i == 0) {
//                        resultID += idS[i];
//                        resultPASSWORD += passwordS[i];
//                        resultSCORE += scoreS[i];
//                    } else if (idS[i].equals("")) {
//
//
//                    } else {
//                        resultID += "," + idS[i];
//                        resultPASSWORD += "," + passwordS[i];
//                        resultSCORE += "," + scoreS[i];
//                    }
//                }
//
//
//                editor.putString("유저 아이디", resultID);
//                editor.putString("유저 비밀번호", resultPASSWORD);
//                editor.putString("유저 점수", resultSCORE);
//                editor.commit();
//
//                listData.remove(listData.get(p)); // 찾다보니 발견함
//
//                notifyDataSetChanged();
//            }
//        });
//        btn_modify.setOnClickListener(new View.OnClickListener() { // 수정버튼 눌렀을때
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "수정 버튼 눌렀음");
//                Intent intent = new Intent(v.getContext(), Activity_Rank_Modify_Data.class);
//                intent.putExtra("Array", listData);
//                intent.putExtra("positionNum", p);
//
//
//                v.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    void addItem(UserData userData) {

        listData.add(userData);

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_userId;
        TextView tv_score;
        ImageView iv_profile;
        String TAG = "MyAdapter";

        MyViewHolder(View itemView) {
            super(itemView);



            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_userId = itemView.findViewById(R.id.tv_userId);
            tv_score = itemView.findViewById(R.id.tv_score);

//            btn_modify = itemView.findViewById(R.id.btn_modify);
//            btn_remove = itemView.findViewById(R.id.btn_remove);


        }

        void onBind(UserData userData) {


            iv_profile.setImageResource(userData.getProfile());
            tv_score.setText(userData.getScore());
            tv_userId.setText(userData.getUserId());

        }

    }
}
