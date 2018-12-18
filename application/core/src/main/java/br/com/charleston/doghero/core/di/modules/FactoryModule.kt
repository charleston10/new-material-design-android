package br.com.charleston.doghero.core.di.modules

import androidx.lifecycle.ViewModelProvider
import br.com.charleston.doghero.core.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class FactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}