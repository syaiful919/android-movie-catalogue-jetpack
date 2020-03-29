package com.syaiful.moviecataloguejetpack.data.source.remote;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;
import com.syaiful.moviecataloguejetpack.utils.EspressoIdlingResource;
import com.syaiful.moviecataloguejetpack.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private JsonHelper jsonHelper;
    private Handler handler = new Handler();
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;



    private RemoteDataSource(JsonHelper jsonHelper){
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper jsonHelper){
        if(INSTANCE == null){
            INSTANCE = new RemoteDataSource(jsonHelper);
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<List<MovieResponse>>> getMovies(){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> resultMovies = new MutableLiveData<>();
        handler.postDelayed(()->{
            resultMovies.setValue(ApiResponse.success(jsonHelper.loadMovies()));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
        return resultMovies;
    }

    public LiveData<ApiResponse<List<MovieResponse>>> getTvShows(){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MovieResponse>>> resultTvShows = new MutableLiveData<>();
        handler.postDelayed(()->{
            resultTvShows.setValue(ApiResponse.success(jsonHelper.loadTvShows()));
            EspressoIdlingResource.decrement();
        },SERVICE_LATENCY_IN_MILLIS);
        return resultTvShows;
    }



}
