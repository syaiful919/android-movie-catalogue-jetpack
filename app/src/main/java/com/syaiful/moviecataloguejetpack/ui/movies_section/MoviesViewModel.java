package com.syaiful.moviecataloguejetpack.ui.movies_section;

import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.utils.DummyData;

import java.util.List;

public class MoviesViewModel extends ViewModel {
    List<MovieEntity> getMovies() {
        return DummyData.generateDummyMovies();
    }
}
