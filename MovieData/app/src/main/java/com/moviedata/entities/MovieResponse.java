package com.moviedata.entities;

import android.graphics.Movie;

import java.util.List;

/**
 * Created by MGoel on 01-08-2017.
 */

public class MovieResponse {

    private MovieData movie;
    private Throwable error;

    public MovieResponse(MovieData movie){
        this.movie=movie;
        this.error=null;
    }

    public MovieResponse(Throwable error){
        this.error=error;
        movie=null;
    }

    public MovieData getMovie() {
        return movie;
    }

    public void setMovie(MovieData movie) {
        this.movie = movie;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }
}
