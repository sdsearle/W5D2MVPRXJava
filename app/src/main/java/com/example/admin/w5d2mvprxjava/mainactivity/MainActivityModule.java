package com.example.admin.w5d2mvprxjava.mainactivity;



import com.example.admin.w5d2mvprxjava.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 9/26/2017.
 */

@Module
public class MainActivityModule {

    //add the dependencies using the @provides for each method
    @Provides
    MainActivityPresenter getMainActivityPresenter(){
        return new MainActivityPresenter();
    }



}
