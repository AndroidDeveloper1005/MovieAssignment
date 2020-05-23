package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class LatestMovie() : Parcelable {
    @SerializedName("results")
    @Expose
    var results: List<Movie>? = null

    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null

    @SerializedName("dates")
    @Expose
    var dates: Dates? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    constructor(parcel: Parcel) : this() {
        page = parcel.readValue(Int::class.java.classLoader) as? Int
        totalResults = parcel.readValue(Int::class.java.classLoader) as? Int
        totalPages = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(page)
        parcel.writeValue(totalResults)
        parcel.writeValue(totalPages)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LatestMovie> {
        override fun createFromParcel(parcel: Parcel): LatestMovie {
            return LatestMovie(parcel)
        }

        override fun newArray(size: Int): Array<LatestMovie?> {
            return arrayOfNulls(size)
        }
    }

}