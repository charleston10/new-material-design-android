package br.com.charleston.doghero.di.modules

import br.com.charleston.doghero.features.MyHeroesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun myHeroFragment(): MyHeroesFragment
}