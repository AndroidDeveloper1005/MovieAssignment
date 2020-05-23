package com.example.movieassignment.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieassignment.R
import com.example.movieassignment.databinding.FragmentHomeBinding
import com.example.movieassignment.ui.adapter.LatestMovieAdapter
import com.example.movieassignment.ui.home_page.HomeViewModel

class HomeFragment : Fragment(){

    lateinit var mHomeViewModel : HomeViewModel

    lateinit var mBinding : FragmentHomeBinding

    var latestMovieAdapter : LatestMovieAdapter ? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,  container, false)
        mHomeViewModel = activity!!.let { ViewModelProviders.of(it).get(HomeViewModel::class.java) }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        fetchLatestMovieDataOnline();
    }

    private fun initUi() {
        latestMovieAdapter = LatestMovieAdapter(mHomeViewModel)
        mBinding.rvLatestMovies.adapter = latestMovieAdapter
    }

    private fun fetchLatestMovieDataOnline() {
        mHomeViewModel.getLatestMovies()
        mHomeViewModel.latestMovieList.observe(this, Observer {
            if (it!=null && it.size>0){
                latestMovieAdapter?.setLatestMovieData(it)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
}