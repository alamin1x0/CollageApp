package com.example.dpi.fullimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.example.dpi.R;
import com.github.chrisbanes.photoview.PhotoView;

public class FullImageView extends AppCompatActivity {

    private PhotoView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.share);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        setContentView(R.layout.activity_full_image_view);


//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        imageView = findViewById(R.id.imageView);

        String image = getIntent().getStringExtra("image");

        Glide.with(this).load(image).into(imageView);
    }
}