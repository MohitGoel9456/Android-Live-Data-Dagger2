package com.moviedata.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.moviedata.R;
import com.moviedata.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends LifecycleActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieDetailsFragment movieDetailsFragment=new MovieDetailsFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container,movieDetailsFragment).commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}
