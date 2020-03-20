package com.syaiful.moviecataloguejetpack.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;


public class MovieResponse implements Parcelable {
    private String movieId;
    private String title;
    private String description;
    private String posterPath;
    private String type;

    public MovieResponse(String _Id, String type, String title, String description, String posterPath) {
        this.movieId = _Id;
        this.title = title;
        this.description = description;
        this.posterPath = posterPath;
        this.type = type;
    }


    protected MovieResponse(Parcel in) {
        movieId = in.readString();
        title = in.readString();
        description = in.readString();
        posterPath = in.readString();
        type = in.readString();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return movieId;
    }

    public void setId(String id) {
        this.movieId = id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieId);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(posterPath);
        dest.writeString(type);
    }
}
