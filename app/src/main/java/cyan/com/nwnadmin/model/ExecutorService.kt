package cyan.com.nwnadmin.model

import io.reactivex.SingleTransformer

interface ExecutorService {
    fun <T> singleThreadExecutor(): SingleTransformer<T, T>
}