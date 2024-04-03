package com.pustovit.vkclient.di

import com.pustovit.vkclient.data_api.DataApi
import com.pustovit.vkclient.data_local_api.LocalDataSourceApi
import com.pustovit.vkclient.domain_api.news.DomainApi
import com.pustovit.vkclient.news_api.screens.NewsFeatureApi
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 22:15
 */
class AllApi @Inject constructor(
    val localDataSourceApi: LocalDataSourceApi,
    val dataApi: DataApi,
    val domainApi: DomainApi,
    val newsFeatureApi: Provider<NewsFeatureApi>,
)