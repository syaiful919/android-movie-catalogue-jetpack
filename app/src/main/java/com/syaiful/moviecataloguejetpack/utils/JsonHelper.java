package com.syaiful.moviecataloguejetpack.utils;

import android.content.Context;
import android.util.Log;

import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private Context context;

    public JsonHelper(Context context){
        this.context = context;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private String parsingFileToString(String fileName){
        try {
            InputStream is = context.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public List<MovieResponse> loadMovies(){
        List<MovieResponse> list = new ArrayList<>();
        try{
            String json = parsingFileToString("movies.json");
            if(json != null){
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("movies");
                for(int i = 0; i < listArray.length(); i++){
                    JSONObject movie = listArray.getJSONObject(i);

                    String id = movie.getString("id");
                    String title = movie.getString("title");
                    String description = movie.getString("description");
                    String posterPath = movie.getString("posterPath");

                    MovieResponse movieResponse = new MovieResponse(id, title, description, posterPath);
                    list.add(movieResponse);
                }
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<MovieResponse> loadTvShows(){
        List<MovieResponse> list = new ArrayList<>();
        try{
            String json = parsingFileToString("tv_shows.json");
            if(json != null){
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("tv_shows");
                for(int i = 0; i < listArray.length(); i++){
                    JSONObject tv = listArray.getJSONObject(i);

                    String id = tv.getString("id");
                    String title = tv.getString("title");
                    String description = tv.getString("description");
                    String posterPath = tv.getString("posterPath");

                    MovieResponse movieResponse = new MovieResponse(id, title, description, posterPath);
                    list.add(movieResponse);
                }
            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        return list;
    }

    public MovieResponse loadMovie(String _id){
        String fileName = String.format("movie_%s.json", _id);
        MovieResponse movieResponse = null;
        try {
            String result = parsingFileToString(fileName);
            if(result != null){
                JSONObject responseObject = new JSONObject(result);

                String id = responseObject.getString("id");
                String title = responseObject.getString("title");
                String description = responseObject.getString("description");
                String posterPath = responseObject.getString("posterPath");

                movieResponse = new MovieResponse(id, title, description, posterPath);
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        return movieResponse;
    }

    public MovieResponse loadTvShow(String _id){
        String fileName = String.format("tv_%s.json", _id);
        MovieResponse movieResponse = null;
        try {
            String result = parsingFileToString(fileName);
            if(result != null){
                JSONObject responseObject = new JSONObject(result);

                String id = responseObject.getString("id");
                String title = responseObject.getString("title");
                String description = responseObject.getString("description");
                String posterPath = responseObject.getString("posterPath");

                movieResponse = new MovieResponse(id, title, description, posterPath);
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
        return movieResponse;
    }
}
