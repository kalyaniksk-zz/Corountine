package com.assignment.Coroutine.feature.Dagger


import androidx.lifecycle.ViewModel
import com.assignment.Coroutine.MainActivity
import com.assignment.Coroutine.feature.DetailViewModel
import com.assignment.Coroutine.feature.FirstFragment
import com.assignment.Coroutine.viewModel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun provideMainFragment(): FirstFragment


}