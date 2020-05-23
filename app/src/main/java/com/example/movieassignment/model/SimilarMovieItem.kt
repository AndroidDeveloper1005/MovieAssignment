package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SimilarMovieItem() : MovieDetailBaseModel(), Parcelable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("video")
    @Expose
    var video: Boolean? = null

    @SerializedName("vote_count")
    @Expose
    var voteCount: Int? = null

    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double? = null

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null

    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null

    @SerializedName("genre_ids")
    @Expose
    var genreIds: List<Int>? = null

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null

    @SerializedName("adult")
    @Expose
    var adult: Boolean? = null

    @SerializedName("overview")
    @Expose
    var overview: String? = null

//    @SerializedName("poster_path")
//    @Expose
//    var posterPath: String? = null

    @SerializedName("popularity")
    @Expose
    var popularity: Double? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        video = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        voteCount = parcel.readValue(Int::class.java.classLoader) as? Int
        voteAverage = parcel.readValue(Double::class.java.classLoader) as? Double
        title = parcel.readString()
        releaseDate = parcel.readString()
        originalLanguage = parcel.readString()
        originalTitle = parcel.readString()
        backdropPath = parcel.readString()
        adult = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        overview = parcel.readString()
        posterPath = parcel.readString()
        popularity = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(video)
        parcel.writeValue(voteCount)
        parcel.writeValue(voteAverage)
        parcel.writeString(title)
        parcel.writeString(releaseDate)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(backdropPath)
        parcel.writeValue(adult)
        parcel.writeString(overview)
        parcel.writeString(posterPath)
        parcel.writeValue(popularity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SimilarMovieItem> {
        override fun createFromParcel(parcel: Parcel): SimilarMovieItem {
            return SimilarMovieItem(parcel)
        }

        override fun newArray(size: Int): Array<SimilarMovieItem?> {
            return arrayOfNulls(size)
        }
    }

}