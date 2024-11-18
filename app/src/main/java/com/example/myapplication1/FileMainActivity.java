package com.example.myapplication1;

//import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;

public class FileMainActivity extends AppCompatActivity {

    TextView textView1;
    Button button1,button2,button3,button4;
    SharedPreferences sp;
    FileOutputStream outputStream;
    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_file_main);

        button1=findViewById(R.id.button_file_1);
        button2=findViewById(R.id.button_flie_2);
        button3=findViewById(R.id.button_flie_3);
        button4=findViewById(R.id.button_flie_4);

        textView1=findViewById(R.id.textView_file_1);

        sp=getSharedPreferences("wxw", Context.MODE_PRIVATE);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sp=getSharedPreferences("wxw", Context.MODE_PRIVATE);
                //SharedPreferences.Editor editor=sp.edit();
                boolean commit = sp.edit()
                        .putString("name", "wxwbbb")
                        .putString("key", "123456")
                        .commit();
                Log.d("wxw","Data saved:"+sp.getString("name","content"));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(sp.getString("name","123"));
            }
        });

        File file=new File("data/data/com.example.myapplication1/wxw1.txt");

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    outputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    outputStream.write("hi".getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}