package com.syaiful.moviecataloguejetpack.ui.tv_shows_section;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.utils.DummyData;
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
public class TvShowsViewModelTest {

    private TvShowsViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogueRepository repository;

    @Mock
    private Observer<Resource<List<TvEntity>>> observer;

    @Before
    public void setUp() {
        viewModel = new TvShowsViewModel(repository);
    }

    @Test
    public void getTvShows() {
        Resource<List<TvEntity>> dummyTvShows = Resource.success(DummyData.generateDummyTvShows());
        MutableLiveData<Resource<List<TvEntity>>> movie = new MutableLiveData<>();
        movie.setValue(dummyTvShows);

        when(repository.getTvShows()).thenReturn(movie);
        List<TvEntity> tvShowsList = viewModel.getTvShows().getValue().data;
        assertNotNull(tvShowsList);
        assertEquals(10, tvShowsList.size());

        viewModel.getTvShows().observeForever(observer);
        verify(observer).onChanged(dummyTvShows);
    }


}