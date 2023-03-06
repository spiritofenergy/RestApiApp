package com.example.restapiapp.data.api

import com.example.restapiapp.data.api.models.PostResponse
import retrofit2.Response
import retrofit2.http.*


interface PostService {

    @GET("/posts")
    suspend fun getAllPost(): Response<List<PostResponse>>
 @GET("/posts")
    suspend fun getPagingAllPost(@Query("_start")pager: Int, @Query("-limit")limit: Int): Response<List<PostResponse>>

    @POST("/posts")
    suspend fun postPost(@Body body: PostResponse): Response<PostResponse>

    @PUT("posts{id}")
    suspend fun putPost(@Path ("id")id: String, @Body body: PostResponse):Response<PostResponse>

    @PATCH("/posts/{id}")
    suspend fun patchPost(@Path("id")id: String, @Body body: PostResponse):Response<PostResponse>

    @DELETE("/posts/{id}")
    suspend fun deletePost(@Path("id")id: String):Response<PostResponse>


}