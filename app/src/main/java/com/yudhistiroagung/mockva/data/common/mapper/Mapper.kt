package com.yudhistiroagung.mockva.data.common.mapper

/**
 * Data mapper interface
 */
interface Mapper<I, O> {

    fun map(input: I): O
}