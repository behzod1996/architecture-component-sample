package com.behzoddev.architecturecomponentsample.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behzoddev.architecturecomponentsample.database.model.Post
import com.behzoddev.architecturecomponentsample.repo.PostRepository
import com.behzoddev.architecturecomponentsample.repo.PostRepositoryImpl
import com.behzoddev.architecturecomponentsample.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepository: PostRepositoryImpl) : ViewModel() {

    private val _posts: MutableStateFlow<State<List<Post>>> = MutableStateFlow(State.Loading())
    val posts : StateFlow<State<List<Post>>> = _posts

    fun getPosts() {
        viewModelScope.launch {
            Log.d("Debug","getPosts")
            postRepository.getAllPosts()
                .map { resource -> State.fromResourceToState(resource)}
                .collect { state -> _posts.value = state}
        }
    }
}