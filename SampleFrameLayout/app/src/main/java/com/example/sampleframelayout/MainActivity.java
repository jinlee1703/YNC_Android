package com.example.sampleframelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image1;
    ImageView image2;

    int imageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);
    }

    public void myClick(View v) {
        if (imageIndex == 0) {
            image1.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.VISIBLE);
            imageIndex = 1;
        } else {
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.INVISIBLE);
            imageIndex = 0;
        }
    }
}