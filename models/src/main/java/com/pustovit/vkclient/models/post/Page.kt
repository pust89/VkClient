package com.pustovit.vkclient.models.post

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 16:35
 */
data class Page<T>(
    val items: List<T>,
    val nextFrom: String?
)