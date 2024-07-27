package com.pustovit.vkclient.models.post

data class StatisticItem(
    val type: StatisticType,
    val count: Int = 0
) {

    val displayValue: String
        get() = if (count > 100_000) {
            String.format("%sK", (count / 1000))
        } else if (count > 1000) {
            String.format("%.1fK", (count / 1000f))
        } else {
            count.toString()
        }
}

enum class StatisticType {
    VIEWS, COMMENTS, REPOSTS, LIKES
}
