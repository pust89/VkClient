package com.pustovit.vkclient.models.post


data class FeedPost(
    val id: Int = 0,
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatarUrl: String = "https://placehold.co/600x400.png",
    val contentText: String = "Lo//?123-!\rem ipsum dolor sit amet, consectetur adipiscing elit.",
    val contentImageUrl: String = "https://placehold.co/600x400.png",
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 966),
        StatisticItem(type = StatisticType.SHARES, 7),
        StatisticItem(type = StatisticType.COMMENTS, 8),
        StatisticItem(type = StatisticType.LIKES, 27)
    )
)
