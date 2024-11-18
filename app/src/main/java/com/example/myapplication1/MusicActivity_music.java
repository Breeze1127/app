package com.example.myapplication1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
//import android.view.View;
//import android.media.MediaParser;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
public class MusicActivity_music extends AppCompatActivity {
    void midToast(String str, int showTime) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, null);

        TextView text = layout.findViewById(R.id.toast_message);
        text.setText(str);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(showTime);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 100); // 设置在底部
        toast.setView(layout);
        toast.show();
    }
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_music);

        button1 = findViewById(R.id.button_music1);
        button2 = findViewById(R.id.button_music2);

        Intent intent = new Intent(MusicActivity_music.this, MusicService.class);

        button1.setOnClickListener(view -> {
            startService(intent); // 启动服务
            midToast("Music Service Started", Toast.LENGTH_SHORT); // 弹出 Toast
        });

        button2.setOnClickListener(view -> {
            stopService(intent); // 停止服务
            midToast("Music Service Stopped", Toast.LENGTH_SHORT); // 弹出 Toast
        });
    }
}