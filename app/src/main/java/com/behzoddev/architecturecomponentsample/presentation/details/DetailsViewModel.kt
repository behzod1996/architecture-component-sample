package com.behzoddev.architecturecomponentsample.presentation.details

import androidx.lifecycle.ViewModel
import com.behzoddev.architecturecomponentsample.repo.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: PostRepository ) : ViewModel() {
}