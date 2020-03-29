package com.syaiful.moviecataloguejetpack.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.di.Injection;
import com.syaiful.moviecataloguejetpack.ui.detail_movie.DetailMovieViewModel;
import com.syaiful.moviecataloguejetpack.ui.fav_movies_section.FavMoviesViewModel;
import com.syaiful.moviecataloguejetpack.ui.fav_tv_shows_section.FavTvShowsViewModel;
import com.syaiful.moviecataloguejetpack.ui.movies_section.MoviesViewModel;
import com.syaiful.moviecataloguejetpack.ui.tv_shows_section.TvShowsViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final MovieCatalogueRepository movieCatalogueRepository;

    public ViewModelFactory(MovieCatalogueRepository movieCatalogueRepository) {
        this.movieCatalogueRepository = movieCatalogueRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MoviesViewModel.class)) {
            return (T) new MoviesViewModel(movieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(TvShowsViewModel.class)) {
            return (T) new TvShowsViewModel(movieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)) {
            return (T) new DetailMovieViewModel(movieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(FavMoviesViewModel.class)) {
            return (T) new FavMoviesViewModel(movieCatalogueRepository);
        } else if (modelClass.isAssignableFrom(FavTvShowsViewModel.class)) {
            return (T) new FavTvShowsViewModel(movieCatalogueRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel Class: " + modelClass.getClass().getName());
    }
}
