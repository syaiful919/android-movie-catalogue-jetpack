package com.syaiful.moviecataloguejetpack.ui.movies_section;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.vo.Resource;

public class MoviesViewModel extends ViewModel {
    private MovieCatalogueRepository repository;

    public MoviesViewModel(MovieCatalogueRepository repository) {
        this.repository = repository;
    }

    public LiveData<Resource<PagedList<MovieEntity>>> getMovies() {
        return repository.getMovies();
    }
}
