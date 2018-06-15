package com.seoho.jeaproto.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.seoho.jeaproto.activity.ApplyActivity;
import com.seoho.jeaproto.R;
import com.seoho.jeaproto.model.MenuModel;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    ArrayList<MenuModel> menuModels = new ArrayList<>();
    public static int isSelected;
    public ArrayList<Button> btnMenus = new ArrayList<>();

    public void setItem(ArrayList<MenuModel> menuModels){
        this.menuModels.clear();
        this.menuModels.addAll(menuModels);
        notifyDataSetChanged();

    }
    public void menuChanged(int selectedNumber){

        for (int i=0; i<btnMenus.size(); i++){
            btnMenus.get(i).setBackgroundColor(Color.argb(59,255,255,255));
            btnMenus.get(i).setTextColor(Color.argb(255,170,170,170));

            if(btnMenus.get(i).getId() == selectedNumber){
                btnMenus.get(i).setBackgroundColor(Color.argb(125, 255, 255, 255));
                btnMenus.get(i).setTextColor(Color.rgb(0, 0, 255));

              ApplyActivity.subjectOrganized(btnMenus.get(i).getId());
            }
        }


    }
    public MenuAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_menu, parent, false);
        return new MenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuViewHolder holder, int position) {
        holder.bindItem(menuModels.get(position));
    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        Button btnMenu ;

        public MenuViewHolder(View itemView) {
            super(itemView);
            btnMenu = (Button)itemView.findViewById(R.id.btn_menu);
        }
        public void bindItem(MenuModel menuModel){
            btnMenu.setText(menuModel.getTitle());
            btnMenu.setId(menuModel.getPosition());
            btnMenus.add(btnMenu);

            menuChanged(isSelected);
            ApplyActivity.subjectOrganized(isSelected);

            btnMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isSelected = btnMenu.getId();
                    menuChanged(isSelected);
                }
            });

            }
        }
    }

