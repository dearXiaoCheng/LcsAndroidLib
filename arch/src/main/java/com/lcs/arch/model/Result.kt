package com.lcs.arch.model

/**
 * @ClassName: Result
 * @Author: 刘春爽
 * @Date: 21-3-7 下午10:22
 * @Description: 响应过程与结果的密封类
 * 以及过程与结果的扩展函数
 */
sealed class Result<out T : Any> {

    /**
     * 请求成功
     * @param result 响应数据
     */
    data class Success<out T : Any>(val result: T) : Result<T>()

    /**
     * 请求失败
     * @param code 状态码
     * @param exception 异常
     */
    data class Error(val code: Int, val exception: Throwable? = null) : Result<Nothing>()

    /**
     * 请求中
     */
    object Loading : Result<Nothing>()


    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$result]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

inline fun <reified T : Any> Result<T>.doLoad(loading: () -> Unit) {
    if (this is Result.Loading) {
        loading.invoke()
    }
}

inline fun <reified T : Any> Result<T>.doSucceed(success: (T) -> Unit) {
    if (this is Result.Success) {
        success(this.result)
    }
}

inline fun <reified T : Any> Result<T>.doFail(failure: (code: Int, t: Throwable?) -> Unit) {
    if (this is Result.Error) {
        failure(this.code, this.exception)
    }
}

