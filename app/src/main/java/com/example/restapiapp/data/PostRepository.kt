package com.example.restapiapp.data

import com.example.restapiapp.data.api.RemoteDataSource
import com.example.restapiapp.data.api.models.PostResponse
import com.example.restapiapp.utils.BaseApiResponse
import com.example.restapiapp.utils.NetworkResult
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse(){

    suspend fun getAllPosts(): NetworkResult<List<PostResponse>>{
        return safeApiCall { remoteDataSource.getAllPosts() }
    }
    suspend fun postPost(body: PostResponse): NetworkResult<PostResponse>{
        return safeApiCall { remoteDataSource.postPosts(body = body) }
    }
    suspend fun putPost(id: String): NetworkResult<PostResponse>{
        return safeApiCall { remoteDataSource.putPosts(id = id) }
    }
     suspend fun patchPost(id: String): NetworkResult<PostResponse>{
        return safeApiCall { remoteDataSource.patchPosts(id = id) }
    }
     suspend fun deletePost(id: String): NetworkResult<PostResponse>{
        return safeApiCall { remoteDataSource.deletePosts(id = id) }
    }

}