package com.syaiful.moviecataloguejetpack.ui.movies_section;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MoviesViewModelTest {
    private MoviesViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MoviesViewModel();
    }

    @Test
    public void getMovies() {
        List<MovieEntity> movies = viewModel.getMovies();
        assertNotNull(movies);
        assertEquals(10, movies.size());
    }

}