package com.pustovit.vkclient.di

import coil.ImageLoader
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:08
 */
@Singleton
class FeatureApi @Inject constructor(
    val imageLoader: ImageLoader,
    val coreNetworkApi: CoreNetworkApi,
    val eventsApi: Provider<EventsApi>,
    val charactersApi: Provider<CharactersApi>,
    val eventApi: Provider<EventApi>,
    val characterApi: Provider<CharacterApi>,
)