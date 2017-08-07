/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moviedata.di;

import android.app.Application;

import com.moviedata.api.MovieApiService;
import com.moviedata.repositories.MovieRepos;
import com.moviedata.repositories.MovieReposImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
class AppModule {
    public static final String BASE_URL = "https://api.themoviedb.org/";

    @Singleton
    @Provides
    MovieApiService provideGithubService() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(MovieApiService.class);
    }

    @Singleton
    @Provides
    MovieRepos provideMovieRepos(MovieReposImpl movieRepos) {
        return movieRepos;
    }


}
