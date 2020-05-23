package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SimilarMovies() : Parcelable {
    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("results")
    @Expose
    var results: List<SimilarMovieItem>? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null

    constructor(parcel: Parcel) : this() {
        page = parcel.readValue(Int::class.java.classLoader) as? Int
        totalPages = parcel.readValue(Int::class.java.classLoader) as? Int
        totalResults = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(page)
        parcel.writeValue(totalPages)
        parcel.writeValue(totalResults)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SimilarMovies> {
        override fun createFromParcel(parcel: Parcel): SimilarMovies {
            return SimilarMovies(parcel)
        }

        override fun newArray(size: Int): Array<SimilarMovies?> {
            return arrayOfNulls(size)
        }
    }

}