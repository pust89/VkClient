package com.pustovit.vkclient.data_local_api

import com.pustovit.vkclient.data_local_api.auth.AuthLocalDataSource

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 21:59
 */
interface LocalDataSourceApi {

    fun authLocalDataSource(): AuthLocalDataSource
}