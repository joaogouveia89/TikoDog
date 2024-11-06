package io.github.joaogouveia89.tikodog.core.data.remote.api.response

import com.google.gson.annotations.SerializedName

data class DogImageResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String

)
