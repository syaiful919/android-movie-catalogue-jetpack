package com.syaiful.moviecataloguejetpack.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.room.LocalDao;

import java.util.List;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private final LocalDao mLocalDao;

    private LocalDataSource(LocalDao mLocalDao) {
        this.mLocalDao = mLocalDao;
    }

    public static LocalDataSource getInstance(LocalDao mLocalDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(mLocalDao);
        }
        return INSTANCE;
    }

    public DataSource.Factory<Integer, MovieEntity> getMovies() {
        return mLocalDao.getMovies();
    }

    public DataSource.Factory<Integer, MovieEntity> getFavMovies() {
        return mLocalDao.getFavMovies();
    }

    public LiveData<MovieEntity> getDetailMovie(String id) {
        return mLocalDao.getMovieDetail(id);
    }

    public void insertMovies(List<MovieEntity> movies) {
        mLocalDao.insertMovies(movies);
    }

    public void setFavMovie(MovieEntity movie, boolean newState) {
        movie.setFavorited(newState);
        mLocalDao.updateMovie(movie);
    }

    public DataSource.Factory<Integer, TvEntity> getTvShows() {
        return mLocalDao.getTvShows();
    }

    public DataSource.Factory<Integer, TvEntity> getFavTvShows() {
        return mLocalDao.getFavTvShow();
    }

    public LiveData<TvEntity> getDetailTvShow(String id) {
        return mLocalDao.getTvShowDetail(id);
    }

    public void insertTvShows(List<TvEntity> tvShows) {
        mLocalDao.insertTvShows(tvShows);
    }

    public void setFavTvShow(TvEntity tv, boolean newState) {
        tv.setFavorited(newState);
        mLocalDao.updateTvShow(tv);
    }
}
