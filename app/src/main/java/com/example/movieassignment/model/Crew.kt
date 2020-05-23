package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Crew() : MovieDetailBaseModel(), Parcelable {
    @SerializedName("credit_id")
    @Expose
    var creditId: String? = null

    @SerializedName("department")
    @Expose
    var department: String? = null

    @SerializedName("gender")
    @Expose
    var gender: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("job")
    @Expose
    var job: String? = null

//    @SerializedName("name")
//    @Expose
//    var name: String? = null

//    @SerializedName("profile_path")
//    @Expose
//    var profilePath: Any? = null

    constructor(parcel: Parcel) : this() {
        creditId = parcel.readString()
        department = parcel.readString()
        gender = parcel.readValue(Int::class.java.classLoader) as? Int
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        job = parcel.readString()
        name = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(creditId)
        parcel.writeString(department)
        parcel.writeValue(gender)
        parcel.writeValue(id)
        parcel.writeString(job)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Crew> {
        override fun createFromParcel(parcel: Parcel): Crew {
            return Crew(parcel)
        }

        override fun newArray(size: Int): Array<Crew?> {
            return arrayOfNulls(size)
        }
    }

}