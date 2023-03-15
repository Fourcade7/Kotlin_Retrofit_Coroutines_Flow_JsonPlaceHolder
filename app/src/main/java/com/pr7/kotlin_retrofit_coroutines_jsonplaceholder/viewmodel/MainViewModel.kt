package com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.Post
import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.PostsPhotoItem
import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.RetrofitInstance
import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.model.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainViewModel constructor(
    val postRepository: PostRepository= PostRepository()
):ViewModel() {


    suspend  fun getAllpostsData(): Flow<ArrayList<Post>> {
        val myflow= flow<ArrayList<Post>> {
            emit(postRepository.getAllposts())
        }.flowOn(Dispatchers.IO)
        return myflow
    }
    suspend fun getAllpostsData2(): Flow<ArrayList<Post>> =flow {
        emit(postRepository.getAllposts())
    }

    fun getAllImages():Flow<ArrayList<PostsPhotoItem>>{
        val myphotos= flow {
            emit(postRepository.getAllImages())
        }
        return myphotos
    }



}