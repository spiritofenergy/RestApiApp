package com.example.restapiapp.domain.usecases

import com.example.restapiapp.data.PostRepository
import javax.inject.Inject

class GetAllPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke() = postRepository.getAllPosts()
}