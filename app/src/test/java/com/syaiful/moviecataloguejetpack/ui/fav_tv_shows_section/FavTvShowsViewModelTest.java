package com.syaiful.moviecataloguejetpack.ui.fav_tv_shows_section;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;

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
public class FavTvShowsViewModelTest {
    private FavTvShowsViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogueRepository repository;

    @Mock
    private PagedList<TvEntity> pagedList;

    @Mock
    private Observer<PagedList<TvEntity>> observer;

    @Before
    public void setUp(){
        viewModel = new FavTvShowsViewModel(repository);
    }

    @Test
    public void getFavTvShows(){
        PagedList<TvEntity> dummyTV = pagedList;
        when(dummyTV.size()).thenReturn(5);
        MutableLiveData<PagedList<TvEntity>> tv = new MutableLiveData<>();
        tv.setValue(dummyTV);

        when(repository.getFavTvShows()).thenReturn(tv);
        List<TvEntity> movieEntities = viewModel.getFavTvShows().getValue();
        verify(repository).getFavTvShows();
        assertNotNull(movieEntities);
        assertEquals(5, movieEntities.size());

        viewModel.getFavTvShows().observeForever(observer);
        verify(observer).onChanged(dummyTV);
    }
}