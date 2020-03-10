package com.syaiful.moviecataloguejetpack.ui.tv_shows_section;

import androidx.lifecycle.ViewModel;

import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.utils.DummyData;

import java.util.List;

public class TvShowsViewModel extends ViewModel {

    List<MovieEntity> getTvShows() {
        return DummyData.generateDummyTvShows();
    }
}
