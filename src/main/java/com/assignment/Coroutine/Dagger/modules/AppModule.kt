package com.assignment.Coroutine.Dagger.modules


import android.app.Application
import com.assignment.Coroutine.BaseApplication

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun providesApplication(application: BaseApplication): Application {
        return application
    }

}