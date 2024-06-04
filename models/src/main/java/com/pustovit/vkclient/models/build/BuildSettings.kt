package com.pustovit.vkclient.models.build

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 19:41
 */
interface BuildSettings {

    val baseUrl: String
    val apiVersion: String
    val buildVariant: BuildVariant

    enum class BuildVariant {
        Debug, Release
    }
}