package com.syaiful.moviecataloguejetpack.di;

import android.content.Context;

import com.syaiful.moviecataloguejetpack.data.source.MovieCatalogueRepository;
import com.syaiful.moviecataloguejetpack.data.source.remote.RemoteDataSource;
import com.syaiful.moviecataloguejetpack.utils.JsonHelper;

public class Injection {
    public static MovieCatalogueRepository provideRepository(Context context){
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));
        return MovieCatalogueRepository.getInstance(remoteDataSource);
    }

}
