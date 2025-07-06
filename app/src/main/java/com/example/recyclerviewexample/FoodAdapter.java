package com.example.recyclerviewexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> foodList;
    private Context context;

    public FoodAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodNameTextView.setText(food.getName());
        holder.foodImageView.setImageResource(food.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Food clickedFood = foodList.get(holder.getAdapterPosition()); // [cite: 77]

            // Tạo Intent để chuyển sang DetailActivity
            Intent intent = new Intent(v.getContext(), DetailActivity.class); // [cite: 78]

            // Đóng gói dữ liệu vào Intent
            intent.putExtra("foodName", clickedFood.getName()); // [cite: 78]
            intent.putExtra("foodImage", clickedFood.getImageResId()); // [cite: 79]
            intent.putExtra("foodDescription", clickedFood.getDescription()); // [cite: 80]
            intent.putExtra("foodPrice", clickedFood.getPrice()); // [cite: 81]

            // Bắt đầu Activity mới
            v.getContext().startActivity(intent); // [cite: 82]
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void removeItem(int position) {
        foodList.remove(position);
        notifyItemRemoved(position);
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImageView;
        TextView foodNameTextView;

        public FoodViewHolder(View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            foodNameTextView = itemView.findViewById(R.id.foodNameTextView);
        }
    }
}