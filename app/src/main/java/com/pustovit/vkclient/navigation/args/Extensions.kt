package com.pustovit.vkclient.navigation.args

import android.os.Bundle
import java.util.Base64

internal fun String.encode(): String {
    return Base64.getEncoder().encodeToString(this.toByteArray())
}

internal fun String.decode(): String {
    return String(Base64.getDecoder().decode(this))
}

internal fun StringBuilder.encodeAndAppend(value: String): StringBuilder {
    return append(value.encode())
}

internal fun Bundle.getDecodedString(key: String): String? {
    return this.getString(key)?.decode()
}

internal fun Bundle.getDecodedString(key: String, defaultValue: String): String {
    return getDecodedString(key) ?: defaultValue
}
