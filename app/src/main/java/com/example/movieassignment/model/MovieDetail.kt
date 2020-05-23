package com.example.movieassignment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class MovieDetail() : Parcelable {
    @SerializedName("adult")
    @Expose
    var adult: Boolean? = null

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null

    @SerializedName("belongs_to_collection")
    @Expose
    var belongsToCollection: Any? = null

    @SerializedName("budget")
    @Expose
    var budget: Int? = null

    @SerializedName("genres")
    @Expose
    var genres: List<Genre>? = null

    @SerializedName("homepage")
    @Expose
    var homepage: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("imdb_id")
    @Expose
    var imdbId: String? = null

    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null

    @SerializedName("original_title")
    @Expose
    var originalTitle: String? = null

    @SerializedName("overview")
    @Expose
    var overview: String? = null

    @SerializedName("popularity")
    @Expose
    var popularity: Double? = null

    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    @SerializedName("revenue")
    @Expose
    var revenue: Int? = null

    @SerializedName("runtime")
    @Expose
    var runtime: Int? = null

    @SerializedName("spoken_languages")
    @Expose
    var spokenLanguages: List<SpokenLanguage>? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("tagline")
    @Expose
    var tagline: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("video")
    @Expose
    var video: Boolean? = null

    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double? = null

    @SerializedName("vote_count")
    @Expose
    var voteCount: Int? = null

    constructor(parcel: Parcel) : this() {
        adult = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        backdropPath = parcel.readString()
        budget = parcel.readValue(Int::class.java.classLoader) as? Int
        homepage = parcel.readString()
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        imdbId = parcel.readString()
        originalLanguage = parcel.readString()
        originalTitle = parcel.readString()
        overview = parcel.readString()
        popularity = parcel.readValue(Double::class.java.classLoader) as? Double
        posterPath = parcel.readString()
        releaseDate = parcel.readString()
        revenue = parcel.readValue(Int::class.java.classLoader) as? Int
        runtime = parcel.readValue(Int::class.java.classLoader) as? Int
        spokenLanguages = parcel.createTypedArrayList(SpokenLanguage)
        status = parcel.readString()
        tagline = parcel.readString()
        title = parcel.readString()
        video = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        voteAverage = parcel.readValue(Double::class.java.classLoader) as? Double
        voteCount = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(adult)
        parcel.writeString(backdropPath)
        parcel.writeValue(budget)
        parcel.writeString(homepage)
        parcel.writeValue(id)
        parcel.writeString(imdbId)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(overview)
        parcel.writeValue(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(releaseDate)
        parcel.writeValue(revenue)
        parcel.writeValue(runtime)
        parcel.writeTypedList(spokenLanguages)
        parcel.writeString(status)
        parcel.writeString(tagline)
        parcel.writeString(title)
        parcel.writeValue(video)
        parcel.writeValue(voteAverage)
        parcel.writeValue(voteCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieDetail> {
        override fun createFromParcel(parcel: Parcel): MovieDetail {
            return MovieDetail(parcel)
        }

        override fun newArray(size: Int): Array<MovieDetail?> {
            return arrayOfNulls(size)
        }
    }

}