package com.pustovit.vkclient.models.error

import java.lang.RuntimeException

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 20:40
 */
class VkError(
    val errorCode: Int,
    override val message: String
) : RuntimeException()