package com.hwjoo.dagger2sample.di.component;

import com.hwjoo.dagger2sample.MainActivity;
import com.hwjoo.dagger2sample.di.PerActivity;
import com.hwjoo.dagger2sample.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by hwjoo on 2017-02-02.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
