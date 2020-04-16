package example.com.android.mvvmtest.Util

import example.com.android.mvvmtest.data.UserData

object MVVMUtil {

    /**
     * 產生使用者
     */
    fun generateUsers(): MutableList<UserData> {
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
     * 產生隨機名字
     * Generate random name
     * https://stackoverflow.com/questions/46943860/idiomatic-way-to-generate-a-random-alphanumeric-string-in-kotlin
     */
    fun genName(): String {
        val allowedFirstChar = "ABCDEFGHIJKLMNOPQRSTUVWXTZ"
        val allowedChars = "abcdefghiklmnopqrstuvwxyz"

        val firstChar = allowedFirstChar.random().toString()
        val tailChars =
            (1..(2..10).random()).map { allowedChars.random() }.joinToString("")
        return firstChar + tailChars
    }
}