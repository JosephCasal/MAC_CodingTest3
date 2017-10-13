package com.example.joseph.codingtestweek3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joseph.codingtestweek3.model.Item;

public class ImageActivity extends AppCompatActivity {

    private static final String TAG = "ImageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Item item = getIntent().getParcelableExtra("item");
        String imagelink = getIntent().getStringExtra("imagelink");

        ImageView imageView = findViewById(R.id.ivFullImage);
        TextView tvInfoTitle = findViewById(R.id.tvInfoTitle);
        TextView tvInfoDate = findViewById(R.id.tvInfoDate);
        TextView tvInfoAuthor = findViewById(R.id.tvInfoAuthor);

        getSupportActionBar().setTitle(item.getTitle());
        tvInfoTitle.setText(item.getTitle());
        tvInfoAuthor.setText(item.getAuthor());
        tvInfoDate.setText(item.getDateTaken());


        Glide.with(this).load(imagelink).into(imageView);



    }
}
