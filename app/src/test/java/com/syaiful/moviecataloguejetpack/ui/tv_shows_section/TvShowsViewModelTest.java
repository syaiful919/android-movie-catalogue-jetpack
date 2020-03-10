package com.syaiful.moviecataloguejetpack.ui.tv_shows_section;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TvShowsViewModelTest {

    private TvShowsViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new TvShowsViewModel();
    }

    @Test
    public void getTvShows() {
        List<MovieEntity> tvShows = viewModel.getTvShows();
        assertNotNull(tvShows);
        assertEquals(10, tvShows.size());
    }
}