package com.example.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private ActivityResultLauncher<Intent> contactPicker;

    Button button21;
    Button button22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Log.d("wyblcy","Activity2:onCreate...");

        button21=findViewById(R.id.button2);
        button22=findViewById(R.id.button4);

//        contactPicker = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//                        if (result.getResultCode() == Activity.RESULT_OK) {
//                            // 处理结果
//                            Intent data = result.getData();
//                            if (data != null) {
//                                Uri contactUri = data.getData();
//                                // 这里可以进一步处理contactUri，比如查询联系人详情
//                                Toast.makeText(MainActivity.this, "Contact selected: " + contactUri.toString(), Toast.LENGTH_LONG).show();
//                            }
//                        }
//                    }
//                });

        Intent intent=new Intent(this,MainActivity21.class);

//        intent.putExtra("name","wybxs");
//        intent.putExtra("age",20);

        Bundle bundle=new Bundle();
        bundle.putString("name","wybxs");
        bundle.putInt("age",20);
        intent.putExtras(bundle);

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

//        ActivityResultLauncher launcher=registerForActivityResult();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("wyblcy","Activity2:onRestart...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("wyblcy","Activity2:onStart...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("wyblcy","Activity2:onStop...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("wyblcy","Activity2:onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("wyblcy","Activity2:onDestroy...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("wyblcy","Activity2:onResume...");
    }
}