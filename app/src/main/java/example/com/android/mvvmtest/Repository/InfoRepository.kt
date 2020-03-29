package example.com.android.mvvmtest.Repository

import example.com.android.mvvmtest.data.UserData
import java.util.concurrent.Executors

var idx = 1
const val max = 250

class InfoRepository {
    fun loadInfo(task: OnTaskFinish) {
        Executors.newSingleThreadExecutor().submit {
            if (idx >= max) {
                idx = 1
            }

            while (idx <= max) {
                Thread.sleep(10)
                task.onFinish(generateUsers())
                idx++
            }
        }
    }

    private fun generateUsers(): MutableList<UserData> {
        val users: MutableList<UserData> = arrayListOf()
        for (i in 1..(3..10).random()) run {
            val user = UserData()
            user.id = (1..9999).random()
            user.userName = genName()
            users.add(user)
        }
        return users
    }

    /**
     * Generate random name
     * https://stackoverflow.com/questions/46943860/idiomatic-way-to-generate-a-random-alphanumeric-string-in-kotlin
     */
    private fun genName(): String {
        val allowedFirstChar = "ABCDEFGHIJKLMNOPQRSTUVWXTZ"
        val allowedChars = "abcdefghiklmnopqrstuvwxyz"

        val firstChar = allowedFirstChar.random().toString()
        val tailChars =
            (1..(2..10).random()).map { allowedChars.random() }.joinToString("")
        return firstChar + tailChars
    }
}
