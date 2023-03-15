package com.pr7.kotlin_retrofit_coroutines_jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.RetrofitInstance.api
import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel=ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            Log.d("PR77777", "onCreate: started")
            mainViewModel.getAllpostsData().collect{
                Log.d("PR77777", "Flow size=${it.size}")
            }
            Log.d("PR77777", "onCreate: ended")

            Log.d("PR77777", "onCreate: started")
            mainViewModel.getAllImages().collect{
                Log.d("PR77777", "Flow Images size=${it.size}")
            }
            Log.d("PR77777", "onCreate: ended")

        }

//        GlobalScope.launch(Dispatchers.IO) {
//            Log.d("PR77777", "onCreate: started")
//            val response=RetrofitInstance.api.getAllPosts()
//            Log.d("PR77777", "onCreate: ${response.get(0).title}")
//            Log.d("PR77777", "onCreate: ended")
//
//        }
//
//        GlobalScope.launch(Dispatchers.IO) {
//            val response=api.getAllPhotos().awaitResponse()
//            if (response.isSuccessful){
//                Log.d("PR7", "onCreate: 200")
//                withContext(Dispatchers.Main){
//                    //use view ocde here...
//                }
//            }
//
//
//        }

    }


    suspend fun getAllpostsflow(){
        Log.d("PR77777", "onCreate: started")
//        mainViewModel.getAllpostsData().collect{
//            Log.d("PR77777", "Flow size=${it.size}")
//
//        }
        Log.d("PR77777", "onCreate: ended")
    }
    suspend fun getAllposts(){
        val resp=RetrofitInstance.api.getAllPosts()
    }



}