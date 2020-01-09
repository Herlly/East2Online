package com.example.east2online;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class SendActivity extends AppCompatActivity {
    private EditText name;
    private EditText message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        Button button=(Button) findViewById(R.id.button);
         name =(EditText)findViewById(R.id.edit_Name);
         message =(EditText)findViewById(R.id.edit_message);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String Name=name.getText().toString();
                 String Message=message.getText().toString();
                 Intent intent=new Intent();
                 intent.putExtra("name",Name);
                 intent.putExtra("message",Message);
                 setResult(RESULT_OK,intent);
                 finish();
             }
         });
    }
}
