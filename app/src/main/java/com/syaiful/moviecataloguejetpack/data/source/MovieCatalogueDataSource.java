package com.syaiful.moviecataloguejetpack.data.source;

import androidx.lifecycle.LiveData;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.vo.Resource;

import java.util.List;

public interface MovieCatalogueDataSource {
    LiveData<Resource<List<MovieEntity>>> getMovies();
    LiveData<Resource<List<TvEntity>>> getTvShows();

    LiveData<List<MovieEntity>> getFavMovies();
    LiveData<List<TvEntity>> getFavTvShows();

    void setFavMovie(MovieEntity movie, boolean state);
    void setFavTvShow(TvEntity tv, boolean state);

    LiveData<MovieEntity> getMovie(String id);
    LiveData<TvEntity> getTvShow(String id);
}
