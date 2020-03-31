package com.syaiful.moviecataloguejetpack.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;

import java.util.List;


@Dao
public interface LocalDao {

    //movies

    @Query("SELECT * FROM movie_entities")
    DataSource.Factory<Integer, MovieEntity> getMovies();

    @Query("SELECT * FROM movie_entities WHERE movieId = :movieId")
    LiveData<MovieEntity> getMovieDetail(String movieId);

    @Query("SELECT * FROM movie_entities WHERE favorited = 1")
    DataSource.Factory<Integer, MovieEntity> getFavMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovies(List<MovieEntity> movies);

    @Update
    void updateMovie(MovieEntity movies);

    //tv shows
    @Query("SELECT * FROM tv_show_entities")
    DataSource.Factory<Integer, TvEntity> getTvShows();

    @Query("SELECT * FROM tv_show_entities WHERE tvId = :tvId")
    LiveData<TvEntity> getTvShowDetail(String tvId);

    @Query("SELECT * FROM tv_show_entities WHERE favorited = 1")
    DataSource.Factory<Integer, TvEntity> getFavTvShow();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShows(List<TvEntity> tvShows);

    @Update
    void updateTvShow(TvEntity tvShow);


}
