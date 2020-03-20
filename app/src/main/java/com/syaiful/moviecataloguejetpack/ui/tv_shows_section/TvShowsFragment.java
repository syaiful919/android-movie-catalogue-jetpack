package com.syaiful.moviecataloguejetpack.ui.tv_shows_section;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.syaiful.moviecataloguejetpack.R;
import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class TvShowsFragment extends Fragment {
    private RecyclerView rvMovies;
    private ProgressBar progressBar;

    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovies = view.findViewById(R.id.rv_tv_shows);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvShowsViewModel viewModel = new ViewModelProvider(this, factory).get(TvShowsViewModel.class);

            TvShowsAdapter adapter = new TvShowsAdapter();
            progressBar.setVisibility(View.VISIBLE);
            viewModel.getTvShows().observe(this, tvShow -> {
                progressBar.setVisibility(View.GONE);
                adapter.setTvShows(tvShow);
                adapter.notifyDataSetChanged();
            });

            rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovies.setHasFixedSize(true);
            rvMovies.setAdapter(adapter);
        }
    }


}
