package com.example.mission07;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        MyClick myClick = new MyClick();

        Button btn1 = findViewById(R.id.button2);
        Button btn2 = findViewById(R.id.button3);
        Button btn3 = findViewById(R.id.button4);
        btn1.setOnClickListener(myClick);
        btn2.setOnClickListener(myClick);
        btn3.setOnClickListener(myClick);
    }

    class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button btn = (Button) view;

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra(KEY_SIMPLE_DATA, btn.getText().toString());
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
}