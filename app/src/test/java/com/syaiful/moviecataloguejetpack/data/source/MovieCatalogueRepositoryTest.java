package com.syaiful.moviecataloguejetpack.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.remote.RemoteDataSource;
import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;
import com.syaiful.moviecataloguejetpack.utils.DummyData;
import com.syaiful.moviecataloguejetpack.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class MovieCatalogueRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteDataSource remote = Mockito.mock(RemoteDataSource.class);
    private FakeMovieCatalogueRepository movieCatalogueRepository = new FakeMovieCatalogueRepository(remote);

    private ArrayList<MovieResponse> movieResponses = DummyData.generateRemoteDummyMovies();
    private String movieId = movieResponses.get(0).getId();
    private MovieResponse movieResponse = DummyData.getRemoteSelectedMovie(movieId);
    private ArrayList<MovieResponse> tvShowResponses = DummyData.generateRemoteDummyTvShows();
    private String tvShowId = tvShowResponses.get(0).getId();
    private MovieResponse tvShowResponse = DummyData.getRemoteSelectedTvShows(tvShowId);

    @Test
    public void getMovies() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMoviesCallback) invocation.getArguments()[0])
                    .onMoviesReceived(movieResponses);
            return null;
        }).when(remote).getMovies(any(RemoteDataSource.LoadMoviesCallback.class));
        ArrayList<MovieEntity> movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovies());
        verify(remote).getMovies(any(RemoteDataSource.LoadMoviesCallback.class));
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.size());
    }

    @Test
    public void getTvShows() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTvShowsCallback) invocation.getArguments()[0])
                    .onTvShowsReceived(tvShowResponses);
            return null;
        }).when(remote).getTvShows(any(RemoteDataSource.LoadTvShowsCallback.class));
        ArrayList<MovieEntity> tvShowEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShows());
        verify(remote).getTvShows(any(RemoteDataSource.LoadTvShowsCallback.class));
        assertNotNull(tvShowEntities);
        assertEquals(tvShowResponses.size(), tvShowEntities.size());
    }

    @Test
    public void getMovie() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMovieCallback) invocation.getArguments()[1])
                    .onMovieReceived(movieResponse);
            return null;
        }).when(remote).getMovie(eq(movieId), any(RemoteDataSource.LoadMovieCallback.class));
        MovieEntity movieEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovie(movieId));
        verify(remote).getMovie(eq(movieId), any(RemoteDataSource.LoadMovieCallback.class));
        assertNotNull(movieEntity);
        assertEquals(movieResponse.getTitle(), movieEntity.getTitle());
    }

    @Test
    public void getTvShow() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTvShowCallback) invocation.getArguments()[1])
                    .onTvShowReceived(tvShowResponse);
            return null;
        }).when(remote).getTvShow(eq(tvShowId), any(RemoteDataSource.LoadTvShowCallback.class));
        MovieEntity tvShowEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShow(tvShowId));
        verify(remote).getTvShow(eq(tvShowId), any(RemoteDataSource.LoadTvShowCallback.class));
        assertNotNull(tvShowEntity);
        assertEquals(tvShowResponse.getTitle(), tvShowEntity.getTitle());
    }
}