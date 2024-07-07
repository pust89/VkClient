package com.pustovit.vkclient.data_source_impl.di

import android.content.Context
import com.pustovit.vkclient.models.build.BuildSettings

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:21
 */
interface DataSourceDependencies {

    fun context(): Context

    fun buildSettings(): BuildSettings

}