package br.com.charleston.doghero.di.modules

import br.com.charleston.doghero.features.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun questionActivity(): MainActivity
}