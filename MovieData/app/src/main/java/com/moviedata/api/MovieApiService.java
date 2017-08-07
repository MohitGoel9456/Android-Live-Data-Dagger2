package com.moviedata.api;

import com.moviedata.entities.MovieData;
import com.moviedata.entities.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by MGoel on 01-08-2017.
 */

public interface MovieApiService {
    @GET("3/search/multi?api_key=your-key")
    Call<MovieData> getMovie(@Query("query") String query,@Query("language") String language,@Query("page") int page
    ,@Query("region") String region,@Query("include_adult") boolean includeAdult);
}
