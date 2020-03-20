package com.syaiful.moviecataloguejetpack.ui.tv_shows_section;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.utils.DummyData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TvShowsViewModelTest {

    private TvShowsViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogueRepository repository;

    @Mock
    private Observer<ArrayList<MovieEntity>> observer;

    @Before
    public void setUp() {
        viewModel = new TvShowsViewModel(repository);
    }

    @Test
    public void getTvShows() {
        ArrayList<MovieEntity> dummyTvShows = DummyData.generateDummyTvShows();
        MutableLiveData<ArrayList<MovieEntity>> movie = new MutableLiveData<>();
        movie.setValue(dummyTvShows);

        when(repository.getTvShows()).thenReturn(movie);
        ArrayList<MovieEntity> tvShowsList = viewModel.getTvShows().getValue();
        assertNotNull(tvShowsList);
        assertEquals(10, tvShowsList.size());

        viewModel.getTvShows().observeForever(observer);
        verify(observer).onChanged(dummyTvShows);
    }


}