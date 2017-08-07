package com.moviedata.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.moviedata.api.MovieApiService;
import com.moviedata.entities.MovieData;
import com.moviedata.entities.MovieResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MGoel on 01-08-2017.
 */

public class MovieReposImpl implements MovieRepos {

    @Inject
    MovieApiService mApiService;

    @Inject
    public MovieReposImpl(){

    }


    @Override
    public LiveData<MovieResponse> getMovieDetails(String query, String language, int page, String region, boolean b) {
        final MutableLiveData<MovieResponse> data = new MutableLiveData<>();
        Call<MovieData> call = mApiService.getMovie(query, language, page, region, b);
        call.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {
                data.setValue(new MovieResponse(response.body()));
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {
                data.setValue(new MovieResponse(t));
            }
        });

        return data;
    }
}
