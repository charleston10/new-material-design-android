package br.com.charleston.doghero.features.heroes.data

sealed class HeroState {
    data class Success(val data: List<HeroData>) : HeroState()
    data class Error(val error: Throwable) : HeroState()
    object Loading : HeroState()
}