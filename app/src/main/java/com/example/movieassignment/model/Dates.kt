package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

class Dates() : Parcelable {
    @SerializedName("maximum")
    @Expose
    var maximum: String?=""

    @SerializedName("minimum")
    @Expose
    var minimum: String?=""

    constructor(parcel: Parcel) : this() {
        maximum = parcel.readString()
        minimum = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(maximum)
        parcel.writeString(minimum)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dates> {
        override fun createFromParcel(parcel: Parcel): Dates {
            return Dates(parcel)
        }

        override fun newArray(size: Int): Array<Dates?> {
            return arrayOfNulls(size)
        }
    }
}