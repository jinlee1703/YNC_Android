package com.example.sampleintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE_MENU = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, REQ_CODE_MENU);
            }
        });
    }
    public void onActivityResult(int req, int result, Intent intent) {
        super.onActivityResult(req, result, null);

        intent.getStringExtra("name");
    }
}