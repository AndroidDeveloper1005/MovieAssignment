package com.example.movieassignment.ui.movie_detail

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.movieassignment.R
import com.example.movieassignment.databinding.FragmentMovieDetailBinding
import com.example.movieassignment.model.MovieDetail
import com.example.movieassignment.ui.adapter.MovieCastAdapter
import com.example.movieassignment.ui.adapter.MovieCrewAdapter
import com.example.movieassignment.ui.adapter.SimilarMovieAdapter
import com.example.movieassignment.ui.home_page.HomeViewModel
import com.example.movieassignment.utilities.loadImage
import com.example.movieassignment.utilities.toast

class MovieDetailFragment : Fragment(){

    lateinit var mBinding : FragmentMovieDetailBinding

    lateinit var mViewModel : MovieDetailViewModel

    lateinit var mHomeViewModel: HomeViewModel

    var castAdapter : MovieCastAdapter ?= null

    var crewAdapter : MovieCrewAdapter?= null

    var similarMoviesAdapter : SimilarMovieAdapter?= null

    var genres = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)
        mViewModel = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
        mHomeViewModel = activity!!.let { ViewModelProviders.of(it).get(HomeViewModel::class.java) }

        mBinding.movieDetailViewModel = mViewModel
        mBinding.executePendingBindings()
        return mBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.toast("selected movie id: "+mHomeViewModel.selectedMovieId)

        initUI()

        fetchMovieDetails()

        fetchMovieCredits()

        fetchSimilarMovies()

        setHasOptionsMenu(false)
    }

    override fun onStop() {
        mViewModel.resetView()
        super.onStop()
    }

    private fun fetchSimilarMovies() {
        mViewModel.getSimilarMovies(mHomeViewModel.selectedMovieId)
        mViewModel.mutableSimilarMovieList.observe(this, Observer {
            if (!it.isNullOrEmpty()){
                it.forEach {
                    it.isFromSimilarMovies=true
                }
                similarMoviesAdapter?.apply {
                    setSimilarMoviesData(it)
                }
            }
        })
    }

    private fun fetchMovieCredits() {
        mViewModel.getMovieCredits(mHomeViewModel.selectedMovieId)
        mViewModel.mutableMovieCreditData.observe(this, Observer {
            if (it != null) {
                if(!it.cast.isNullOrEmpty() ){
                    castAdapter?.apply {
                        setMovieCastData(it.cast!!)
                    }
                }
                if(!it.crew.isNullOrEmpty() ){
                    crewAdapter?.apply {
                        setMovieCrewData(it.crew!!)
                    }
                }
            }
        })
    }

    private fun fetchMovieDetails() {

        mViewModel.getMovieDetails(mHomeViewModel.selectedMovieId)
        mViewModel.mutableMovieDetails.observe(this, Observer {
            if (it != null){
                updateView(it)
            }
        })
    }

    private fun initUI() {
        castAdapter = MovieCastAdapter()
        mBinding.rvCast.adapter = castAdapter

        crewAdapter = MovieCrewAdapter()
        mBinding.rvCrew.adapter = crewAdapter

        similarMoviesAdapter = SimilarMovieAdapter()
        mBinding.rvSimilarMovies.adapter = similarMoviesAdapter
    }

    private fun updateView(it: MovieDetail) {
        mBinding.apply {
            tvMovieTitle.text = it.title
            tvReleaseDate.text = "Release Date: " + it.releaseDate
            tvLanguage.text = "Language: "+it.originalLanguage
            it.genres?.forEach {
                genres = it.name?.capitalize().toString() + ", " + genres
            }

            tvGenre.text = "Generes: "+genres.dropLast(2)
            tvSynopsysText.text = "Synopsys: "+it.overview
        }
        it.posterPath?.let { it1 -> mBinding.ivVideo.loadImage(it1) }
    }
}
