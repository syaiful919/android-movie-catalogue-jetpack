package com.syaiful.moviecataloguejetpack.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;

@Database(entities = {MovieEntity.class, TvEntity.class}, version = 1, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {
    public abstract LocalDao movieDao();

    public static volatile LocalDatabase INSTANCE;

    public static LocalDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (LocalDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LocalDatabase.class, "movie_catalogues.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
