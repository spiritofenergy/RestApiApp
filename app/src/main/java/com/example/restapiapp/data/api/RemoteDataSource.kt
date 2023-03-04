package com.example.restapiapp.data.api

import com.example.restapiapp.data.api.models.PostResponse
import retrofit2.http.Body
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val postService: PostService) {

    suspend fun getAllPosts() = postService.getAllPost()
    suspend fun postPosts(body: PostResponse) = postService.postPost(body = body)
    suspend fun putPosts(id: String, body: PostResponse) = postService.putPost(id = id, body = body)
    suspend fun patchPosts(id: String, body: PostResponse) = postService.patchPost(id = id, body = body)
    suspend fun deletePosts(id: String) = postService.deletePost(id = id)
}