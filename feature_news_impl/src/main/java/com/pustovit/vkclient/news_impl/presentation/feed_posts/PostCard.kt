package com.pustovit.vkclient.news_impl.presentation.feed_posts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pustovit.vkclient.models.post.Attachment
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.ui_common.CORE_R_DRAWABLE


@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
    onLikeClickListener: (FeedPost) -> Unit,
    onShareClickListener: (FeedPost) -> Unit,
    onViewsClickListener: (FeedPost) -> Unit,
    onCommentClickListener: (FeedPost) -> Unit,
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PostHeader(feedPost)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = feedPost.contentText, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            when (val attachment = feedPost.attachment) {
                is Attachment.Photo -> PhotoAttachment(attachment)
                is Attachment.Video -> VideoAttachment(attachment)
                else -> Unit
            }

            Spacer(modifier = Modifier.height(8.dp))
            Statistics(
                feedPost = feedPost,
                onLikeClickListener = onLikeClickListener,
                onCommentClickListener = onCommentClickListener,
                onShareClickListener = onShareClickListener,
                onViewsClickListener = onViewsClickListener
            )
        }
    }
}
@Composable
private fun PhotoAttachment(photo: Attachment.Photo){
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        model = photo.imageUrl,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun VideoAttachment(video: Attachment.Video){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        text = "Some video..."
    )
}

@Composable
private fun PostHeader(feedPost: FeedPost) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            model = feedPost.communityImageUrl,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = feedPost.communityName,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = feedPost.publicationDate,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
        )
    }
}

@Composable
private fun Statistics(
    feedPost: FeedPost,
    onLikeClickListener: (FeedPost) -> Unit,
    onShareClickListener: (FeedPost) -> Unit,
    onViewsClickListener: (FeedPost) -> Unit,
    onCommentClickListener: (FeedPost) -> Unit,
) {
    Row {
        Row(
            modifier = Modifier.weight(1f)
        ) {

            IconWithText(
                iconResId = CORE_R_DRAWABLE.ic_views_count,
                text = feedPost.viewsCount.displayValue,
                onItemClickListener = {
                    onViewsClickListener(feedPost)
                }
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconWithText(
                iconResId = CORE_R_DRAWABLE.ic_share,
                text = feedPost.repostsCount.displayValue,
                onItemClickListener = {
                    onShareClickListener(feedPost)
                }
            )
            IconWithText(
                iconResId = CORE_R_DRAWABLE.ic_comment,
                text = feedPost.commentsCount.displayValue,
                onItemClickListener = {
                    onCommentClickListener(feedPost)
                }
            )

            val likes = feedPost.likes
            val likeIcon = if (likes.isLiked) {
                CORE_R_DRAWABLE.ic_liked
            } else {
                CORE_R_DRAWABLE.ic_like
            }

            val iconTint = if (likes.isLiked) {
                Color.Red
            } else {
                LocalContentColor.current
            }

            IconWithText(
                iconResId = likeIcon,
                text = likes.count.displayValue,
                iconTint = iconTint,
                onItemClickListener = {
                    onLikeClickListener(feedPost)
                }
            )
        }
    }
}

@Composable
private fun IconWithText(
    iconResId: Int,
    text: String,
    onItemClickListener: () -> Unit,
    iconTint: Color = LocalContentColor.current
) {
    Row(
        modifier = Modifier.clickable {
            onItemClickListener()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = iconTint,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text, style = MaterialTheme.typography.labelMedium
        )
    }
}

private val Int.displayValue: String
    get() = if (this > 100_000) {
        String.format("%sK", (this / 1000))
    } else if (this > 1000) {
        String.format("%.1fK", (this / 1000f))
    } else {
        this.toString()
    }

