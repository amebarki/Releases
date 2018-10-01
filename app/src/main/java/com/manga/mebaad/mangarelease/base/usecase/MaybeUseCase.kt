package com.manga.mebaad.mangarelease.base.usecase

import io.reactivex.Maybe

/**
 * Default UseCase which return a io.reactivex.Maybe
 * Parameters must be passed in constructor as 'private val'
 */
interface MaybeUseCase<R> {
    /**
     * Execute the UseCase, but if it is not implemented, return a io.reactivex.Maybe.error
     */
    fun execute(): Maybe<R> = Maybe.error<R>(Throwable("Not Implemented"))

}