package com.pustovit.vkclient

import android.app.Application
import com.pustovit.vkclient.di.AllApi
import com.pustovit.vkclient.di.AppComponent
import com.pustovit.vkclient.di.DaggerAppComponent
import com.pustovit.vkclient.domain_api.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.injector.DependencyHolder
import com.pustovit.vkclient.injector.FeatureDependencies
import com.pustovit.vkclient.news_impl.di.NewsFeatureComponentHolder
import com.pustovit.vkclient.news_impl.di.NewsFeatureDependencies
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:07
 */
class App : Application() {

    @Inject
    lateinit var allApi: AllApi

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .applicationContext(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        // initTimber()
        setFeatureDependencies(allApi)
    }

//    private fun initTimber() {
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
//    }
}

private fun setFeatureDependencies(allApi: AllApi) {
    setNewsFeatureDependencies(allApi)
}

private fun setNewsFeatureDependencies(allApi: AllApi) {
    class NewsFeatureDependenciesHolder : DependencyHolder<NewsFeatureDependencies> {
        override val dependencies: NewsFeatureDependencies
            get() = object : NewsFeatureDependencies {
                override fun getAllPostsUseCase(): GetAllPostsUseCase {
                    return allApi.domainApi.getAllPostsUseCase()
                }

                override fun removePostUseCase(): RemovePostUseCase {
                    return allApi.domainApi.removePostUseCase()
                }

                override val dependencyHolder: DependencyHolder<out FeatureDependencies>
                    get() = this@NewsFeatureDependenciesHolder
            }
    }

    NewsFeatureComponentHolder.dependencyProvider = {
        NewsFeatureDependenciesHolder().dependencies
    }
}