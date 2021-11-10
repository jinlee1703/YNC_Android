package com.example.mission14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Person;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);


        final ProductAdapter adapter = new ProductAdapter();

        adapter.addItem(new Product(R.drawable.longcoat, "롱코트", "160,000원", "명절기획상품..."));
        adapter.addItem(new Product(R.drawable.shirts, "빈탄 와이셔츠", "80,000원", "특가상품..."));
        adapter.addItem(new Product(R.drawable.shoes, "조깅화", "220,000원", "신상품..."));
        adapter.addItem(new Product(R.drawable.sunglasses, "구O 선글라스", "100,000원", "인기상품..."));
        adapter.addItem(new Product(R.drawable.jacket, "자켓ㄴㄴㄴㄴㄴㄴㄴ", "300,000원", "판매임박상품..."));
        adapter.addItem(new Product(R.drawable.pants, "청바지", "60,000원", "품절상품..."));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnProductItemListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), item.getName() + " / " + item.price + " / " + item.contents, Toast.LENGTH_LONG).show();
            }
        });
    }
}