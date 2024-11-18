package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity21 extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("wyblcy","Activity21:onCreate...");

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main21);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        textView=findViewById(R.id.lcy);
        Intent intent=getIntent();
        //String str=intent.getStringExtra("name");
        //int x=intent.getIntExtra("age",555);
        //textView.setText(str+"/"+x);

        Bundle bundle=intent.getExtras();
        String str2 =bundle.getString("name")+"/"+bundle.getInt("age");
        textView.setText(str2);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("wyblcy","Activity21:onRestart...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("wyblcy","Activity21:onStart...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("wyblcy","Activity21:onStop...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("wyblcy","Activity21:onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("wyblcy","Activity21:onDestroy...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("wyblcy","Activity21:onResume...");
    }
}