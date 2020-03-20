package com.syaiful.moviecataloguejetpack.data.source.remote;

import android.os.Handler;

import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;
import com.syaiful.moviecataloguejetpack.utils.EspressoIdlingResource;
import com.syaiful.moviecataloguejetpack.utils.JsonHelper;

import java.util.ArrayList;

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

    public void getMovies(LoadMoviesCallback callback){
        EspressoIdlingResource.increment();
        handler.postDelayed(()->{
            callback.onMoviesReceived(jsonHelper.loadMovies());
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getTvShows(LoadTvShowsCallback callback){
        EspressoIdlingResource.increment();
        handler.postDelayed(()->{
            callback.onTvShowsReceived(jsonHelper.loadTvShows());
            EspressoIdlingResource.decrement();
        },SERVICE_LATENCY_IN_MILLIS);
    }

    public void getMovie(String id, LoadMovieCallback callback){
        EspressoIdlingResource.increment();
        handler.postDelayed(()->{
            callback.onMovieReceived(jsonHelper.loadMovie(id));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getTvShow(String id, LoadTvShowCallback callback){
        EspressoIdlingResource.increment();
        handler.postDelayed(()->{
            callback.onTvShowReceived(jsonHelper.loadTvShow(id));
            EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public interface LoadMoviesCallback{
        void onMoviesReceived(ArrayList<MovieResponse> movieResponses);
    }

    public interface LoadTvShowsCallback{
        void onTvShowsReceived(ArrayList<MovieResponse> tvShowResponses);
    }

    public interface LoadMovieCallback{
        void onMovieReceived(MovieResponse movie);
    }

    public interface LoadTvShowCallback{
        void onTvShowReceived(MovieResponse tvShow);
    }
}
