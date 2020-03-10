package com.syaiful.moviecataloguejetpack.ui.detail_movie;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.utils.DummyData;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DetailMovieViewModelTest {
    private DetailMovieViewModel viewModelMovie;
    private MovieEntity dummyMovie = DummyData.getSelectedMovie("1");
    private String movieId = dummyMovie.getId();
    private String typeMovie = dummyMovie.getType();

    private DetailMovieViewModel viewModelTvShow;
    private MovieEntity dummyTvShow = DummyData.getSelectedTvShows("1");
    private String tvShowId = dummyTvShow.getId();
    private String typeTvShow = dummyTvShow.getType();

    @Before
    public void setUp() {
        viewModelMovie = new DetailMovieViewModel();
        viewModelMovie.setSelectedMovie(typeMovie, movieId);

        viewModelTvShow = new DetailMovieViewModel();
        viewModelTvShow.setSelectedMovie(typeTvShow, tvShowId);
    }

    @Test
    public void getSelectedMovie() {
        MovieEntity movie = viewModelMovie.getSelectedMovie();
        assertNotNull(movie);
        assertEquals(dummyMovie.getId(), movie.getId());
        assertEquals(dummyMovie.getType(), movie.getType());
        assertEquals(dummyMovie.getTitle(), movie.getTitle());
        assertEquals(dummyMovie.getDescription(), movie.getDescription());
        assertEquals(dummyMovie.getPosterPath(), movie.getPosterPath());

        MovieEntity tvShow = viewModelTvShow.getSelectedMovie();
        assertNotNull(tvShow);
        assertEquals(dummyTvShow.getId(), tvShow.getId());
        assertEquals(dummyTvShow.getType(), tvShow.getType());
        assertEquals(dummyTvShow.getTitle(), tvShow.getTitle());
        assertEquals(dummyTvShow.getDescription(), tvShow.getDescription());
        assertEquals(dummyTvShow.getPosterPath(), tvShow.getPosterPath());
    }
}