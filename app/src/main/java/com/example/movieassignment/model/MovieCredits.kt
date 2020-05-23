package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class MovieCredits() : Parcelable {
    @SerializedName("id")
    @Expose
    var id: Int? = -1

    @SerializedName("cast")
    @Expose
    var cast: List<Cast>? = null

    @SerializedName("crew")
    @Expose
    var crew: List<Crew>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieCredits> {
        override fun createFromParcel(parcel: Parcel): MovieCredits {
            return MovieCredits(parcel)
        }

        override fun newArray(size: Int): Array<MovieCredits?> {
            return arrayOfNulls(size)
        }
    }

}