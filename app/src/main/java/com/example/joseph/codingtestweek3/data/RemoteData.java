package com.example.joseph.codingtestweek3.data;

import com.example.joseph.codingtestweek3.model.FlickrImages;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joseph on 10/13/17.
 */

public class RemoteData {

    public static final String BASE_URL = "http://api.flickr.com/";

    public static Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;

    }

    public static Observable<FlickrImages> getImages(){
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getImages();
    }

}
