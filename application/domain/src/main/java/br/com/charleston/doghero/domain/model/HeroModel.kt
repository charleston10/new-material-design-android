package br.com.charleston.doghero.domain.model

import androidx.databinding.BaseObservable

data class HeroModel(
    var isSuperHero: Boolean,
    var user: UserModel,
    var addressNeighborhood: String,
    var price: Double
) : BaseObservable()