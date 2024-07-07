package com.pustovit.vkclient.data_source_impl.local.auth.mapper

import com.google.gson.Gson
import com.pustovit.vkclient.data_source_impl.local.auth.model.VKIDUserLocal
import com.pustovit.vkclient.data_source_impl.local.auth.model.VkAccessTokenLocal
import com.pustovit.vkclient.models.auth.VKIDUser
import com.pustovit.vkclient.models.auth.VkAccessToken
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 09.04.2024
 * Time: 21:46
 */
class AuthModelMapper @Inject constructor(private val gson: Gson) {

    internal fun mapString(localModel: VkAccessTokenLocal?): String =
        localModel?.run {
            gson.toJson(this)
        }.orEmpty()

    internal fun mapLocal(jsonString: String?): VkAccessTokenLocal? =
        takeIf { jsonString?.isNotEmpty() == true }?.let {
            gson.fromJson(jsonString, VkAccessTokenLocal::class.java)
        }

    internal fun mapLocal(domainModel: VkAccessToken?): VkAccessTokenLocal? = domainModel?.run {
        VkAccessTokenLocal(
            token = token,
            userID = userID,
            expireTime = expireTime,
            userData = VKIDUserLocal(
                firstName = userData.firstName,
                lastName = userData.lastName,
                phone = userData.phone,
                photo50 = userData.photo50,
                photo100 = userData.photo100,
                photo200 = userData.photo200,
                email = userData.email
            )
        )
    }

    internal fun mapDomain(localModel: VkAccessTokenLocal?): VkAccessToken? = localModel?.run {
        VkAccessToken(
            token = token,
            userID = userID,
            expireTime = expireTime,
            userData = VKIDUser(
                firstName = userData.firstName.orEmpty(),
                lastName = userData.lastName.orEmpty(),
                phone = userData.phone,
                photo50 = userData.photo50,
                photo100 = userData.photo100,
                photo200 = userData.photo200,
                email = userData.email
            )
        )
    }
}