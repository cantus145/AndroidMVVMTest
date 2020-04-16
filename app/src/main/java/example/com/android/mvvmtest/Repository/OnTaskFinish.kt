package example.com.android.mvvmtest.Repository

import example.com.android.mvvmtest.data.UserData

/**
 * 介面
 * 
 */
interface OnTaskFinish {
    fun onFinish(data: MutableList<UserData>)
}