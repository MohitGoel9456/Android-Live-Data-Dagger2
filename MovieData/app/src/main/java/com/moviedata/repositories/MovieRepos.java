package com.moviedata.repositories;

import android.arch.lifecycle.LiveData;

import com.moviedata.entities.MovieResponse;

import dagger.Provides;

/**
 * Created by MGoel on 01-08-2017.
 */
public interface MovieRepos {

    LiveData<MovieResponse> getMovieDetails(String query, String language, int page, String region, boolean b);
}
