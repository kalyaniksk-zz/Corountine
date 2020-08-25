package com.assignment.Coroutine

import com.assignment.Coroutine.Dagger.modules.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class BaseApplication : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        var appComponent = DaggerAppComponent.builder().application(this).build()
        //appComponent.inject(this)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
    }
}
