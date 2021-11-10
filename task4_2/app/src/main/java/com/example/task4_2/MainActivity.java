package com.example.task4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText textBox;
    TextView byteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBox = findViewById(R.id.textBox);
        byteView = findViewById(R.id.byteView);

        textBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                byteView.setText(""+ s.toString().getBytes().length + " / 80 바이트");
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    public void onSendBtnClicked(View v) {
        String msg = textBox.getText().toString();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}