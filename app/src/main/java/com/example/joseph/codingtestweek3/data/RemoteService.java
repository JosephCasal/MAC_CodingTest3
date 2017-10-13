package com.example.joseph.codingtestweek3.data;

import com.example.joseph.codingtestweek3.model.FlickrImages;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by joseph on 10/13/17.
 */

public interface RemoteService {

    @GET("services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1")
    Observable<FlickrImages> getImages();

}
