package com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.retrofit


import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.Post
import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.PostsPhotoItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    //https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    suspend fun getAllPosts():ArrayList<Post>
    //https://jsonplaceholder.typicode.com/photos
    @GET("photos")
    fun getAllPhotos():Call<ArrayList<PostsPhotoItem>>

    //https://jsonplaceholder.typicode.com/posts/1/comments
    @GET("/posts/{id}/comments")
    fun getCommentWithId(@Path("id") id:Int):Call<ArrayList<Post>>

    //https://jsonplaceholder.typicode.com/comments?postId=1
    @GET("comments")
    fun getCommentWithId2(@Query("postId") postId:Int):Call<ArrayList<Post>>

    //https://jsonplaceholder.typicode.com/posts
    @POST("posts")
    fun insertPosts(@Body post: Post):Call<Post>



}