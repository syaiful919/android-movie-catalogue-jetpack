package com.syaiful.moviecataloguejetpack.ui.fav_tv_shows_section;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.viewmodel.ViewModelFactory;

import java.util.List;

public class FavTvShowsViewModel extends ViewModel {
    private MovieCatalogueRepository repository;
    public FavTvShowsViewModel(MovieCatalogueRepository repository){
        this.repository = repository;
    }

    public LiveData<List<TvEntity>> getFavTvShows(){
        return repository.getFavTvShows();
    }
}
