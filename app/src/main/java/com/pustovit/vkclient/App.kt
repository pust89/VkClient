package com.pustovit.vkclient

import android.app.Application
import com.pustovit.vkclient.di.AllApi
import com.pustovit.vkclient.di.AppComponent
import com.pustovit.vkclient.di.DaggerAppComponent
import com.pustovit.vkclient.di.setFeatureDependencies
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:07
 */
class App : Application() {

    @Inject
    lateinit var allApi: AllApi

    internal val appComponent: AppComponent by lazy {
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

