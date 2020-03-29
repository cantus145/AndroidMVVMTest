package example.com.android.mvvmtest.Repository

import example.com.android.mvvmtest.data.UserData

interface OnTaskFinish {
    
    fun onFinish(data: MutableList<UserData>)
    
}