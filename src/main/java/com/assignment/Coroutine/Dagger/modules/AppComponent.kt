package com.assignment.Coroutine.Dagger.modules

import com.assignment.Coroutine.BaseApplication
import com.assignment.Coroutine.feature.Dagger.MainActivityModule


import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApiModule::class,
    AppModule::class,
    ViewModelFactoryModule::class,
    MainActivityModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {



    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder
        fun build(): AppComponent
    }
}