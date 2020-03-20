package com.syaiful.moviecataloguejetpack.ui.detail_movie;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailMovieViewModelTest {
    private DetailMovieViewModel viewModelMovie;
    private MovieEntity dummyMovie = DummyData.getSelectedMovie("1");
    private String movieId = dummyMovie.getId();
    private String typeMovie = dummyMovie.getType();

    private DetailMovieViewModel viewModelTvShow;
    private MovieEntity dummyTvShow = DummyData.getSelectedTvShows("1");
    private String tvShowId = dummyTvShow.getId();
    private String typeTvShow = dummyTvShow.getType();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogueRepository repository;

    @Mock
    private Observer<MovieEntity> movieObserver;

    @Mock
    private Observer<MovieEntity> tvShowObserver;

    @Before
    public void setUp() {
        viewModelMovie = new DetailMovieViewModel(repository);
        viewModelMovie.setSelectedMovie(typeMovie, movieId);

        viewModelTvShow = new DetailMovieViewModel(repository);
        viewModelTvShow.setSelectedMovie(typeTvShow, tvShowId);
    }

    @Test
    public void getSelectedMovie() {
        MutableLiveData<MovieEntity> movieEx = new MutableLiveData<>();
        movieEx.setValue(dummyMovie);

        when(repository.getMovie(movieId)).thenReturn(movieEx);
        MovieEntity movie = viewModelMovie.getSelectedMovie().getValue();
        verify(repository).getMovie(movieId);

        MutableLiveData<MovieEntity> tvShowEx = new MutableLiveData<>();
        tvShowEx.setValue(dummyTvShow);

        when(repository.getTvShow(tvShowId)).thenReturn(tvShowEx);
        MovieEntity tvShow = viewModelTvShow.getSelectedMovie().getValue();
        verify(repository).getTvShow(tvShowId);

        assertNotNull(movie);
        assertEquals(dummyMovie.getId(), movie.getId());
        assertEquals(dummyMovie.getType(), movie.getType());
        assertEquals(dummyMovie.getTitle(), movie.getTitle());
        assertEquals(dummyMovie.getDescription(), movie.getDescription());
        assertEquals(dummyMovie.getPosterPath(), movie.getPosterPath());


        assertNotNull(tvShow);
        assertEquals(dummyTvShow.getId(), tvShow.getId());
        assertEquals(dummyTvShow.getType(), tvShow.getType());
        assertEquals(dummyTvShow.getTitle(), tvShow.getTitle());
        assertEquals(dummyTvShow.getDescription(), tvShow.getDescription());
        assertEquals(dummyTvShow.getPosterPath(), tvShow.getPosterPath());

        viewModelMovie.getSelectedMovie().observeForever(movieObserver);
        verify(movieObserver).onChanged(dummyMovie);

        viewModelTvShow.getSelectedMovie().observeForever(tvShowObserver);
        verify(tvShowObserver).onChanged(dummyTvShow);
    }
}