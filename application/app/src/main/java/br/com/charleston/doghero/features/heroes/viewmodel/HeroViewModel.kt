package br.com.charleston.doghero.features.heroes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.charleston.doghero.core.base.BaseViewModel
import br.com.charleston.doghero.domain.DefaultObserver
import br.com.charleston.doghero.domain.interactor.GetMyHeroes
import br.com.charleston.doghero.domain.model.DataHeroesModel
import br.com.charleston.doghero.domain.model.HeroModel
import br.com.charleston.doghero.features.heroes.adapters.HeroData
import br.com.charleston.doghero.features.heroes.data.HeroState
import java.util.*
import javax.inject.Inject

interface InputHeroViewModel {
    fun showHeroes()
}

interface OutputHeroViewModel {
    val heroes: LiveData<HeroState>
}

interface ContractHeroViewModel {
    val input: InputHeroViewModel
    val output: OutputHeroViewModel
}

class HeroViewModel @Inject constructor(
    private val getMyHeroes: GetMyHeroes
) : BaseViewModel(),
    ContractHeroViewModel,
    InputHeroViewModel,
    OutputHeroViewModel {

    override val input: InputHeroViewModel get() = this
    override val output: OutputHeroViewModel get() = this

    private val heroesObservable = MutableLiveData<HeroState>()
    override val heroes: LiveData<HeroState> get() = heroesObservable

    override fun showHeroes() {
        getMyHeroes.execute(object : DefaultObserver<DataHeroesModel>() {
            override fun onStart() {
                super.onStart()
                heroesObservable.postValue(HeroState.Loading)
            }

            override fun onNext(t: DataHeroesModel) {
                super.onNext(t)
                heroesObservable.postValue(HeroState.Success(mapToHeroData(t)))
            }

            override fun onError(exception: Throwable) {
                super.onError(exception)
                heroesObservable.postValue(HeroState.Error(exception))
            }
        })
    }

    private fun mapToHeroData(dataHeroesModel: DataHeroesModel): List<HeroData> {
        val items: ArrayList<HeroData> = arrayListOf()
        items.addAll(transform(dataHeroesModel.recents, HeroData.HeroType.RECENT))
        items.addAll(transform(dataHeroesModel.favorites, HeroData.HeroType.FAVORITES))
        return items
    }

    private fun transform(favorites: List<HeroModel>, heroType: HeroData.HeroType): List<HeroData> {
        val items: ArrayList<HeroData> = arrayListOf()

        items.add(HeroData(null, heroType, HeroData.DataType.HEADER))

        val mapped = favorites.map {
            HeroData(it, heroType, HeroData.DataType.HERO)
        }

        return items.apply {
            addAll(mapped)
        }
    }
}