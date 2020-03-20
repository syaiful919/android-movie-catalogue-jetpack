package com.syaiful.moviecataloguejetpack.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.remote.RemoteDataSource;
import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;

import java.util.ArrayList;

public class FakeMovieCatalogueRepository implements MovieCatalogueDataSource {
    private volatile static FakeMovieCatalogueRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;

    public FakeMovieCatalogueRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }


    @Override
    public LiveData<ArrayList<MovieEntity>> getMovies() {
        MutableLiveData<ArrayList<MovieEntity>> moviesResult = new MutableLiveData<>();
        remoteDataSource.getMovies(movieResponses -> {
            ArrayList<MovieEntity> movieList = new ArrayList<>();
            for (MovieResponse response : movieResponses) {
                MovieEntity movie = new MovieEntity(
                        response.getId(),
                        response.getType(),
                        response.getTitle(),
                        response.getDescription(),
                        response.getPosterPath()
                );
                movieList.add(movie);
            }
            moviesResult.postValue(movieList);
        });
        return moviesResult;
    }

    @Override
    public LiveData<ArrayList<MovieEntity>> getTvShows() {
        MutableLiveData<ArrayList<MovieEntity>> tvShowsResult = new MutableLiveData<>();
        remoteDataSource.getTvShows(tvShowResponses -> {
            ArrayList<MovieEntity> tvShowList = new ArrayList<>();
            for (MovieResponse response : tvShowResponses) {
                MovieEntity tvShow = new MovieEntity(
                        response.getId(),
                        response.getType(),
                        response.getTitle(),
                        response.getDescription(),
                        response.getPosterPath()
                );
                tvShowList.add(tvShow);
            }
            tvShowsResult.postValue(tvShowList);
        });
        return tvShowsResult;
    }

    @Override
    public LiveData<MovieEntity> getMovie(String id) {
        MutableLiveData<MovieEntity> movieResult = new MutableLiveData<>();
        remoteDataSource.getMovie(id, response -> {
            MovieEntity movie = new MovieEntity(
                    response.getId(),
                    response.getType(),
                    response.getTitle(),
                    response.getDescription(),
                    response.getPosterPath()
            );
            movieResult.postValue(movie);
        });
        return movieResult;
    }

    @Override
    public LiveData<MovieEntity> getTvShow(String id) {
        MutableLiveData<MovieEntity> tvResult = new MutableLiveData<>();
        remoteDataSource.getTvShow(id, response -> {
            MovieEntity tvShow = new MovieEntity(
                    response.getId(),
                    response.getType(),
                    response.getTitle(),
                    response.getDescription(),
                    response.getPosterPath()
            );
            tvResult.postValue(tvShow);
        });
        return tvResult;
    }
}
