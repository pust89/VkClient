package com.pustovit.vkclient.di

import com.pustovit.vkclient.data_api.DataFeatureApi
import com.pustovit.vkclient.domain_api.news.DomainFeatureApi
import com.pustovit.vkclient.news_api.screens.NewsFeatureApi
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 22:15
 */
class AllApi @Inject constructor(
    val dataFeatureApi: DataFeatureApi,
    val domainFeatureApi: DomainFeatureApi,
    val newsFeatureApi: Provider<NewsFeatureApi>,
)