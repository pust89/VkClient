package com.pustovit.vkclient.models.post

data class StatisticItem(
    val type: StatisticType,
    val count: Int = 0
)

enum class StatisticType {
    VIEWS, COMMENTS, REPOSTS, LIKES
}
