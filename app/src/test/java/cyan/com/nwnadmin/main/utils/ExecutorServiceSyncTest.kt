package cyan.com.nwnadmin.main.utils

import cyan.com.nwnadmin.model.ExecutorService
import io.reactivex.Scheduler
import io.reactivex.SingleTransformer

class ExecutorServiceSyncTest(private val scheduler: Scheduler) : ExecutorService {
    override fun <T> singleThreadExecutor(): SingleTransformer<T, T> {
        return SingleTransformer {
            it.subscribeOn(scheduler)
                .observeOn(scheduler)
        }
    }
}