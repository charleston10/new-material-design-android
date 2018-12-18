package br.com.charleston.doghero.features.heroes.data

import br.com.charleston.doghero.domain.model.DataHeroesModel

sealed class HeroState {
    data class Success(val data: DataHeroesModel) : HeroState()
    data class Error(val error: Throwable) : HeroState()
    object Loading : HeroState()
}