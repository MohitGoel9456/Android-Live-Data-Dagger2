package com.moviedata.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.moviedata.entities.MovieResponse;
import com.moviedata.entities.Results;
import com.moviedata.repositories.MovieRepos;

import javax.inject.Inject;

/**
 * Created by MGoel on 01-08-2017.
 */

public class MoviesDataViewModel extends ViewModel {

    private MediatorLiveData<MovieResponse> movieResponseMediatorLiveData;
    private MovieRepos movieRepos;
    private final MutableLiveData<Results> selected = new MutableLiveData<Results>();

    public void select(Results result) {
        selected.setValue(result);
    }

    public LiveData<Results> getSelected() {
        return selected;
    }


    @Inject
    public MoviesDataViewModel(MovieRepos movieRepository) {
        movieResponseMediatorLiveData = new MediatorLiveData<>();
        movieRepos = movieRepository;
    }

    @NonNull
    public LiveData<MovieResponse> getApiResponse() {
        return movieResponseMediatorLiveData;
    }

    public LiveData<MovieResponse> loadMovieData(String query, String language, int page, String region, boolean b) {
        movieResponseMediatorLiveData.addSource(
                movieRepos.getMovieDetails(query,language,page,region,b),
                movieResponse -> movieResponseMediatorLiveData.setValue(movieResponse));

        return movieResponseMediatorLiveData;
    }

}
