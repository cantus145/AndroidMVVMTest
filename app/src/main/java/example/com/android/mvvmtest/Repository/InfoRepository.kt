package example.com.android.mvvmtest.Repository

import example.com.android.mvvmtest.Util.MVVMUtil
import java.util.concurrent.Executors

var idx = 1
const val max = 5

/**
 * 
 */
class InfoRepository {
    fun loadInfo(task: OnTaskFinish) {
        Executors.newSingleThreadExecutor().submit {
            if (idx >= max) {
                idx = 1
            }

            while (idx <= max) {
                Thread.sleep(100)
                task.onFinish(MVVMUtil.generateUsers())
                idx++
            }
        }
    }
}
