package com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class fragmentMainActivity extends AppCompatActivity implements View.OnClickListener{
    Fragment fragment1,fragment2,fragment3,fragment4;

    LinearLayout layout1,layout2,layout3,layout4;

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_main);

        layout1=findViewById(R.id.button_LinearLayout1);
        layout2=findViewById(R.id.button_LinearLayout2);
        layout3=findViewById(R.id.button_LinearLayout3);
        layout4=findViewById(R.id.button_LinearLayout4);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();

        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();

        intial();

        fragmentHide();

        transaction.show(fragment1);
//        transaction.show(fragment2);
//        transaction.show(fragment3);
//        transaction.show(fragment4);

        transaction.commit();

//        layout1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                transaction=manager.beginTransaction();
//                fragmentHide();
//                transaction.show(fragment1);
//                transaction.commit();
//            }
//        });
//
//        layout2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                transaction=manager.beginTransaction();
//                fragmentHide();
//                transaction.show(fragment2);
//                transaction.commit();
//            }
//        });
//
//        layout3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                transaction=manager.beginTransaction();
//                fragmentHide();
//                transaction.show(fragment3);
//                transaction.commit();
//            }
//        });
//
//        layout4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                transaction=manager.beginTransaction();
//                fragmentHide();
//                transaction.show(fragment4);
//                transaction.commit();
//            }
//        });

        layout1.setOnClickListener(this::onClick);
        layout2.setOnClickListener(this::onClick);
        layout3.setOnClickListener(this::onClick);
        layout4.setOnClickListener(this::onClick);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void intial() {
        transaction.add(R.id.framelayout1,fragment1);
        transaction.add(R.id.framelayout1,fragment2);
        transaction.add(R.id.framelayout1,fragment3);
        transaction.add(R.id.framelayout1,fragment4);
    }

    void fragmentHide(){
        transaction.hide(fragment1);
        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);
//        transaction.commit();
    }

    @Override
    public void onClick(View a) {
        if(a.getId()==R.id.button_LinearLayout1)
            {fragmentHide();showfragment(fragment1);}
        if(a.getId()==R.id.button_LinearLayout2)
            {fragmentHide();showfragment(fragment2);}
        if(a.getId()==R.id.button_LinearLayout3)
            {fragmentHide();showfragment(fragment3);}
        if(a.getId()==R.id.button_LinearLayout4)
            {fragmentHide();showfragment(fragment4);}
        }

    private void showfragment(Fragment fragment1) {
        transaction=manager.beginTransaction();
        fragmentHide();
        transaction.show(fragment1);
        transaction.commit();
    }
}