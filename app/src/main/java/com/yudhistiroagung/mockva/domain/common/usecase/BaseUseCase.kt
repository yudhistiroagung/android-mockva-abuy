package com.yudhistiroagung.mockva.domain.common.usecase

import com.yudhistiroagung.mockva.core.functional.Either
import com.yudhistiroagung.mockva.core.functional.either
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 *  A base or abstract class for Use Case (or interactor in terms of Clean Architecture).
 *  The abstraction is the base execution unit for different use cases and every one of them
 *  should implement this contract.
 *
 *  Each use case implementation which applies this contract will execute its job in a background
 *  thread by default and return [Either] result (which contains either the result or exception)
 */
abstract class BaseUseCase<out V, in P> where V : Any? {

    abstract suspend fun run(params: P): V

    operator fun invoke(
        context: CoroutineContext = Dispatchers.IO,
        scope: CoroutineScope,
        params: P,
        onResult: (Either<Throwable, V>) -> Unit = {}
    ) {
        val job = scope.async(context) { either { run(params) } }
        scope.launch(Dispatchers.Main) { onResult(job.await()) }
    }

    class None
}