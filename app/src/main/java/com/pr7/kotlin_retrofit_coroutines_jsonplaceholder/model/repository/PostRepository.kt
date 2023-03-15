package com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.model.repository

import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.Post
import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.PostsPhotoItem
import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.await
import retrofit2.awaitResponse

class PostRepository {


    suspend fun getAllposts():ArrayList<Post>{
        val api=RetrofitInstance.api.getAllPosts()
        return api
    }

    suspend fun getAllImages():ArrayList<PostsPhotoItem>{
        val response=RetrofitInstance.api.getAllPhotos().await()
        return response
    }







}