package br.com.charleston.doghero.domain.model

data class HeroModel(
    var isSuperHero: Boolean,
    var user: UserModel,
    var addressNeighborhood: String,
    var price: Double
)