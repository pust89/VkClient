package com.pustovit.vkclient.data_source_impl.remote.user.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 18:08
 */
@JsonClass(generateAdapter = true)
internal data class UserDto(
    @Json(name = "can_access_closed")
    val canAccessClosed: Boolean?,
    @Json(name = "first_name")
    val firstName: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "is_closed")
    val isClosed: Boolean?,
    @Json(name = "last_name")
    val lastName: String?
)