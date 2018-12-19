package br.com.charleston.doghero.features.heroes.data

import br.com.charleston.doghero.domain.model.HeroModel

data class HeroData(
    var hero: HeroModel?,
    var heroType: HeroType,
    var dataType: DataType
) {
    enum class HeroType {
        RECENT, FAVORITES
    }

    enum class DataType {
        HERO, HEADER
    }
}