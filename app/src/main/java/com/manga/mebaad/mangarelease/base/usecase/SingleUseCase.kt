package com.manga.mebaad.mangarelease.base.usecase

import io.reactivex.Single

/**
 * Default UseCase which return a io.reactivex.Single
 * Parameters must be passed in constructor as 'private val'
 */
interface SingleUseCase<R> {
    /**
     * Execute the UseCase, but if it is not implemented, return a io.reactivex.Single.error
     */
    fun execute(): Single<R> = Single.error(Throwable("Not Implemented"))
}