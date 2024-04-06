package com.pustovit.vkclient.domain_api.auth

import com.pustovit.vkclient.models.auth.VkAccessToken
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 19:12
 */
interface GetVkAccessTokenUseCase {
    operator fun invoke(): Flow<VkAccessToken?>

}
