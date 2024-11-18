package com.example.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityA extends AppCompatActivity {

    private ActivityResultLauncher<Intent> contactPicker;

    Button button_a;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_a);

        button_a=findViewById(R.id.button5);

        textView=findViewById(R.id.textView3);

        contactPicker = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 666) {
                            // 处理结果
                            String str1=result.getData().getStringExtra("result");
                            textView.setText(str1);
//                            Intent data = result.getData();
//                            if (data != null) {
//                                Uri contactUri = data.getData();
//                                // 这里可以进一步处理contactUri，比如查询联系人详情
//                                Toast.makeText(MainActivity.this, "Contact selected: " + contactUri.toString(), Toast.LENGTH_LONG).show();
//                           }
                        }
                    }
                });

        button_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityA.this,ActivityB.class);
                intent.putExtra("name","wxwlcyjq");
                startActivity(intent);

                 // contactPicker.launch(intent);
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}