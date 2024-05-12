package com.pustovit.vkclient.data_impl.di

import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:23
 */
interface DataDependencies {
    fun authLocalDataSource(): AuthLocalDataSource
}