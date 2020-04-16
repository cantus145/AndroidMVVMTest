package example.com.android.mvvmtest.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import example.com.android.mvvmtest.Repository.InfoRepository
import example.com.android.mvvmtest.Repository.OnTaskFinish
import example.com.android.mvvmtest.data.UserData

class InfoViewModel(var infoRepository: InfoRepository) : ViewModel() {

    /**
     * 可變LiveData  
     */ 
    private var userInfoLiveData = MutableLiveData<MutableList<UserData>>()
    
    fun callInfo(): LiveData<MutableList<UserData>> {
        infoRepository.loadInfo(object : OnTaskFinish {
            override fun onFinish(data: MutableList<UserData>) {
                userInfoLiveData.postValue(data)
            }
        })
        return userInfoLiveData
    }
    
}