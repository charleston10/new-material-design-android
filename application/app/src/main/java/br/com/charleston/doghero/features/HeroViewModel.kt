package br.com.charleston.doghero.features

import br.com.charleston.doghero.core.base.BaseViewModel
import br.com.charleston.doghero.domain.interactor.GetMyHeroes
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HeroViewModel @Inject constructor(
    private val getMyHeroes: GetMyHeroes
) : BaseViewModel() {

    fun foo() {
    }
}