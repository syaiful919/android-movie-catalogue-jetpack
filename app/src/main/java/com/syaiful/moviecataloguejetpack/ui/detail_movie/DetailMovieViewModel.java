package com.syaiful.moviecataloguejetpack.ui.detail_movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.vo.Resource;

public class DetailMovieViewModel extends ViewModel {
    private MovieCatalogueRepository repository;
    private MutableLiveData<String> movieId = new MutableLiveData<>();

    public DetailMovieViewModel(MovieCatalogueRepository repository){
        this.repository = repository;
    }

    public void setId(String id){
        this.movieId.setValue(id);
    }

    public String getId(){
        return movieId.getValue();
    }

    public LiveData<MovieEntity> selectedMovie = Transformations.switchMap(movieId,
            id -> repository.getMovie(id)
    );

    public LiveData<TvEntity> selectedTv = Transformations.switchMap(movieId,
            id -> repository.getTvShow(id)
    );

    void setFavMovie(){
        MovieEntity movie = selectedMovie.getValue();
        if(movie != null){
            final boolean newState = !movie.isFavorited();
            repository.setFavMovie(movie, newState);
        }
    }

    void setFavTvShow(){
        TvEntity tv = selectedTv.getValue();
        if(tv != null){
            final boolean newState = !tv.isFavorited();
            repository.setFavTvShow(tv, newState);
        }
    }

}
