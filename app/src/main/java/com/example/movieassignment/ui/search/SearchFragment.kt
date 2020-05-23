package com.example.movieassignment.ui.search

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.movieassignment.R
import com.example.movieassignment.databinding.FragmentSearchBinding
import com.example.movieassignment.ui.home_page.HomeViewModel

class SearchFragment : Fragment(){

    lateinit var mBinding : FragmentSearchBinding

    lateinit var mSearchViewModel : SearchViewModel

    lateinit var mHomeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)

        mSearchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        mHomeViewModel = activity!!.let { ViewModelProviders.of(it).get(HomeViewModel::class.java) }

        setHasOptionsMenu(true)

        return mBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        val manager =
            context!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val menuItem = menu.findItem(R.id.search)
        val searchView =
            menu.findItem(R.id.search).actionView as SearchView
        searchView.setMaxWidth(Int.MAX_VALUE)
        menuItem.expandActionView()
        searchView.clearFocus()

        menuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                return false
            }

            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                searchView.setIconified(true)
                return true
            }

        })

    }
}