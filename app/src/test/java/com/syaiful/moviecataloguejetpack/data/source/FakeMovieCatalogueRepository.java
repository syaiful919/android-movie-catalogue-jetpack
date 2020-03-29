package com.syaiful.moviecataloguejetpack.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.syaiful.moviecataloguejetpack.data.source.local.LocalDataSource;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.data.source.remote.ApiResponse;
import com.syaiful.moviecataloguejetpack.data.source.remote.RemoteDataSource;
import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;
import com.syaiful.moviecataloguejetpack.utils.AppExecutors;
import com.syaiful.moviecataloguejetpack.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class FakeMovieCatalogueRepository implements MovieCatalogueDataSource {
    private volatile static MovieCatalogueRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    public FakeMovieCatalogueRepository(@NonNull RemoteDataSource remoteDataSource, @NonNull LocalDataSource localDataSource, AppExecutors appExecutors){
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }


    @Override
    public LiveData<Resource<List<MovieEntity>>> getMovies(){
        return new NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors){

            @Override
            protected LiveData<List<MovieEntity>> loadFromDB() {
                return localDataSource.getMovies();
            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteDataSource.getMovies();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                List<MovieEntity> movieList = new ArrayList<>();
                for(MovieResponse response : data){
                    MovieEntity movie = new MovieEntity(
                            response.getId(),
                            response.getTitle(),
                            response.getDescription(),
                            response.getPosterPath(),
                            false
                    );
                    movieList.add(movie);
                }
                localDataSource.insertMovies(movieList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvEntity>>> getTvShows(){
        return new NetworkBoundResource<List<TvEntity>, List<MovieResponse>>(appExecutors){

            @Override
            protected LiveData<List<TvEntity>> loadFromDB() {
                return localDataSource.getTvShows();
            }

            @Override
            protected Boolean shouldFetch(List<TvEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteDataSource.getTvShows();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                List<TvEntity> tvShowList = new ArrayList<>();
                for(MovieResponse response : data){
                    TvEntity tvShow = new TvEntity(
                            response.getId(),
                            response.getTitle(),
                            response.getDescription(),
                            response.getPosterPath(),
                            false
                    );
                    tvShowList.add(tvShow);
                }
                localDataSource.insertTvShows(tvShowList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<List<MovieEntity>> getFavMovies() {
        return localDataSource.getFavMovies();
    }

    @Override
    public LiveData<List<TvEntity>> getFavTvShows() {
        return localDataSource.getFavTvShows();
    }

    @Override
    public void setFavMovie(MovieEntity movie, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setFavMovie(movie, state));
    }

    @Override
    public void setFavTvShow(TvEntity tv, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setFavTvShow(tv, state));
    }

    @Override
    public LiveData<MovieEntity> getMovie(String id) {
        return localDataSource.getDetailMovie(id);
    }

    @Override
    public LiveData<TvEntity> getTvShow(String id) {
        return localDataSource.getDetailTvShow(id);
    }
}
