package com.example.myapplication1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment2 extends Fragment {

    MusicService.Mybinder mybinder;
    private Context context;
    List<Map<String,Object>> list1;
    RecyclerView recyclerView;
    //List list;
    adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.activity_main_adapte, container, false);
        // Inflate the layout for this fragment

    context=getContext();
    recyclerView=view.findViewById(R.id.RecyclerView2);

    int[] pokemon={R.drawable.p1,R.drawable.p2,R.drawable.p3};
    int[] jinghua={R.drawable.jinghua1,R.drawable.jinghua2,R.drawable.p3};
    String[] price={"妙蛙种子","波波","小火龙"};
    String[] config={"妙蛙种子是一种四足的宝可梦，外表类似蟾蜍。它有着鲜红色的眼睛，白色的瞳孔和巩膜，头顶上长着一对凸起的耳朵。它的鼻子短而钝，且有一张大嘴。当它的嘴巴张开时，可以看到上颚的一对小而尖的牙齿。它的皮肤呈蓝绿色，并附有深绿色的斑纹。它每条粗腿的脚掌上都分出三趾，且末端都长有白色的小爪子。据说在它出生的时候，背上就种有一个会和它身体一同成长的神奇种子。\n" +
            "\n" +
            "妙蛙种子背上的种子里储存着营养，所以即使好几天不吃东西也可以活得好好的。在它出生后的一段时间内，它会吸收背上种子里储存着的营养成长。有时会看到它在太阳底下睡午觉的样子。在沐浴了充足的阳光后，它背上的种子就会茁壮成长。","bcd","cde","波波的外形像小型鸟类。它的脸部、腹部和翅膀末端的羽毛是奶油色的，其它部位是褐色的。它的喙和爪子是紫色的，爪子有三个趾，两根朝前，一根朝后。头顶上有三簇毛，两边的毛是奶油色的，中间的则是褐色。它的尾羽由三簇褐色羽毛组成。\n" +
            "\n" +
            "波波在草丛和森林里分布相当多，遇到敌人时会先惊叫再拍动翅膀丢洒沙砾来驱退敌人。虽然它性情温和不喜战斗，但要是随意对它出手的话，就会受到它强烈的反击。它的方向感非常好，无论离自己的巢穴多远，都能毫不迷路地飞回来。它经常藏身在草丛中，会用翅膀拍击地面激起沙尘，捕食小虫子。阿柏蛇喜食鸟宝可梦的蛋，有时会将波波或烈雀的蛋整个吞下去。橡实果以吓唬过来啄食的波波这类的宝可梦为乐。"};

    list1=new ArrayList<>();
        for(int i=0;i<pokemon.length;i++){
        Map<String,Object> map=new HashMap<>();
        map.put("name",pokemon[i]);
        map.put("jinghua",jinghua[i]);
        map.put("price",price[i]);
        map.put("config",config[i]);
        list1.add(map);
    }

    adapter=new adapter(context,list1);
    recyclerView.setAdapter(adapter);
    LinearLayoutManager manager=new LinearLayoutManager(context);
    manager.setOrientation(LinearLayoutManager.HORIZONTAL);
    recyclerView.setLayoutManager(manager);


    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mybinder=(MusicService.Mybinder) iBinder;
            mybinder.todo();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mybinder=null;
        }
    };


        Intent intent =new Intent(context, MusicService.class);
        //context.startService(intent);
        context.bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);

        //context.unbindService(serviceConnection);

        return view;
    }
}