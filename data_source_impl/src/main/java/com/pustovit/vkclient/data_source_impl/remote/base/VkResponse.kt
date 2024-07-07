package com.pustovit.vkclient.data_source_impl.remote.base

import com.pustovit.vkclient.data_source_impl.remote.base.VkErrorDto.Companion.mapDomain


/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 20:24
 */

class VkResponse<T>(
    val response: T?,
    val error: VkErrorDto?,
)

inline fun <T, R> VkResponse<T>.process(
    onSuccess: (T?) -> R,
    onError: (VkErrorDto) -> R,
): R {
    if (error != null) {
        return onError(error)
    }
    return onSuccess(response)
}

inline fun <T, R> VkResponse<T>.process(onSuccess: (T?) -> R): R {
    if (error != null) {
        throw error.mapDomain()
    }
    return onSuccess(response)
}