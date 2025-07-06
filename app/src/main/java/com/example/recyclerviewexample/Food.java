package com.example.recyclerviewexample;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private String name;
    private int imageResId;
    private String description;
    private double price;

    public Food(String name, int imageResId, String description, double price) {
        this.name = name; //
        this.imageResId = imageResId; //
        this.description = description; //
        this.price = price; //
    }

    // Constructor đọc dữ liệu từ Parcel để tái tạo đối tượng
    protected Food(Parcel in) {
        name = in.readString(); //
        imageResId = in.readInt(); //
        description = in.readString(); //
        price = in.readDouble(); //
    }

    // Ghi dữ liệu của đối tượng vào một Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name); //
        dest.writeInt(imageResId); //
        dest.writeString(description); //
        dest.writeDouble(price); //
    }

    @Override
    public int describeContents() {
        return 0; //
    }

    // Biến CREATOR tĩnh bắt buộc để hệ thống Android có thể tạo đối tượng từ Parcel
    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in); //
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size]; //
        }
    };

    // Getters
    public String getName() { return name; } //
    public int getImageResId() { return imageResId; } //
    public String getDescription() { return description; } //
    public double getPrice() { return price; } //
}