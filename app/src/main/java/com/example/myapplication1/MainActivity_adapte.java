package com.example.myapplication1;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity_adapte extends AppCompatActivity {

    List<Map<String,Object>> list1;

    Context context;
    RecyclerView recyclerView;
    //List list;
    adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_adapte);

        recyclerView=findViewById(R.id.RecyclerView2);
        context=this;
        int[] phonename={R.drawable.p1,R.drawable.p2,R.drawable.p3};
        String[] price={"妙蛙种子","皮卡丘","小火龙"};
        String[] config={"abc","bcd","cde"};

        list1=new ArrayList<>();
        for(int i=0;i<phonename.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("name",phonename[i]);
            map.put("price",price[i]);
            map.put("config",config[i]);

            list1.add(map);
        }

//        list=new ArrayList<String>();
//        for(int i=0;i<9;i++){
//            list.add("这是第"+i+"个例子!");
//        }
        adapter=new adapter(context,list1);

        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}