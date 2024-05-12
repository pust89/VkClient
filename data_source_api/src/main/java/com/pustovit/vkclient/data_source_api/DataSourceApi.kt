package com.pustovit.vkclient.data_source_api

import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 21:59
 */
interface DataSourceApi {

    fun authLocalDataSource(): AuthLocalDataSource
}