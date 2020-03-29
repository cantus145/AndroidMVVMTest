package example.com.android.mvvmtest.Repository

import example.com.android.mvvmtest.data.UserData
import java.util.concurrent.Executors

var idx = 1
const val max = 20
var bool = true
val userData = UserData()

class InfoRepository {
    fun loadInfo(task: OnTaskFinish) {
        Executors.newSingleThreadExecutor().submit {
            if (idx >= max) {
                idx = 1
            }

            while (idx <= max) {
                updateUser()
                Thread.sleep(100)
                task.onFinish(userData)
                idx++
            }
        }
    }

    private fun updateUser() {
        var id: Int = 1
        var name = ""

        when (bool) {
            true -> {
                id = 123
                name = "Adin"
            }
            false -> {
                id = 456
                name = "Sue"
            }
        }

        bool = !bool

        userData.id = id
        userData.userName = name
    }
}
