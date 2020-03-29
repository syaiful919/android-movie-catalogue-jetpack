package com.syaiful.moviecataloguejetpack.ui.fav_movies_section;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FavMoviesViewModelTest {
    private FavMoviesViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogueRepository repository;

    @Mock
    private PagedList<MovieEntity> pagedList;

    @Mock
    private Observer<PagedList<MovieEntity>> observer;

    @Before
    public void setUp(){
        viewModel = new FavMoviesViewModel(repository);
    }

    @Test
    public void getFavMovies(){
        PagedList<MovieEntity> dummyMovies = pagedList;
        when(dummyMovies.size()).thenReturn(5);
        MutableLiveData<PagedList<MovieEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(repository.getFavMovies()).thenReturn(movies);
        List<MovieEntity> movieEntities = viewModel.getFavMovies().getValue();
        verify(repository).getFavMovies();
        assertNotNull(movieEntities);
        assertEquals(5, movieEntities.size());

        viewModel.getFavMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);

    }

}