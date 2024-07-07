package com.pustovit.vkclient.data_source_impl.remote.base


import com.pustovit.vkclient.models.error.VkError
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VkErrorDto(
    @Json(name = "error_code")
    val errorCode: Int?,
    @Json(name = "error_msg")
    val errorMsg: String?,
    @Json(name = "request_params")
    val requestParams: List<RequestParamDto>?
) {
    @JsonClass(generateAdapter = true)
    data class RequestParamDto(
        @Json(name = "key")
        val key: String?,
        @Json(name = "value")
        val value: String?
    )

    companion object {
        fun VkErrorDto.mapDomain(): VkError {
            return VkError(
                errorCode = this.errorCode ?: 0,
                message = this.errorMsg.orEmpty()
            )
        }
    }
}

