package com.example.restapiapp.data.api

import com.example.restapiapp.data.api.models.PostResponse
import retrofit2.Response
import retrofit2.http.*


interface PostService {

    @GET("/post")
    suspend fun getAllPost(): Response<List<PostResponse>>

    @POST("/post{id}")
    suspend fun postPost(@Body body: PostResponse): Response<PostResponse>

    @PUT("post{id}")
    suspend fun putPost(@Path ("id")id: String):Response<PostResponse>

    @PATCH("/post/{id}")
    suspend fun patchPost(@Path("id")id: String):Response<PostResponse>

    @DELETE("/post/{id}")
    suspend fun deletePost(@Path("id")id: String):Response<PostResponse>


}