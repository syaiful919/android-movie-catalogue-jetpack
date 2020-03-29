package com.syaiful.moviecataloguejetpack.di;

import android.content.Context;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.local.LocalDataSource;
import com.syaiful.moviecataloguejetpack.data.source.local.room.LocalDatabase;
import com.syaiful.moviecataloguejetpack.data.source.remote.RemoteDataSource;
import com.syaiful.moviecataloguejetpack.utils.AppExecutors;
import com.syaiful.moviecataloguejetpack.utils.JsonHelper;

public class Injection {
    public static MovieCatalogueRepository provideRepository(Context context) {
        LocalDatabase database = LocalDatabase.getInstance(context);

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));
        LocalDataSource localDataSource = LocalDataSource.getInstance(database.movieDao());
        AppExecutors appExecutors = new AppExecutors();
        return MovieCatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors);
    }

}
