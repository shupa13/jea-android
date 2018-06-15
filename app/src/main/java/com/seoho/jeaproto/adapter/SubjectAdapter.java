package com.seoho.jeaproto.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.seoho.jeaproto.R;
import com.seoho.jeaproto.model.SubjectModel;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    ArrayList<SubjectModel>subjects = new ArrayList<>();

    public void setItem(ArrayList<SubjectModel> subjects){
        this.subjects.clear();
        this.subjects.addAll(subjects);
        notifyDataSetChanged();
    }
    public SubjectAdapter.SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_subject, parent, false);
        return new SubjectViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectAdapter.SubjectViewHolder holder, int position) {
        holder.bindItem(subjects.get(position));

    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder {

        Button btnSubject;

        public SubjectViewHolder(View itemView) {
            super(itemView);
            btnSubject = (Button)itemView.findViewById(R.id.btn_subject);
        }
        public void bindItem(SubjectModel subject){
            btnSubject.setText(subject.getTitle());
        }
    }
}
