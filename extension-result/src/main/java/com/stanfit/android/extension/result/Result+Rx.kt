package com.stanfit.android.extension.result

import androidx.annotation.CheckResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Convert to [Result]
 *
 * @return Flowable
 */
@CheckResult
fun <T> Flowable<T>.toResult(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread()
): Flowable<Result<T>> {
    return compose { item ->
        item
            .map {
                Result.success(it)
            }
            .onErrorReturn {
                Result.failure(it)
            }
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
    }
}

/**
 * Convert to [Result]
 *
 * @return Observable
 */
@CheckResult
fun <T> Observable<T>.toResult(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread()
): Observable<Result<T>> {
    return compose { item ->
        item
            .map {
                Result.success(it)
            }
            .onErrorReturn {
                Result.failure(it)
            }
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
    }
}

/**
 * Convert to [Result]
 *
 * @return Flowable
 */
@CheckResult
fun <T> Single<T>.toResult(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread()
): Flowable<Result<T>> {
    return toFlowable().toResult(subscribeOn, observeOn)
}

/**
 * Convert to [Result]
 *
 * @return Flowable
 */
@CheckResult
fun <T> Maybe<T>.toResult(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread()
): Flowable<Result<T>> {
    return toFlowable().toResult(subscribeOn, observeOn)
}

/**
 * Convert to [Result]
 *
 * @return Flowable
 */
@CheckResult
fun <T> Completable.toResult(
    subscribeOn: Scheduler = Schedulers.io(),
    observeOn: Scheduler = AndroidSchedulers.mainThread()
): Flowable<Result<T>> {
    return toFlowable<T>().toResult(subscribeOn, observeOn)
}
