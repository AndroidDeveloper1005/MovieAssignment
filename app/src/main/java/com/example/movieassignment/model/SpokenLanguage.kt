package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SpokenLanguage() : Parcelable {
    @SerializedName("iso_639_1")
    @Expose
    var iso6391: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    constructor(parcel: Parcel) : this() {
        iso6391 = parcel.readString()
        name = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(iso6391)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpokenLanguage> {
        override fun createFromParcel(parcel: Parcel): SpokenLanguage {
            return SpokenLanguage(parcel)
        }

        override fun newArray(size: Int): Array<SpokenLanguage?> {
            return arrayOfNulls(size)
        }
    }

}