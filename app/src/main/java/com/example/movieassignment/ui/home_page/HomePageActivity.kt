package com.example.movieassignment.ui.home_page

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieassignment.R
import com.example.movieassignment.databinding.ActivityHomeBinding
import com.example.movieassignment.ui.HomeFragment
import com.example.movieassignment.ui.movie_detail.MovieDetailFragment
import com.example.movieassignment.ui.search.SearchFragment
import com.example.movieassignment.utilities.toast


class HomePageActivity : AppCompatActivity(){

    lateinit var homeViewModel: HomeViewModel
    lateinit var mBinding : ActivityHomeBinding
    var menu: Menu?=null

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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (Intent.ACTION_SEARCH == intent?.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                applicationContext.toast(query)
                //todo: perform search
                //search item
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        this.menu = menu
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchView =
            menu.findItem(R.id.search).actionView as SearchView
        searchView.queryHint = getString(R.string.search_hint)

        if (showSearchView()) menu.findItem(R.id.search).setVisible(true)

        else menu.findItem(R.id.search).setVisible(false)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search -> {
                openSearchFragment()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openSearchFragment() {
        val fragment = SearchFragment()
        addOrReplaceFragment(fragment, true, false)
    }

    private fun showSearchView() : Boolean{
        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        if (fragment is HomeFragment){
            return true
        }else{
            return false
        }
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