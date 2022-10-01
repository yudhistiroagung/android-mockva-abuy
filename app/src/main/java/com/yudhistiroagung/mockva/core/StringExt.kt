package com.yudhistiroagung.mockva.core

const val ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"

fun String.toBase64(): String {
    var result = StringBuilder()

    val bytes = this.toByteArray().toTypedArray()

    var nHighBits = 0
    var nLowBits = 0

    var code = 0
    var prevItRemainingBits = 0

    for (byte in bytes) {

        nHighBits = 6 - nLowBits
        nLowBits = 8 - nHighBits

        code = byte.toInt() shr (8 - nHighBits)
        code = (prevItRemainingBits shl nHighBits) or code
        prevItRemainingBits = byte.toInt() and ((0xFF shl nLowBits) xor 0xFF)

        result.append(ALPHABETS[code])

        if (nLowBits == 6) {
            result.append(ALPHABETS[prevItRemainingBits])
            prevItRemainingBits = 0
            nLowBits = 0
        }
    }

    if (prevItRemainingBits != 0) {
        val lastCode = prevItRemainingBits shl (6 - nLowBits)
        result.append(ALPHABETS[lastCode])
    }

    var padding = 3 - bytes.size % 3

    if (padding < 3) {
        while (padding-- > 0) result.append("=")
    }

    return result.toString()
}