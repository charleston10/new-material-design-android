package br.com.charleston.doghero.data.cloud.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HeroResponse(
    @SerializedName("is_superhero") var isSuperHero: Boolean,
    @SerializedName("user") var user: UserResponse,
    @SerializedName("address_neighborhood") var addressNeighborhood: String,
    @SerializedName("price") var price: Double
) : Serializable