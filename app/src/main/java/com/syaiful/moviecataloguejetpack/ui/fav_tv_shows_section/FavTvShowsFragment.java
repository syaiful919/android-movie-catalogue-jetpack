package com.syaiful.moviecataloguejetpack.ui.fav_tv_shows_section;


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
public class FavTvShowsFragment extends Fragment {
    private RecyclerView rvTv;
    private ProgressBar progressBar;

    public FavTvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fav_tv_shows, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTv = view.findViewById(R.id.rv_fav_tv_shows);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            FavTvShowsViewModel viewModel = new ViewModelProvider(this, factory).get(FavTvShowsViewModel.class);
            FavTvShowsAdapter adapter = new FavTvShowsAdapter();

            progressBar.setVisibility(View.VISIBLE);
            viewModel.getFavTvShows().observe(this, tv -> {
                if (tv != null) {
                    progressBar.setVisibility(View.GONE);
                    adapter.submitList(tv);
                    adapter.notifyDataSetChanged();
                }
            });

            rvTv.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTv.setHasFixedSize(true);
            rvTv.setAdapter(adapter);
        }
    }

}
