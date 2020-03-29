package example.com.android.mvvmtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import example.com.android.mvvmtest.Factory.InfoFactory
import example.com.android.mvvmtest.Repository.InfoRepository
import example.com.android.mvvmtest.ViewModel.InfoViewModel
import example.com.android.mvvmtest.data.UserData
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var infoViewModel: InfoViewModel
    private lateinit var infoFactory: InfoFactory
    private lateinit var infoRepository: InfoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMVVM()
        init()
    }

    private fun initMVVM() {
        infoRepository = InfoRepository()
        infoFactory = InfoFactory(infoRepository)
        infoViewModel = ViewModelProvider(this, infoFactory).get(InfoViewModel::class.java)
    }

    private fun init() {
        btnGetInfo.setOnClickListener {
            infoViewModel.callInfo().observe(
                this, Observer { updateTextView(it) }
            )
        }
    }

    /**
     * 更新文字
     */
    private fun updateTextView(users: MutableList<UserData>) {
        val sb = StringBuilder()
        users.forEach {
            sb.append("user id: ${it.id}\nuser name: ${it.userName}\n\n") 
        }
        
        txvUser.text = sb.toString()
    }

}
