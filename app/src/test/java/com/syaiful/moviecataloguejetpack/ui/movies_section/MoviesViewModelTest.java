package com.syaiful.moviecataloguejetpack.ui.movies_section;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

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
    private Observer<Resource<PagedList<MovieEntity>>> observer;

    @Mock
    private PagedList<MovieEntity> pagedList;

    @Before
    public void setUp() {
        viewModel = new MoviesViewModel(repository);
    }

    @Test
    public void getMovies() {
        Resource<PagedList<MovieEntity>> dummyMovies = Resource.success(pagedList);
        when(dummyMovies.data.size()).thenReturn(5);
        MutableLiveData<Resource<PagedList<MovieEntity>>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(repository.getMovies()).thenReturn(movies);
        List<MovieEntity> movieList = viewModel.getMovies().getValue().data;
        verify(repository).getMovies();
        assertNotNull(movieList);
        assertEquals(5, movieList.size());

        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }

}