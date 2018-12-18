package br.com.charleston.doghero.data.cloud.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataResponse(
    @SerializedName("recents") val recents: List<HeroResponse>,
    @SerializedName("favorites") val favorites: List<HeroResponse>
) : Serializable