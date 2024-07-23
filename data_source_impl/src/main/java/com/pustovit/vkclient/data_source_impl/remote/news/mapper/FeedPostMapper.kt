package com.pustovit.vkclient.data_source_impl.remote.news.mapper

import android.util.Log
import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostDto
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
        return dto?.items?.map(::map) ?: emptyList()
    }

    private fun map(dto: FeedPostDto): FeedPost {
        return FeedPost(
            id = dto.id ?: 0,
            communityName = "communityName",
            contentText = dto.text.orEmpty(),
            contentImageUrl = getContentPhotoUrl(dto)
        )
    }

    private fun getContentPhotoUrl(dto: FeedPostDto):String{
        return dto.attachments?.getOrNull(0)?.photo?.sizes?.last()?.url.orEmpty()
    }
}