package com.example.restapiapp.domain.usecases

import com.example.restapiapp.data.PostRepository
import com.example.restapiapp.data.api.models.PostResponse
import javax.inject.Inject

class PostPost @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(body: PostResponse) = postRepository.postPost(body = body)
}