package com.behzoddev.architecturecomponentsample.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.behzoddev.architecturecomponentsample.common.toastLong
import com.behzoddev.architecturecomponentsample.common.toastShort
import com.behzoddev.architecturecomponentsample.database.model.Post
import com.behzoddev.architecturecomponentsample.databinding.FragmentDashboardBinding
import com.behzoddev.architecturecomponentsample.presentation.adapter.PostAdapter
import com.behzoddev.architecturecomponentsample.presentation.base.BaseFragment
import com.behzoddev.architecturecomponentsample.utils.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentDashboardBinding>() {


    private val homeViewModel : HomeViewModel by viewModels()
    private val adapter = PostAdapter(this::onItemClicked)


    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        Log.d("Debug","initViewBinding from HomeFragment")
        return FragmentDashboardBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Debug","onViewCreated")
        initView()
        observePosts()
    }
    private fun observePosts() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.posts.collect { state ->
                    when (state) {
                        is State.Loading -> {
                            Log.d("Debug","State is Loading")
                            showLoading(true)
                        }
                        is State.Success<List<Post>> -> {
                            Log.d("Debug","State is Success")
                            if (state.data.isNotEmpty()) {
                                adapter.differ.submitList(state.data.toMutableList())
                                showLoading(false)
                            }
                        }
                        is State.Error -> {
                            toastShort(state.throwable)
                            showLoading(false)

                        }
                    }
                }
            }
        }
    }
    private fun initView() = with(binding){
        Log.d("Debug","initView from HomeFragment")
        postsRecyclerView.adapter = adapter
        srlDashboard.setOnRefreshListener { getPosts() }
    }
    private fun getPosts() = homeViewModel.getPosts()

    private fun showLoading(isLoading: Boolean) {
        binding.srlDashboard.isRefreshing = isLoading
    }
    private fun onItemClicked(post: Post, image: ImageView) {
        val postId = post.id ?: kotlin.run {
            toastLong("Unable to launch details")
            return
        }
    }
}