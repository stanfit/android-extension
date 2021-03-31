package com.stanfit.android.extension.result

/**
 * Result pattern class. Respected [kotlin.Result] class.
 */
sealed class Result<T> {

    /**
     * Success flag
     */
    val isSuccess: Boolean get() = this is Success

    /**
     * Failure flag
     */
    val isFailure: Boolean get() = this is Failure

    /**
     * Get [T] if result is [Success].
     *
     * @return [T]
     */
    open val data: T? = null

    /**
     * Get [Throwable] if result is [Failure].
     *
     * @return value
     */
    open val throwable: Throwable? = null

    /**
     * Success data class.
     *
     * @param data data
     */
    data class Success<T>(override val data: T) : Result<T>()

    /**
     * Failure data class.
     *
     * @param throwable [Throwable]
     */
    data class Failure<T>(override val throwable: Throwable) : Result<T>()

    /**
     * This is called if result is [Success].
     *
     * @param block block
     * @return Result
     */
    inline fun onSuccess(block: (value: T) -> Unit): Result<T> {
        if (this is Success) block(data)
        return this
    }

    /**
     * This is called if result is [Failure].
     *
     * @param block block
     * @return Result
     */
    inline fun onFailure(block: (throwable: Throwable) -> Unit): Result<T> {
        if (this is Failure) block(throwable)
        return this
    }

    companion object {

        /**
         * Create Success
         *
         * @param value Data
         * @return Result
         */
        @JvmStatic
        fun <T> success(value: T): Result<T> = Success(value)

        /**
         * Create Failure
         *
         * @param error Error
         * @return Result
         */
        @JvmStatic
        fun <T> failure(error: Throwable): Result<T> = Failure(error)
    }
}

/**
 * Calls the specified function [block] and returns its encapsulated result if invocation was successful,
 * catching and encapsulating any thrown exception as a failure.
 *
 * @param T value
 * @param block block
 * @return [Result]
 */
inline fun <T> result(block: () -> T): Result<T> {
    return try {
        Result.success(block())
    } catch (e: Throwable) {
        Result.failure(e)
    }
}
