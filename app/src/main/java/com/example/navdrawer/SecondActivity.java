package com.example.navdrawer;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import java.util.Objects;



public class SecondActivity extends MenuActivity {

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = findViewById(R.id.content_frame);



        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View activityView = Objects.requireNonNull(layoutInflater).inflate(R.layout.activity_second, frameLayout,false);

        frameLayout.addView(activityView);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Second");

    }
}