package com.syaiful.moviecataloguejetpack.ui.fav_tv_shows_section;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;

public class FavTvShowsViewModel extends ViewModel {
    private MovieCatalogueRepository repository;

    public FavTvShowsViewModel(MovieCatalogueRepository repository) {
        this.repository = repository;
    }

    public LiveData<PagedList<TvEntity>> getFavTvShows() {
        return repository.getFavTvShows();
    }
}
