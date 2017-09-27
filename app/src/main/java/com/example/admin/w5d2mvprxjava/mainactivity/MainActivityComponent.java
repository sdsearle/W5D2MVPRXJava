package com.example.admin.w5d2mvprxjava.mainactivity;

import com.example.admin.w5d2mvprxjava.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by admin on 9/26/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    //inject the activity reference for the object
    void inject(MainActivity mainActivity);

}
