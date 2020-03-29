package com.syaiful.moviecataloguejetpack.ui.tv_shows_section;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.vo.Resource;

import java.util.List;

public class TvShowsViewModel extends ViewModel {
    private MovieCatalogueRepository repository;
    public TvShowsViewModel(MovieCatalogueRepository repository){
        this.repository = repository;
    }

    public LiveData<Resource<List<TvEntity>>> getTvShows() {
        return repository.getTvShows();
    }
}
