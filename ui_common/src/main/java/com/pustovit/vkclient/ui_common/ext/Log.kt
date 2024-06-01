package com.pustovit.vkclient.ui_common.ext

import android.util.Log

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 18:51
 */

fun <T : Throwable> T.loggError(
    msg: String = this.message.orEmpty(),
    tag: String = "TAG",
) {
    Log.e(tag, msg, this)
}