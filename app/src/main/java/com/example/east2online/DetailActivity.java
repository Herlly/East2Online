package com.example.east2online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        String name =intent.getStringExtra("name");
        String message =intent.getStringExtra("message");
        TextView Name =(TextView)findViewById(R.id.text_name);
        TextView Message =(TextView)findViewById(R.id.text_message);
        Name.setText(name);
        Message.setText(message);
    }
}
