package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class MovieDetailBaseModel() : Parcelable {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("profile_path")
    @Expose
    var profilePath: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null

    var isFromSimilarMovies: Boolean = false

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        profilePath = parcel.readString()
        title = parcel.readString()
        posterPath = parcel.readString()
        isFromSimilarMovies = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(profilePath)
        parcel.writeString(title)
        parcel.writeString(posterPath)
        parcel.writeByte(if (isFromSimilarMovies) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieDetailBaseModel> {
        override fun createFromParcel(parcel: Parcel): MovieDetailBaseModel {
            return MovieDetailBaseModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieDetailBaseModel?> {
            return arrayOfNulls(size)
        }
    }
}