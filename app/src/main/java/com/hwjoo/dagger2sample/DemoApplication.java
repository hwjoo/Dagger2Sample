package com.hwjoo.dagger2sample;

import android.app.Application;

import com.hwjoo.dagger2sample.data.DataManager;
import com.hwjoo.dagger2sample.di.component.ApplicationComponent;

import javax.inject.Inject;

/**
 * Created by hwjoo on 2017-02-02.
 */

public class DemoApplication extends Application{
    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;
}
