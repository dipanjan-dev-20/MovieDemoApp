package com.android.movieapp.data


import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("dates")
    var dates: Dates? = Dates(),
    @SerializedName("page")
    var page: Int? = 0,
    @SerializedName("results")
    var results: List<Movie>? = listOf(),
    @SerializedName("total_pages")
    var totalPages: Int? = 0,
    @SerializedName("total_results")
    var totalResults: Int? = 0
) {
    data class Dates(
        @SerializedName("maximum")
        var maximum: String? = "",
        @SerializedName("minimum")
        var minimum: String? = ""
    )

}