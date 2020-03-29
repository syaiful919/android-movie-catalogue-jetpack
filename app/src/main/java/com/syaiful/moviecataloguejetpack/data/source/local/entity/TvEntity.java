package com.syaiful.moviecataloguejetpack.data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tv_show_entities")
public class TvEntity implements Parcelable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvId")
    private String tvId;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "posterPath")
    private String posterPath;

    @ColumnInfo(name = "favorited")
    private boolean favorited = false;

    @Ignore
    public TvEntity() {

    }

    public TvEntity(String tvId, String title, String description, String posterPath, boolean favorited) {
        this.tvId = tvId;
        this.title = title;
        this.description = description;
        this.posterPath = posterPath;
        this.favorited = favorited;
    }


    protected TvEntity(Parcel in) {
        tvId = in.readString();
        title = in.readString();
        description = in.readString();
        posterPath = in.readString();
        favorited = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tvId);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(posterPath);
        dest.writeByte((byte) (favorited ? 1 : 0));
    }

    public static final Creator<TvEntity> CREATOR = new Creator<TvEntity>() {
        @Override
        public TvEntity createFromParcel(Parcel in) {
            return new TvEntity(in);
        }

        @Override
        public TvEntity[] newArray(int size) {
            return new TvEntity[size];
        }
    };

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
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
