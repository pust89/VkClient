package com.pustovit.vkclient.ui_common.ext

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 23:25
 */

val <T>T.TAG: String where T : Any
    get() = this::class.qualifiedName ?: "TAG"