package com.moviedata.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.moviedata.R;
import com.moviedata.di.Injectable;
import com.moviedata.entities.Results;
import com.moviedata.viewmodel.MoviesDataViewModel;
import com.moviedata.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by MGoel on 02-08-2017.
 */

public class PopularityFragment extends LifecycleFragment implements Injectable {

    private TextView tvOriginalName, tvPopularity;
    private MoviesDataViewModel mViewModel;
    private List<Results> results;

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_popularity,container,false);
        tvOriginalName = view.findViewById(R.id.tv_original_name);
        tvPopularity = view.findViewById(R.id.tv_popularity);
        mViewModel = ViewModelProviders.of(getActivity(), viewModelFactory)
                .get(MoviesDataViewModel.class);
        Results results = mViewModel.getSelected().getValue();

        if (results != null)
            tvPopularity.setText(results.getPopularity());
        tvOriginalName.setText(results.getOriginal_name());
        return view;
    }

}
