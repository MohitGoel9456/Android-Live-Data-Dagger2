package com.moviedata.ui;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moviedata.R;
import com.moviedata.di.Injectable;
import com.moviedata.viewmodel.MoviesDataViewModel;

import javax.inject.Inject;

/**
 * Created by MGoel on 02-08-2017.
 */

public class MovieDetailsFragment extends LifecycleFragment implements Injectable {
    private MoviesDataViewModel mViewModel;
    private RecyclerView rvMovies;
    private  View view;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MovieAdapter movieAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.movie_detail_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(getActivity(), viewModelFactory)
                .get(MoviesDataViewModel.class);
        setUpView(view);
        mViewModel.loadMovieData("the","en-US",1,"India",false);

        mViewModel.getApiResponse().observe(this,movieResponse -> {
            if (movieResponse.getError()!=null){

                Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
            }else {
                movieAdapter.getMovieResults(movieResponse.getMovie().getResults());
                Toast.makeText(getContext(),"successfull",Toast.LENGTH_LONG).show();
            }
        });

    }

        private void setUpView(View view) {
            rvMovies= view.findViewById(R.id.rv_movies);
            rvMovies.setHasFixedSize(true);
            movieAdapter=new MovieAdapter(getContext(),MovieDetailsFragment.this);
            rvMovies.setAdapter(movieAdapter);
            rvMovies.setItemAnimator(new DefaultItemAnimator());
            DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(
                    rvMovies.getContext(), LinearLayoutManager.VERTICAL
            );
            rvMovies.addItemDecoration(mDividerItemDecoration);
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity());
            rvMovies.setLayoutManager(linearLayoutManager);

        }

    public void replaceFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

    }
}
