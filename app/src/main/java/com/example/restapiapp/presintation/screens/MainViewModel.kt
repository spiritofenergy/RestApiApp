package com.example.restapiapp.presintation.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapiapp.data.api.models.PostResponse
import com.example.restapiapp.domain.usecases.*
import com.example.restapiapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val deletePostUseCase: DeletePostUseCase,
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val patchPostUseCase: PatchPostUseCase,
    private val postPostUseCase: PostPostUseCase,
    private val putPostUseCase: PutPostUseCase
) : ViewModel(){
    private val _allPostsResponse = MutableLiveData<NetworkResult<List<PostResponse>>>()
    val allPostResponse :LiveData<NetworkResult<List<PostResponse>>>
    get() = _allPostsResponse

    init {
        getPagingAllPost()
        //getAllPosts()
    }
    fun getPagingAllPost() = getAllPostsUseCase.invokePaging()

  /*  private fun getAllPosts() {
        viewModelScope.launch {
            getAllPostsUseCase.invoke().let {
                _allPostsResponse.value = it
            }
        }
    }*/
    fun postPosts(){
        viewModelScope.launch {
            postPostUseCase.invoke(body = PostResponse(title = "Test title", body = "Test body"))
            Log.d("check", "data postPosts: ?")

        }
    }
    fun putPost(){
        viewModelScope.launch{
            putPostUseCase.invoke(id = "1", body = PostResponse(title = "Test title", body = "Test body")).let {
                Log.d("check", "data putPost: ${it.data}")
            }
        }
    }
    fun patchPost(){
        viewModelScope.launch{
            patchPostUseCase.invoke(id = "1", body = PostResponse(title = "Test title", body = "Test body")).let {
                Log.d("check", "data patchPost: ${it.data}")
            }
        }
    }
    fun deletePost(){
        viewModelScope.launch{
            deletePostUseCase.invoke(id = "1").let {
                Log.d("check", "data deletePost: ${it.data}")
            }
        }
    }
}