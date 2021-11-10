package com.example.task4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrView1, scrView2;
    ImageView img1, img2;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrView1 = findViewById(R.id.scrView1);
        scrView2 = findViewById(R.id.scrView2);
        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        scrView1.setHorizontalScrollBarEnabled(true);
        scrView2.setHorizontalScrollBarEnabled(true);
    }

    public void btn_Click(View v) {
        ImageView imgView;

        if (v.getId() == R.id.btn1)
            imgView = img1;
        else
            imgView = img2;

        img1.setImageBitmap(null);
        img2.setImageBitmap(null);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
        int bitWidth = bitmap.getIntrinsicWidth();
        int bitHeight = bitmap.getIntrinsicHeight();

        imgView.setImageDrawable(bitmap);
        imgView.getLayoutParams().width = bitWidth;
        imgView.getLayoutParams().height = bitHeight;
    }
}