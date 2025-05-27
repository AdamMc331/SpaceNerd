package com.adammcneilly.spacenerd.data

sealed interface DataResult<out T> {
    data object Loading : DataResult<Nothing>

    data class Success<T>(
        val data: T,
    ) : DataResult<T>

    data class Error(
        val error: Exception,
    ) : DataResult<Nothing>

    fun <R> map(
        transform: (T) -> R,
    ): DataResult<R> {
        return when (this) {
            Loading -> {
                Loading
            }
            is Success -> {
                Success(transform(this.data))
            }
            is Error -> {
                Error(this.error)
            }
        }
    }
}
