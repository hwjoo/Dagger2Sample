package com.hwjoo.dagger2sample.di.module;

import android.app.Activity;
import android.content.Context;

import com.hwjoo.dagger2sample.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hwjoo on 2017-02-02.
 */

@Module
public class ActivityModule {
    private Activity mActivity;
    public ActivityModule(Activity activity){
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }
    @Provides
    Activity provideActivity(){
        return mActivity;
    }
}
