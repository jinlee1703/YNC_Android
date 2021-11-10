package com.example.mission08;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU1 = 102;
    public static final int REQUEST_CODE_MENU2 = 103;
    public static final int REQUEST_CODE_MENU3 = 104;
    public static final String KEY_SIMPLE_DATA = "data";
    MemberData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            data = bundle.getParcelable(KEY_SIMPLE_DATA);
        }

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

            if (btn.getText().toString().equals("고객 관리")) {
                Intent intent = new Intent(getApplicationContext(), ClientActivity.class);
                intent.putExtra(KEY_SIMPLE_DATA, data);
                startActivityForResult(intent, REQUEST_CODE_MENU1);
            } else if (btn.getText().toString().equals("매출 관리")) {
                Intent intent = new Intent(getApplicationContext(), ClientActivity.class);
                intent.putExtra(KEY_SIMPLE_DATA, data);
                startActivityForResult(intent, REQUEST_CODE_MENU2);
            } else if (btn.getText().toString().equals("상품 관리")) {
                Intent intent = new Intent(getApplicationContext(), ClientActivity.class);
                intent.putExtra(KEY_SIMPLE_DATA, data);
                startActivityForResult(intent, REQUEST_CODE_MENU3);
            }
        }
    }
}