package com.seoho.jeaproto.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seoho.jeaproto.R;

public class NotifyAdapter extends RecyclerView.Adapter<NotifyAdapter.NotifyViewHolder> {

    private static final String [] notify ={
            "[당첨자 발표] 파고다 TOEFL 대비 교재 증정 이벤트",
            "[시험접수] TOEIC 시험접수 ~6/22 (금)",
            "[점수확인] 5/29 (토) HSK 시험점수 최종 확인",
            "[참가자모집] '공부의 신' 강성태 공무원 시험 세미나"};
    @NonNull
    @Override
    public NotifyAdapter.NotifyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_notify, parent,false);
        return new NotifyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifyAdapter.NotifyViewHolder holder, int position) {
        holder.bindItem(position);
    }

    @Override
    public int getItemCount() {
        return notify.length;
    }

    public class NotifyViewHolder extends RecyclerView.ViewHolder {

        TextView tvNotify;
        public NotifyViewHolder(View itemView) {
            super(itemView);
            tvNotify = itemView.findViewById(R.id.tv_notify);
        }
        public void bindItem(int position){
            tvNotify.setText(notify[position]);
        }
    }
}
