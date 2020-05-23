package com.example.movieassignment.ui.home_page

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieassignment.R
import com.example.movieassignment.databinding.ActivityHomeBinding
import com.example.movieassignment.ui.HomeFragment
import com.example.movieassignment.ui.movie_detail.MovieDetailFragment


class HomePageActivity : AppCompatActivity(){

    lateinit var homeViewModel: HomeViewModel
    lateinit var mBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        setSupportActionBar(findViewById(R.id.home_toolbar))
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        addHomeFragment()
        mBinding.homeViewModel = homeViewModel

        homeViewModel.clickedMovieItem.observe(this, Observer {
            if (it!=null && it.id!=null){
                homeViewModel.selectedMovieId = it.id!!.toLong()
                openMovieDetailFragment()
                homeViewModel.clickedMovieItem.value = null
            }
        })
    }

    private fun openMovieDetailFragment() {
        val fragment = MovieDetailFragment()
        addOrReplaceFragment(fragment, true, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_view, menu)
        return true
    }

    private fun addHomeFragment() {
        val fragment = HomeFragment()
        addOrReplaceFragment(fragment, false,true)
    }

    private fun addOrReplaceFragment(fragment : Fragment, addToBackStack : Boolean, addFragment : Boolean ){

        val fragmentTag = (fragment as Any).javaClass.simpleName
        val fragmentTransaction = supportFragmentManager.beginTransaction();

        if (addFragment){
            fragmentTransaction.add(R.id.container, fragment, fragmentTag)
        }else{
            fragmentTransaction.replace(R.id.container, fragment, fragmentTag)
        }

        if (addToBackStack){
            fragmentTransaction.addToBackStack(fragmentTag)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

}