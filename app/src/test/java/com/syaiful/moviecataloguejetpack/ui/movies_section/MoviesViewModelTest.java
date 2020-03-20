package com.syaiful.moviecataloguejetpack.ui.movies_section;

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
public class MoviesViewModelTest {
    private MoviesViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogueRepository repository;

    @Mock
    private Observer<ArrayList<MovieEntity>> observer;

    @Before
    public void setUp() {
        viewModel = new MoviesViewModel(repository);
    }

    @Test
    public void getMovies() {
        ArrayList<MovieEntity> dummyMovies = DummyData.generateDummyMovies();
        MutableLiveData<ArrayList<MovieEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(repository.getMovies()).thenReturn(movies);
        ArrayList<MovieEntity> movieList = viewModel.getMovies().getValue();
        verify(repository).getMovies();
        assertNotNull(movieList);
        assertEquals(10, movieList.size());

        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }

}