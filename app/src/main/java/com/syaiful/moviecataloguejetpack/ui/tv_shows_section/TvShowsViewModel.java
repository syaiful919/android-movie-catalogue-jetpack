package com.syaiful.moviecataloguejetpack.ui.tv_shows_section;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.utils.DummyData;

import java.util.ArrayList;
import java.util.List;

public class TvShowsViewModel extends ViewModel {
    private MovieCatalogueRepository repository;
    public TvShowsViewModel(MovieCatalogueRepository repository){
        this.repository = repository;
    }

    public LiveData<ArrayList<MovieEntity>> getTvShows() {
        return repository.getTvShows();
    }
}
