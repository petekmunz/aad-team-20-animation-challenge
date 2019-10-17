package com.alcpluralsight.aad_team20.models

object Urls {
    val baseUrl = "https://api.themoviedb.org/3/movie/"
    const val api_key = "e13788ffa0683439b1413fe2bdb5e4ea"
    //    upcoming
    fun getUpcomingUrl(take: Int): String {
        return baseUrl +
                "upcoming?api_key=" + api_key
        "&language=en-US" + "&page=$take"
    }

    //    top_rated
    fun getTopRatedUrl(take: Int): String {
        return baseUrl +
                "top_rated?api_key=" + api_key
        "&language=en-US" + "&page=$take"
    }

    //    popular
    fun getPopularUrl(take: Int): String {
        return baseUrl +
                "popular?api_key=" + api_key
        "&language=en-US" + "&page=$take"
    }
    //    now_playing
    fun getNowPlayingrUrl(take: Int): String {
        return baseUrl +
                "now_playing?api_key=" + api_key
        "&language=en-US" + "&page=$take"
    }
    //    latest
    fun getLatestUrl(take: Int): String {
        return baseUrl +
                "latest?api_key=" + api_key
        "&language=en-US" + "&page=$take"
    }
}