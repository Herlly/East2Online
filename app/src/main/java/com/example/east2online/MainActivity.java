package com.example.east2online;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<message> messagesList=new ArrayList<>();
    MessageAdapter adapter=new MessageAdapter(messagesList);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialze();
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycler_item);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL);
       dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.itemline));
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
    }
    public void initialze(){
        message person1=new message("严建勤","期末考试加油");
        message person2=new message("lbc","宝蓝你很菜啊");
        messagesList.add(person1);
        messagesList.add(person2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//菜单
        switch(item.getItemId()){
            case R.id.skip:
                StartActivity();
                break;
            case R.id.back:
                finish();
        }
        return  true;
    }
    public void StartActivity(){
        Intent intent=new Intent(MainActivity.this,SendActivity.class);
        startActivityForResult(intent,1);
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String Name=data.getStringExtra("name");
                    String Message = data.getStringExtra("message");
                    message x1=new message(Name,Message);
                    messagesList.add(x1);
                    adapter.notifyDataSetChanged();
                }
        }
    }

}
