package com.google.android.samples.storage

import androidx.lifecycle.ViewModel
import com.google.android.samples.dynamiccodeloading.di.BaseViewModelModule
import com.google.android.samples.dynamiccodeloading.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [BaseViewModelModule::class])
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [ActivityViewModelModule::class])
    abstract fun contributeStorageActivity(): StorageActivity

    @Module
    abstract class ActivityViewModelModule {
        @Binds
        @IntoMap
        @ViewModelKey(StorageViewModel::class)
        abstract fun bindStorageViewModel(viewModel: StorageViewModel): ViewModel
    }
}