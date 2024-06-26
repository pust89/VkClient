package com.pustovit.vkclient.di

import com.pustovit.vkclient.auth_api.AuthFeatureApi
import com.pustovit.vkclient.data_api.DataApi
import com.pustovit.vkclient.data_source_api.DataSourceApi
import com.pustovit.vkclient.domain_api.DomainApi
import com.pustovit.vkclient.news_api.screens.NewsFeatureApi
import com.pustovit.vkclient.profile_api.ProfileFeatureApi
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.splash_api.SplashFeatureApi
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 22:15
 */
class AllApi @Inject constructor(
    val dataSourceApi: DataSourceApi,
    val dataApi: DataApi,
    val domainApi: DomainApi,
    val screenNavigator: ScreenNavigator,
    val authFeatureApi: Provider<AuthFeatureApi>,
    val profileFeatureApi: Provider<ProfileFeatureApi>,
    val splashFeatureApi: Provider<SplashFeatureApi>,
    val newsFeatureApi: Provider<NewsFeatureApi>,
)