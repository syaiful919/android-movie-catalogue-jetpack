package com.syaiful.moviecataloguejetpack.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.vo.Resource;

public interface MovieCatalogueDataSource {
    LiveData<Resource<PagedList<MovieEntity>>> getMovies();

    LiveData<Resource<PagedList<TvEntity>>> getTvShows();

    LiveData<PagedList<MovieEntity>> getFavMovies();

    LiveData<PagedList<TvEntity>> getFavTvShows();

    void setFavMovie(MovieEntity movie, boolean state);

    void setFavTvShow(TvEntity tv, boolean state);

    LiveData<MovieEntity> getMovie(String id);

    LiveData<TvEntity> getTvShow(String id);
}
