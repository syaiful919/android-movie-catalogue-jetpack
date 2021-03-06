package com.syaiful.moviecataloguejetpack.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.syaiful.moviecataloguejetpack.data.source.local.LocalDataSource;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.data.source.remote.RemoteDataSource;
import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;
import com.syaiful.moviecataloguejetpack.utils.AppExecutors;
import com.syaiful.moviecataloguejetpack.utils.DummyData;
import com.syaiful.moviecataloguejetpack.utils.LiveDataTestUtil;
import com.syaiful.moviecataloguejetpack.utils.PagedListUtil;
import com.syaiful.moviecataloguejetpack.vo.Resource;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieCatalogueRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSource remote = mock(RemoteDataSource.class);
    private LocalDataSource local = mock(LocalDataSource.class);
    private AppExecutors appExecutors = mock(AppExecutors.class);

    private FakeMovieCatalogueRepository movieCatalogueRepository = new FakeMovieCatalogueRepository(remote, local, appExecutors);

    private List<MovieResponse> movieResponses = DummyData.generateRemoteDummyMovies();
    private String movieId = movieResponses.get(0).getId();
    private MovieResponse movieResponse = DummyData.getRemoteSelectedMovie(movieId);
    private List<MovieResponse> tvShowResponses = DummyData.generateRemoteDummyTvShows();
    private String tvShowId = tvShowResponses.get(0).getId();
    private MovieResponse tvShowResponse = DummyData.getRemoteSelectedTvShows(tvShowId);

    @Test
    public void getMovies() {
        DataSource.Factory<Integer, MovieEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getMovies()).thenReturn(dataSourceFactory);
        movieCatalogueRepository.getMovies();

        Resource<PagedList<MovieEntity>> movieEntities = Resource.success(PagedListUtil.mockPagedList(DummyData.generateDummyMovies()));

        verify(local).getMovies();
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.data.size());
    }

    @Test
    public void getTvShows() {
        DataSource.Factory<Integer, TvEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getTvShows()).thenReturn(dataSourceFactory);
        movieCatalogueRepository.getTvShows();

        Resource<PagedList<TvEntity>> tvEntities = Resource.success(PagedListUtil.mockPagedList(DummyData.generateDummyTvShows()));

        verify(local).getTvShows();
        assertNotNull(tvEntities);
        assertEquals(tvShowResponses.size(), tvEntities.data.size());
    }

    @Test
    public void getFavMovies(){
        DataSource.Factory<Integer, MovieEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getFavMovies()).thenReturn(dataSourceFactory);
        movieCatalogueRepository.getFavMovies();

        Resource<PagedList<MovieEntity>> movieEntities = Resource.success(PagedListUtil.mockPagedList(DummyData.generateDummyMovies()));
        verify(local).getFavMovies();
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.data.size());
    }

    @Test
    public void getFavTvShows(){
        DataSource.Factory<Integer, TvEntity> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getFavTvShows()).thenReturn(dataSourceFactory);
        movieCatalogueRepository.getFavTvShows();

        Resource<PagedList<TvEntity>> tvEntities = Resource.success(PagedListUtil.mockPagedList(DummyData.generateDummyTvShows()));
        verify(local).getFavTvShows();
        assertNotNull(tvEntities);
        assertEquals(movieResponses.size(), tvEntities.data.size());
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