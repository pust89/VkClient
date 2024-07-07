package com.pustovit.vkclient.data_source_impl.local.auth


import android.content.SharedPreferences
import androidx.core.content.edit
import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource
import com.pustovit.vkclient.data_source_impl.local.auth.mapper.AuthModelMapper
import com.pustovit.vkclient.models.auth.VkAccessToken
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:13
 */
internal class AuthLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val mapper: AuthModelMapper
) : AuthLocalDataSource {

    override suspend fun getVkAccessToken(): VkAccessToken? {
        return sharedPreferences.getString(VK_ACCESS_TOKEN_LOCAL_KEY, "")
            .run(mapper::mapLocal)
            .run(mapper::mapDomain)
    }

    override suspend fun saveVkAccessToken(token: VkAccessToken) {
        sharedPreferences.edit(true) {
            putString(
                VK_ACCESS_TOKEN_LOCAL_KEY,
                token.run(mapper::mapLocal)
                    .run(mapper::mapString)
            )
        }
    }

    override suspend fun clearVkAccessToken() {
        sharedPreferences.edit(true) {
            this.remove(VK_ACCESS_TOKEN_LOCAL_KEY)
        }
    }

    private companion object {
        const val VK_ACCESS_TOKEN_LOCAL_KEY = "VK_ACCESS_TOKEN_LOCAL_KEY"
    }
}