package com.syaiful.moviecataloguejetpack.data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie_entities")
public class MovieEntity implements Parcelable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    private String movieId;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "posterPath")
    private String posterPath;

    @ColumnInfo(name = "favorited")
    private boolean favorited = false;

    @Ignore
    public MovieEntity() {

    }

    public MovieEntity(String movieId, String title, String description, String posterPath, Boolean favorited) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.posterPath = posterPath;
        if (favorited != null) {
            this.favorited = favorited;
        }
        this.favorited = favorited;
    }

    protected MovieEntity(Parcel in) {
        movieId = in.readString();
        title = in.readString();
        description = in.readString();
        posterPath = in.readString();
        favorited = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieId);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(posterPath);
        dest.writeByte((byte) (favorited ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel in) {
            return new MovieEntity(in);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }
}
