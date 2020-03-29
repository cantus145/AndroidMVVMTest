package example.com.android.mvvmtest

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import example.com.android.mvvmtest.Factory.InfoFactory
import example.com.android.mvvmtest.Repository.InfoRepository
import example.com.android.mvvmtest.ViewModel.InfoViewModel
import kotlinx.android.synthetic.main.activity_main.*

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

    private fun init() {
        btnGetInfo.setOnClickListener {
            txvUser.text = ""
            
            infoViewModel.callInfo().observe(this, Observer {
                val str = "user id: ${it.id}\n\nuser name: ${it.userName}"
                txvUser.text = str
            })
        }
    }

    private fun initMVVM() {
        infoRepository = InfoRepository()
        infoFactory = InfoFactory(infoRepository)
        infoViewModel = ViewModelProvider(this, infoFactory).get(InfoViewModel::class.java)
    }
}
