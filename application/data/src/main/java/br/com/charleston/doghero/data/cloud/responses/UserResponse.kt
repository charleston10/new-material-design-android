package br.com.charleston.doghero.data.cloud.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserResponse(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("image_url") val imageUrl: String
) : Serializable