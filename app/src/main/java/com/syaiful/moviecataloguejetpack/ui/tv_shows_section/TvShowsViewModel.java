package com.syaiful.moviecataloguejetpack.ui.tv_shows_section;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.vo.Resource;

public class TvShowsViewModel extends ViewModel {
    private MovieCatalogueRepository repository;

    public TvShowsViewModel(MovieCatalogueRepository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<PagedList<TvEntity>>> getTvShows() {
        return repository.getTvShows();
    }
}
