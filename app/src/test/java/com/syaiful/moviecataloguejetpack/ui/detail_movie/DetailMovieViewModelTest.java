package com.syaiful.moviecataloguejetpack.ui.detail_movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
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
    private DetailMovieViewModel viewModelTvShow;

    private MovieEntity dummyMovie = DummyData.getSelectedMovie("1");
    private String movieId = dummyMovie.getMovieId();

    private TvEntity dummyTvShow = DummyData.getSelectedTvShows("1");
    private String tvShowId = dummyTvShow.getTvId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogueRepository repository;

    @Mock
    private Observer<MovieEntity> movieObserver;

    @Mock
    private Observer<TvEntity> tvShowObserver;

    @Before
    public void setUp() {
        viewModelMovie = new DetailMovieViewModel(repository);
        viewModelMovie.setId(movieId);

        viewModelTvShow = new DetailMovieViewModel(repository);
        viewModelTvShow.setId(tvShowId);
    }

    @Test
    public void getSelectedMovie() {
        MutableLiveData<MovieEntity> movieEx = new MutableLiveData<>();
        movieEx.setValue(dummyMovie);

        when(repository.getMovie(movieId)).thenReturn(movieEx);
        viewModelMovie.selectedMovie.observeForever(movieObserver);
        verify(movieObserver).onChanged(dummyMovie);

    }

    @Test
    public void getSelectedTvShow(){
        MutableLiveData<TvEntity> tvShowEx = new MutableLiveData<>();
        tvShowEx.setValue(dummyTvShow);

        when(repository.getTvShow(tvShowId)).thenReturn(tvShowEx);
        viewModelTvShow.selectedTv.observeForever(tvShowObserver);
        verify(tvShowObserver).onChanged(dummyTvShow);
    }
}