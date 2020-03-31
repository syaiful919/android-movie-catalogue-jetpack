package com.syaiful.moviecataloguejetpack.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.syaiful.moviecataloguejetpack.data.source.local.LocalDataSource;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.data.source.remote.ApiResponse;
import com.syaiful.moviecataloguejetpack.data.source.remote.RemoteDataSource;
import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;
import com.syaiful.moviecataloguejetpack.utils.AppExecutors;
import com.syaiful.moviecataloguejetpack.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalogueRepository implements MovieCatalogueDataSource {

    private volatile static MovieCatalogueRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    private MovieCatalogueRepository(@NonNull RemoteDataSource remoteDataSource, @NonNull LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }

    public static MovieCatalogueRepository getInstance(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (MovieCatalogueRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieCatalogueRepository(remoteDataSource, localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public LiveData<Resource<PagedList<MovieEntity>>> getMovies() {
        return new NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {

            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build();
                return new LivePagedListBuilder<>(localDataSource.getMovies(), config).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteDataSource.getMovies();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                List<MovieEntity> movieList = new ArrayList<>();
                for (MovieResponse response : data) {
                    MovieEntity movie = new MovieEntity(
                            response.getId(),
                            response.getTitle(),
                            response.getDescription(),
                            response.getPosterPath(),
                            false
                    );
                    movieList.add(movie);
                }
                localDataSource.insertMovies(movieList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<TvEntity>>> getTvShows() {
        return new NetworkBoundResource<PagedList<TvEntity>, List<MovieResponse>>(appExecutors) {

            @Override
            protected LiveData<PagedList<TvEntity>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build();
                return new LivePagedListBuilder<>(localDataSource.getTvShows(), config).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<TvEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteDataSource.getTvShows();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                List<TvEntity> tvShowList = new ArrayList<>();
                for (MovieResponse response : data) {
                    TvEntity tvShow = new TvEntity(
                            response.getId(),
                            response.getTitle(),
                            response.getDescription(),
                            response.getPosterPath(),
                            false
                    );
                    tvShowList.add(tvShow);
                }
                localDataSource.insertTvShows(tvShowList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<PagedList<MovieEntity>> getFavMovies() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getFavMovies(), config).build();
    }

    @Override
    public LiveData<PagedList<TvEntity>> getFavTvShows() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getFavTvShows(), config).build();
    }

    @Override
    public void setFavMovie(MovieEntity movie, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setFavMovie(movie, state));
    }

    @Override
    public void setFavTvShow(TvEntity tv, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setFavTvShow(tv, state));
    }

    @Override
    public LiveData<MovieEntity> getMovie(String id) {
        return localDataSource.getDetailMovie(id);
    }

    @Override
    public LiveData<TvEntity> getTvShow(String id) {
        return localDataSource.getDetailTvShow(id);
    }
}
