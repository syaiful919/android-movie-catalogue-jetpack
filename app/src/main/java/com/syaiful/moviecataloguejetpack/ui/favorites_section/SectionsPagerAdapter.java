package com.syaiful.moviecataloguejetpack.ui.favorites_section;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.syaiful.moviecataloguejetpack.R;
import com.syaiful.moviecataloguejetpack.ui.fav_movies_section.FavMoviesFragment;
import com.syaiful.moviecataloguejetpack.ui.fav_tv_shows_section.FavTvShowsFragment;
import com.syaiful.moviecataloguejetpack.ui.movies_section.MoviesFragment;
import com.syaiful.moviecataloguejetpack.ui.tv_shows_section.TvShowsFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.movies, R.string.tv_shows};

    private final FavoritesFragment mContext;

    SectionsPagerAdapter(FavoritesFragment context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FavMoviesFragment();
            case 1:
                return new FavTvShowsFragment();
            default:
                return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}
