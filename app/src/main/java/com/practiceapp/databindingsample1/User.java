package com.practiceapp.databindingsample1;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class User extends BaseObservable {
    private String name;
    private int age;
    private boolean active;
    private String imageURL;

    public User(String name, int age, boolean active, String imageURL) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.imageURL = imageURL;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        notifyPropertyChanged(BR.active);
    }

    @Bindable
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
        notifyPropertyChanged(BR.imageURL);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public void handleClick(){
        Log.d("User","Status changed");
    }

    @BindingAdapter("android:anyname")
    public static void loadImage(ImageView imageView,String imageURL){
        Glide.with(imageView)
                .load(imageURL)
                .into(imageView);
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        if (view.getText() != null
                && (!view.getText().toString().isEmpty())
                && Integer.parseInt(view.getText().toString()) != value) {
            view.setText(Integer.toString(value));
        }
    }
}
