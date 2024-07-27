package com.pustovit.vkclient.data_source_impl.remote.news.mapper

import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostDto
import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostResponseDto
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.StatisticItem
import com.pustovit.vkclient.models.post.StatisticType
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 07.07.2024
 * Time: 18:08
 */
internal class FeedPostMapper @Inject constructor() {

    fun map(dto: FeedPostResponseDto?): List<FeedPost> {
        return dto?.items?.map(::map) ?: emptyList()
    }

    private fun map(dto: FeedPostDto): FeedPost {
        return FeedPost(
            id = dto.id ?: 0,
            communityName = "communityName",
            contentText = dto.text.orEmpty(),
            contentImageUrl = getContentPhotoUrl(dto),
            statistics = getStatistics(dto)
        )
    }

    private fun getContentPhotoUrl(dto: FeedPostDto): String {
        return dto.attachments?.getOrNull(0)?.photo?.sizes?.last()?.url.orEmpty()
    }

    private fun getStatistics(dto: FeedPostDto): List<StatisticItem> {
        return buildList {
            this += StatisticItem(
                type = StatisticType.VIEWS,
                count = dto.views?.count ?: 0
            )
            this += StatisticItem(
                type = StatisticType.LIKES,
                count = dto.likes?.count ?: 0
            )

            this += StatisticItem(
                type = StatisticType.COMMENTS,
                count = dto.comments?.count ?: 0
            )
            this += StatisticItem(
                type = StatisticType.REPOSTS,
                count = dto.reposts?.count ?: 0
            )
        }
    }
}