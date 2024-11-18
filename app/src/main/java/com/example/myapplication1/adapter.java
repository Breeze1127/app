package com.example.myapplication1;

//import androidx.activity.result.ActivityResult;
//import androidx.activity.result.ActivityResultCallback;
// import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder>{

    //List list;
    private Context context;
    private View inflater;
    private List<Map<String,Object>> list1;
    private ActivityResultLauncher<Intent> contactPicker;
    public  adapter(Context context,List<Map<String,Object>> list1){
        this.context=context;
        this.list1=list1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       // Context context=parent.getContext();
        inflater= LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
//        inflater= LayoutInflater.from(this).inflate();
        MyViewHolder holder=new MyViewHolder(inflater);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.textView.setText(list1.get(position).toString());
        Map<String,Object> currentItem=list1.get(position);
        holder.imageView.setImageResource((Integer)currentItem.get("name"));
        holder.imageView2.setImageResource((Integer)currentItem.get("jinghua"));
        //holder.imageView.setImageResource((int)list1.get(position).get("name"));



        String str1=list1.get(position).get("price").toString();
        String str2=list1.get(position).get("config").toString();
       // holder.textView1.setText(list1.get(position).get("name").toString()/*.toString()*/);
        holder.textView2.setText(str1);
        holder.textView3.setText(str2);

//        contactPicker = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//                        if (result.getResultCode() == 666) {
//                            // 处理结果
//                            String str1=result.getData().getStringExtra("result");
//                            textView.setText(str1);
////                            Intent data = result.getData();
////                            if (data != null) {
////                                Uri contactUri = data.getData();
////                                // 这里可以进一步处理contactUri，比如查询联系人详情
////                                Toast.makeText(MainActivity.this, "Contact selected: " + contactUri.toString(), Toast.LENGTH_LONG).show();
////                           }
//                        }
//                    }
//                });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Activity_contact_detail.class);
                intent.putExtra("price",str1);
                intent.putExtra("config",str2);
                context.startActivity(intent);
                //contactPicker.launch(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView,imageView2;
        TextView textView1,textView2,textView3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            imageView2=itemView.findViewById(R.id.imageView2);
            textView2=itemView.findViewById(R.id.rv_textView2);
            textView3=itemView.findViewById(R.id.rv_textView3);
        }
    }

}
