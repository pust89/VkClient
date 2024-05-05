package com.pustovit.vkclient.screens.navigation

import android.os.Bundle
import java.util.Base64

fun String.encode(): String {
    return Base64.getEncoder().encodeToString(this.toByteArray())
}

fun String.decode(): String {
    return String(Base64.getDecoder().decode(this))
}

fun StringBuilder.encodeAndAppend(value: String): StringBuilder {
    return append(value.encode())
}

fun Bundle.getDecodedString(key: String): String? {
    return this.getString(key)?.decode()
}

fun Bundle.getDecodedString(key: String, defaultValue: String): String {
    return getDecodedString(key) ?: defaultValue
}
