package com.manga.mebaad.mangarelease.base.usecase

import io.reactivex.Observable

/**
 * Default UseCase which return a io.reactivex.Observable
 * Parameters must be passed in constructor as 'private val'
 */
interface ObservableUseCase<R> {
    /**
     * Execute the UseCase, but if it is not implemented, return a io.reactivex.Observable.error
     */
    fun execute(): Observable<R> = Observable.error(Throwable("Not Implemented"))
}