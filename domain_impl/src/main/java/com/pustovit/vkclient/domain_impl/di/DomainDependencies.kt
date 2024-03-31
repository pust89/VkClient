package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.data_impl.repository.FeedPostRepository

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:17
 */

interface DomainDependencies {
    fun feedPostRepository(): FeedPostRepository
}