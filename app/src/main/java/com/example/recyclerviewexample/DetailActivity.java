package com.example.recyclerviewexample;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImageView = findViewById(R.id.detailImageView);
        TextView detailTextView = findViewById(R.id.detailTextView);
        Button orderButton = findViewById(R.id.orderButton);

        // Nhận đối tượng Food từ Intent
        Food food = getIntent().getParcelableExtra("foodItem");

        if (food != null) {
            // Hiển thị thông tin món ăn
            detailImageView.setImageResource(food.getImageResId());
            detailTextView.setText("Tên: " + food.getName() +
                    "\nMô tả: " + food.getDescription() +
                    "\nGiá: " + food.getPrice() + " VND");

            // Xử lý sự kiện nhấn nút "Gọi món"
            orderButton.setOnClickListener(v -> {
                Toast.makeText(this, "Bạn đã gọi món: " + food.getName(), Toast.LENGTH_SHORT).show();
            });
        }
    }
}