package com.example.hiltgiphy.browseui.impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.hiltgiphy.browseui.impl.databinding.BrowseFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint(Fragment::class)
class BrowseFragment : Hilt_BrowseFragment() {
    private var _binding: BrowseFragmentBinding? = null
    private val binding get() = _binding!!

    //private val browseViewModel: BrowseViewModel by viewModels()

    @Inject
    lateinit var gifListAdapter: GifListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BrowseFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.browseRecyclerView
        recyclerView.setHasFixedSize(true)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setItemAnimator(null)
        recyclerView.setAdapter(gifListAdapter)

        // TODO: remove this and get a better way to layout the view holder.

        // TODO: remove this and get a better way to layout the view holder.
        recyclerView.viewTreeObserver
            .addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    recyclerView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    gifListAdapter.cardWidth = recyclerView.getWidth() / 2
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}