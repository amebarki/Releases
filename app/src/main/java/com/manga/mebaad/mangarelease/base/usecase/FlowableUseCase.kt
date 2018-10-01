package com.manga.mebaad.mangarelease.base.usecase

import io.reactivex.Flowable

/**
 * Default UseCase which return a io.reactivex.Flowable
 * Parameters must be passed in constructor as 'private val'
 */
interface FlowableUseCase<R> {
    /**
     * Execute the UseCase, but if it is not implemented, return a io.reactivex.Flowable.error
     */
    fun execute(): Flowable<R> = Flowable.error(Throwable("Not Implemented"))
}