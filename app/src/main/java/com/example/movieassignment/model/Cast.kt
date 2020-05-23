package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Cast() : MovieDetailBaseModel(), Parcelable {
    @SerializedName("cast_id")
    @Expose
    var castId: Int? = null

    @SerializedName("character")
    @Expose
    var character: String? = null

    @SerializedName("credit_id")
    @Expose
    var creditId: String? = null

    @SerializedName("gender")
    @Expose
    var gender: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null
//
//    @SerializedName("name")
//    @Expose
//    var name: String? = null

    @SerializedName("order")
    @Expose
    var order: Int? = null

//    @SerializedName("profile_path")
//    @Expose
//    var profilePath: String? = null

    constructor(parcel: Parcel) : this() {
        castId = parcel.readValue(Int::class.java.classLoader) as? Int
        character = parcel.readString()
        creditId = parcel.readString()
        gender = parcel.readValue(Int::class.java.classLoader) as? Int
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        name = parcel.readString()
        order = parcel.readValue(Int::class.java.classLoader) as? Int
        profilePath = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(castId)
        parcel.writeString(character)
        parcel.writeString(creditId)
        parcel.writeValue(gender)
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeValue(order)
        parcel.writeString(profilePath)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cast> {
        override fun createFromParcel(parcel: Parcel): Cast {
            return Cast(parcel)
        }

        override fun newArray(size: Int): Array<Cast?> {
            return arrayOfNulls(size)
        }
    }

}