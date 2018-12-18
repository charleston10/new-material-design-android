package br.com.charleston.doghero.domain.model

data class DataHeroesModel(
    val recents: List<HeroModel>,
    val favorites: List<HeroModel>
)