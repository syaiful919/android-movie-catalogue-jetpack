package com.syaiful.moviecataloguejetpack.ui.fav_movies_section;


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
import com.syaiful.moviecataloguejetpack.viewmodel.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavMoviesFragment extends Fragment {
    private RecyclerView rvMovies;
    private ProgressBar progressBar;

    public FavMoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fav_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovies = view.findViewById(R.id.rv_fav_movies);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            FavMoviesViewModel viewModel = new ViewModelProvider(this, factory).get(FavMoviesViewModel.class);

            FavMoviesAdapter adapter = new FavMoviesAdapter();

            progressBar.setVisibility(View.VISIBLE);
            viewModel.getFavMovies().observe(this, movies -> {
                if (movies != null) {
                    progressBar.setVisibility(View.GONE);
                    adapter.submitList(movies);
                    adapter.notifyDataSetChanged();
                }
            });

            rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovies.setHasFixedSize(true);
            rvMovies.setAdapter(adapter);
        }
    }

}
