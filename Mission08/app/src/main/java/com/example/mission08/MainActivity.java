package com.example.mission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText id;
    EditText pw;
    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        id = findViewById(R.id.text1);
        pw = findViewById(R.id.text2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.getText().toString().equals("") || pw.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "아이디와 비밀번호 모두 입력해주세요!", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    MemberData data = new MemberData(id.getText().toString(), pw.getText().toString());
                    intent.putExtra(KEY_SIMPLE_DATA, data);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                }
            }
        });
    }
}