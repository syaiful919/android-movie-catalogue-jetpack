package com.syaiful.moviecataloguejetpack.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.syaiful.moviecataloguejetpack.data.source.local.LocalDataSource;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.data.source.remote.RemoteDataSource;
import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;
import com.syaiful.moviecataloguejetpack.utils.AppExecutors;
import com.syaiful.moviecataloguejetpack.utils.DummyData;
import com.syaiful.moviecataloguejetpack.utils.LiveDataTestUtil;
import com.syaiful.moviecataloguejetpack.vo.Resource;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieCatalogueRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSource remote = Mockito.mock(RemoteDataSource.class);
    private LocalDataSource local = Mockito.mock(LocalDataSource.class);
    private AppExecutors appExecutors = Mockito.mock(AppExecutors.class);

    private FakeMovieCatalogueRepository movieCatalogueRepository = new FakeMovieCatalogueRepository(remote, local, appExecutors);

    private List<MovieResponse> movieResponses = DummyData.generateRemoteDummyMovies();
    private String movieId = movieResponses.get(0).getId();
    private MovieResponse movieResponse = DummyData.getRemoteSelectedMovie(movieId);
    private List<MovieResponse> tvShowResponses = DummyData.generateRemoteDummyTvShows();
    private String tvShowId = tvShowResponses.get(0).getId();
    private MovieResponse tvShowResponse = DummyData.getRemoteSelectedTvShows(tvShowId);

    @Test
    public void getMovies() {
        MutableLiveData<List<MovieEntity>> dummyMovies = new MutableLiveData<>();
        dummyMovies.setValue(DummyData.generateDummyMovies());
        when(local.getMovies()).thenReturn(dummyMovies);

        Resource<List<MovieEntity>> movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovies());
        verify(local).getMovies();
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.data.size());
    }

    @Test
    public void getTvShows() {
        MutableLiveData<List<TvEntity>> dummyTvShows = new MutableLiveData<>();
        dummyTvShows.setValue(DummyData.generateDummyTvShows());
        when(local.getTvShows()).thenReturn(dummyTvShows);

        Resource<List<TvEntity>> tvEntites = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShows());
        verify(local).getTvShows();
        assertNotNull(tvEntites);
        assertEquals(tvShowResponses.size(), tvEntites.data.size());
    }

    @Test
    public void getMovie() {
        MutableLiveData<MovieEntity> dummyEntity = new MutableLiveData<>();
        dummyEntity.setValue(DummyData.getSelectedMovie(movieId));

        when(local.getDetailMovie(movieId)).thenReturn(dummyEntity);
        MovieEntity movieEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovie(movieId));
        verify(local).getDetailMovie(movieId);
        assertNotNull(movieEntity);
        assertEquals(movieResponse.getTitle(), movieEntity.getTitle());
    }

    @Test
    public void getTvShow() {
        MutableLiveData<TvEntity> dummyEntity = new MutableLiveData<>();
        dummyEntity.setValue(DummyData.getSelectedTvShows(tvShowId));

        when(local.getDetailTvShow(tvShowId)).thenReturn(dummyEntity);
        TvEntity tvEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShow(tvShowId));
        verify(local).getDetailTvShow(tvShowId);
        assertNotNull(tvEntity);
        assertEquals(tvShowResponse.getTitle(), tvEntity.getTitle());
    }
}