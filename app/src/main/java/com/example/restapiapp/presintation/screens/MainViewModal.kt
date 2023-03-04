package com.example.restapiapp.presintation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.restapiapp.data.api.models.PostResponse
import com.example.restapiapp.domain.usecases.DeletePostUseCase
import com.example.restapiapp.domain.usecases.GetAllPostUseCase
import com.example.restapiapp.domain.usecases.PatchPostUseCase
import com.example.restapiapp.domain.usecases.PutPostUseCase
import com.example.restapiapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModal @Inject constructor(
    private val deletePostUseCase: DeletePostUseCase,
    private val getAllPostUseCase: GetAllPostUseCase,
    private val patchPostUseCase: PatchPostUseCase,
    private val postPostUseCase: PatchPostUseCase,
    private val putPostUseCase: PutPostUseCase
) {
    private val _allPostResponse = MutableLiveData<NetworkResult<List<PostResponse>>>()
    val allPostResponse :LiveData<NetworkResult<List<PostResponse>>>
    get() = _allPostResponse

    init {
       // getAllPosts()
    }

    private fun getAllPosts() {
        viewModelScope.launch {
            getAllPostsUseCase.invoke().let {
                _allPostsResponse.value = it
            }
        }
    }
}