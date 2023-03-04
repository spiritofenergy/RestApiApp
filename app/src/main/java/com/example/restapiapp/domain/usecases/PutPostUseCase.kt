package com.example.restapiapp.domain.usecases

import com.example.restapiapp.data.PostRepository
import javax.inject.Inject

class PutPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(id: String) = postRepository.putPost(id = id)
}