package io.github.joaogouveia89.tikodog.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class DogBreedsResponse(
    @SerializedName("message")
    val message: Map<String, List<String>>,
    @SerializedName("status")
    val status: String
)
