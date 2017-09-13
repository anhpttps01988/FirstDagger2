package com.example.anhptt.architechmvp;


import android.app.Application;

import com.example.anhptt.architechmvp.common.di.ActivityBindingModule;
import com.example.anhptt.architechmvp.data.source.dagger.DataRepositoryModule;
import com.example.anhptt.architechmvp.data.source.repository.LoginDataRepository;
import com.example.anhptt.architechmvp.login.pojo.User;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        DataRepositoryModule.class,
        AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication>{

    void inject(App app);

    LoginDataRepository getLoginDataRepository();

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder{

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();

    }

}
