package com.example.joseph.codingtestweek3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.joseph.codingtestweek3.data.RemoteData;
import com.example.joseph.codingtestweek3.model.FlickrImages;
import com.example.joseph.codingtestweek3.model.Item;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView rvImageList;

    List<Item> imageList = new ArrayList<>();
    private ImageListAdapter imageListAdapter;
    private RecyclerView.ItemAnimator itemAnimator;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvImageList = findViewById(R.id.rvImages);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        itemAnimator = new DefaultItemAnimator();


        RemoteData.getImages()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<FlickrImages>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(@NonNull FlickrImages flickrImages) {
                        imageList = flickrImages.getItems();
//                        for (Item i: imageList){
//                            Log.d(TAG, "onNext: " + i.getTitle() + " " + i.getAuthor());
//                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                        imageListAdapter = new ImageListAdapter(imageList);
                        rvImageList.setLayoutManager(layoutManager);
                        rvImageList.setItemAnimator(itemAnimator);
                        rvImageList.setAdapter(imageListAdapter);
                    }
                });



    }



}
