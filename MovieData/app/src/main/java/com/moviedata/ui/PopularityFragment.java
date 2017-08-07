package com.moviedata.ui;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moviedata.R;
import com.moviedata.di.Injectable;
import com.moviedata.entities.Results;
import com.moviedata.viewmodel.MoviesDataViewModel;

import org.w3c.dom.Text;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MGoel on 02-08-2017.
 */

public class PopularityFragment extends LifecycleFragment implements Injectable {

    @BindView(R.id.tv_original_name)
    TextView tvOriginalName;

    @BindView(R.id.tv_popularity)
    TextView tvPopularity;

    private MoviesDataViewModel mViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_popularity,container,false);
        ButterKnife.bind(this,view);

        tvOriginalName = view.findViewById(R.id.tv_original_name);
        tvPopularity = view.findViewById(R.id.tv_popularity);
        mViewModel = ViewModelProviders.of(getActivity(), viewModelFactory)
                .get(MoviesDataViewModel.class);
        Results results = mViewModel.getSelected().getValue();

        if (results != null) {
            tvPopularity.setText("popularity= "+results.getPopularity());
            tvOriginalName.setText(results.getOriginal_name());
        }
        return view;
    }

}
