package com.pustovit.vkclient.data_source_impl.remote.news.mapper

import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostDto
import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostContentDto
import com.pustovit.vkclient.data_source_impl.remote.news.model.GroupDto
import com.pustovit.vkclient.models.post.Attachment
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.Page
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

    fun map(dto: FeedPostContentDto?): Page<FeedPost> {

        val resultList = mutableListOf<FeedPost>()
        val posts = dto?.items.orEmpty()
        val groups = dto?.groups.orEmpty()

        for (i in posts.indices) {
            val feedPostDto = posts[i]

            val groupDto = groups.find { groupDto ->
                groupDto.id == feedPostDto.sourceId?.absoluteValue
            } ?: continue

            map(feedPostDto, groupDto)?.let(resultList::add)
        }

        return Page(
            items = resultList,
            nextFrom = dto?.nextFrom
        )
    }

    private fun map(dto: FeedPostDto, group: GroupDto): FeedPost? {

        return FeedPost(
            id = dto.id ?: return null,
            type = dto.type.orEmpty(),
            communityName = group.name.orEmpty(),
            communityImageUrl = group.photo200.orEmpty(),
            ownerId = dto.ownerId ?: 0,
            publicationDate = getPublicationDate(dto),
            contentText = dto.text.orEmpty(),
            attachment = getAttachment(dto),
            viewsCount = dto.views?.count ?: 0,
            repostsCount = dto.reposts?.count ?: 0,
            commentsCount = dto.comments?.count ?: 0,
            likes = getLikes(dto),
        )
    }

    private fun getAttachment(dto: FeedPostDto): Attachment? {
        val firstAttachment = dto.attachments?.getOrNull(0) ?: return null
        return when (firstAttachment.type) {
            "photo" -> Attachment.Photo(
                id = firstAttachment.photo?.id ?: 0,
                ownerId = firstAttachment.photo?.ownerId ?: 0,
                imageUrl = firstAttachment.photo?.sizes?.last()?.url.orEmpty()
            )

            "video" -> Attachment.Video(
                id = firstAttachment.video?.id ?: 0,
                ownerId = firstAttachment.video?.ownerId ?: 0,
            )

            else -> null
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

    private fun getLikes(dto: FeedPostDto): FeedPost.Likes {
        return FeedPost.Likes(
            count = dto.likes?.count ?: 0,
            isLiked = dto.likes?.userLikes == 1
        )
    }
}