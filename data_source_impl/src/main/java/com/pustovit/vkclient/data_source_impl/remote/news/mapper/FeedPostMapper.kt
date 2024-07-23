package com.pustovit.vkclient.data_source_impl.remote.news.mapper

import android.util.Log
import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostResponseDto
import com.pustovit.vkclient.models.post.FeedPost
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 07.07.2024
 * Time: 18:08
 */
class FeedPostMapper @Inject constructor() {

    fun map(dto: FeedPostResponseDto?): List<FeedPost> {
        dto?.items?.forEach {
            Log.d("TAG", "dto = $it ")
        }
        return emptyList()
    }
}