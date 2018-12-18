package br.com.charleston.doghero.di.modules

import androidx.lifecycle.ViewModel
import br.com.charleston.doghero.core.viewmodel.ViewModelKey
import br.com.charleston.doghero.features.heroes.viewmodel.HeroViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HeroViewModel::class)
    abstract fun heroViewModel(viewModel: HeroViewModel): ViewModel
}