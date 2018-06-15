package com.seoho.jeaproto.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.seoho.jeaproto.adapter.MenuAdapter;
import com.seoho.jeaproto.adapter.SubjectAdapter;
import com.seoho.jeaproto.R;
import com.seoho.jeaproto.model.MenuModel;
import com.seoho.jeaproto.model.SubjectCategory;
import com.seoho.jeaproto.model.SubjectModel;

import java.util.ArrayList;

public class ApplyActivity extends AppCompatActivity {

    private static final String [] MENU = {"어학", "한자", "공무원", "기사", "기술사", "기능사", "기능장", "산업기사", "민간자격", "기타"};
    private static SubjectAdapter subjectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        RecyclerView rvMenu = (RecyclerView)findViewById(R.id.rv_menu);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ApplyActivity.this, LinearLayoutManager.VERTICAL, false);
        rvMenu.setLayoutManager(layoutManager);

        rvMenu.setNestedScrollingEnabled(true);
        rvMenu.setHasFixedSize(true);

        MenuAdapter adapter = new MenuAdapter();
        rvMenu.setAdapter(adapter);

        ArrayList<MenuModel> menuModels = new ArrayList<>();
        for (int i=0; i<MENU.length; i++){
            MenuModel menuModel = new MenuModel();
            menuModel.setPosition(i);
            menuModel.setTitle(MENU[i]);

            menuModels.add(menuModel);
        }
        adapter.setItem(menuModels);

        RecyclerView rvSubject = (RecyclerView) findViewById(R.id.rv_subject);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(ApplyActivity.this, LinearLayoutManager.VERTICAL, false);
        rvSubject.setLayoutManager(layoutManager2);

        rvSubject.setNestedScrollingEnabled(true);
        rvSubject.setHasFixedSize(true);

        subjectAdapter = new SubjectAdapter();
        rvSubject.setAdapter(subjectAdapter);

    }

    public static void subjectOrganized(int nowSelected) {

        String [] nowSubject = new String[0];

        if(nowSelected==0)
            nowSubject = SubjectCategory.LANGUAGE;
        else if(nowSelected==1)
            nowSubject = SubjectCategory.CHINESS_LETTER;
        else if(nowSelected==2)
            nowSubject = SubjectCategory.GOVERN_EMPLOYEE;
        else if(nowSelected==3)
            nowSubject = SubjectCategory.KISA;
        else if(nowSelected==4)
            nowSubject = SubjectCategory.KISULSA;
        else if(nowSelected==5)
            nowSubject = SubjectCategory.KINEUNGSA;
        else if(nowSelected==6)
            nowSubject = SubjectCategory.KINEUNGJANG;
        else if(nowSelected==7)
            nowSubject = SubjectCategory.SANUPKISA;
        else if(nowSelected==8)
            nowSubject = SubjectCategory.MINGAN;
        else if(nowSelected==9)
            nowSubject = SubjectCategory.ETC;

        ArrayList<SubjectModel>subjects = new ArrayList<>();
        for(int i=0; i<nowSubject.length;i++){
            SubjectModel subject = new SubjectModel();
            subject.setPosition(i);
            subject.setTitle(nowSubject[i]);
            subjects.add(subject);
        }
        subjectAdapter.setItem(subjects);
    }
}
