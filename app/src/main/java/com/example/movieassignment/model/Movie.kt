package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Movie() : Parcelable {

    @SerializedName("popularity")
    @Expose
    var popularity: Double? = null

    @SerializedName("vote_count")
    @Expose
    var voteCount: Int? = null

    @SerializedName("video")
    @Expose
    var video: Boolean? = null

    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = ""

    @SerializedName("id")
    @Expose
    var id: Int? = -1

    @SerializedName("adult")
    @Expose
    var adult: Boolean? = null

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: Any? = null

    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null

    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null

    @SerializedName("genre_ids")
    @Expose
    var genreIds: List<Int>? = null

    @SerializedName("title")
    @Expose
    var title: String? = ""

    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double? = null

    @SerializedName("overview")
    @Expose
    var overview: String? = ""

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = ""

    constructor(parcel: Parcel) : this() {
        popularity = parcel.readValue(Double::class.java.classLoader) as? Double
        voteCount = parcel.readValue(Int::class.java.classLoader) as? Int
        video = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        posterPath = parcel.readString()
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        adult = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        originalLanguage = parcel.readString()
        originalTitle = parcel.readString()
        title = parcel.readString()
        voteAverage = parcel.readValue(Double::class.java.classLoader) as? Double
        overview = parcel.readString()
        releaseDate = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(popularity)
        parcel.writeValue(voteCount)
        parcel.writeValue(video)
        parcel.writeString(posterPath)
        parcel.writeValue(id)
        parcel.writeValue(adult)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(title)
        parcel.writeValue(voteAverage)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}