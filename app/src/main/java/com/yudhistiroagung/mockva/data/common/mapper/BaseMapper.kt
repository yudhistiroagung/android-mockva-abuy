package com.yudhistiroagung.mockva.data.common.mapper

abstract class BaseMapper<I, O> : Mapper<I, O> {

    fun apply(item: I): O {
        return map(item)
    }

    fun apply(list: List<I>?): List<O> {
        return list?.mapNotNull { apply(it) }.orEmpty()
    }
}