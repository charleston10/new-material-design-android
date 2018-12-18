package br.com.charleston.doghero.features

import br.com.charleston.doghero.core.base.BaseViewModel
import br.com.charleston.doghero.domain.DefaultObserver
import br.com.charleston.doghero.domain.interactor.GetMyHeroes
import br.com.charleston.doghero.domain.model.DataHeroesModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HeroViewModel @Inject constructor(
    private val getMyHeroes: GetMyHeroes
) : BaseViewModel() {

    fun testeApi(){
        getMyHeroes.execute(object : DefaultObserver<DataHeroesModel>() {
            override fun onNext(t: DataHeroesModel) {
                super.onNext(t)
                t.recents
            }

            override fun onError(exception: Throwable) {
                super.onError(exception)
            }

            override fun onComplete() {
                super.onComplete()
            }
        })
    }
}