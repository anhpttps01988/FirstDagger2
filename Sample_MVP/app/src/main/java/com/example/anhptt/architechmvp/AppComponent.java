package com.example.anhptt.architechmvp;


import android.app.Application;

import com.example.anhptt.architechmvp.common.di.ActivityBindingModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication>{

    void inject(App app);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder{

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();

    }

}
