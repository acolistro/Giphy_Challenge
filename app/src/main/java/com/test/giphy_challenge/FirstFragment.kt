package com.test.giphy_challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.giphy_challenge.databinding.FragmentFirstBinding
import com.test.giphy_challenge.domain.GifTrending
import com.test.giphy_challenge.viewadapter.TrendingGifAdapter
import com.test.giphy_challenge.viewmodel.TrendingGifsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var viewModelGifAdapter: TrendingGifAdapter? = null
    private val viewModel by viewModel<TrendingGifsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFirstBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel
        viewModelGifAdapter = TrendingGifAdapter()

        binding.root.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = viewModelGifAdapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()

    }

    private fun setUpObserver() {
        viewModel.trendinglist.observe(viewLifecycleOwner, Observer { trending ->
            trending?.apply {
                viewModelGifAdapter?.result = trending
            }
        })
    }
}