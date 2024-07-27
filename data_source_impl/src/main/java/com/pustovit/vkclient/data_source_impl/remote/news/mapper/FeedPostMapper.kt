package com.pustovit.vkclient.data_source_impl.remote.news.mapper

import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostDto
import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostContentDto
import com.pustovit.vkclient.data_source_impl.remote.news.model.GroupDto
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.StatisticItem
import com.pustovit.vkclient.models.post.StatisticType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import kotlin.math.absoluteValue

/**
 * Created by Pustovit V.V.
 * Date: 07.07.2024
 * Time: 18:08
 */
internal class FeedPostMapper @Inject constructor() {

    fun map(dto: FeedPostContentDto?): List<FeedPost> {
        val resultList = mutableListOf<FeedPost>()
        val posts = dto?.items.orEmpty()
        val groups = dto?.groups.orEmpty()

        for (i in posts.indices) {
            val feedPostDto = posts[i]

            val groupDto = groups.find { groupDto ->
                groupDto.id == feedPostDto.sourceId?.absoluteValue
            } ?: continue

            resultList += map(feedPostDto, groupDto)
        }

        return resultList
    }

    private fun map(dto: FeedPostDto, group: GroupDto): FeedPost {

        return FeedPost(
            id = dto.id ?: 0,
            type = dto.type.orEmpty(),
            communityName = group.name.orEmpty(),
            communityImageUrl = group.photo200.orEmpty(),
            publicationDate = getPublicationDate(dto),
            contentText = dto.text.orEmpty(),
            contentImageUrl = getContentPhotoUrl(dto),
            statistics = getStatistics(dto),
            isLiked = getIsLiked(dto)
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

    private fun getPublicationDate(dto: FeedPostDto): String {
        return dto.date?.let {
            try {
                val date = Date(it * 1000)
                return SimpleDateFormat("d MMMM yyyy, hh:mm", Locale.getDefault())
                    .format(date)
            } catch (e: Exception) {
                e.printStackTrace()
                ""
            }
        } ?: ""
    }

    private fun getIsLiked(dto: FeedPostDto): Boolean {
        return dto.likes?.userLikes == 1
    }
}