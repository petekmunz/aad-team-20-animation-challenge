package com.alcpluralsight.aad_team20.providers

import com.alcpluralsight.aad_team20.models.MovieResult
import com.alcpluralsight.aad_team20.models.Urls
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import java.io.Reader

class MovieDataProvider {
    fun fetchUpcoming(take: Int, responseHandler: (result: MovieResult)-> Unit?) {
        Urls.getUpcomingUrl(take).httpGet().responseObject(TmdbDataDeserializer()){
            _,response,result ->
            if(response.statusCode != 200){
            throw Exception("Unable to get List of upcoming movies")
             }
            val (data, _) = result
            responseHandler.invoke(data as MovieResult)
        }
    }

    fun fetchTopRated(take: Int, responseHandler: (result: MovieResult)-> Unit?) {
        Urls.getTopRatedUrl(take).httpGet().responseObject(TmdbDataDeserializer()){
            _,response,result ->
            if(response.statusCode != 200){
                throw Exception("Unable to get List of top rated movies")
            }
            val (data, _) = result
            responseHandler.invoke(data as MovieResult)
        }
    }

    fun fetchPopular(take: Int, responseHandler: (result: MovieResult)-> Unit?) {
        Urls.getPopularUrl(take).httpGet().responseObject(TmdbDataDeserializer()){
            _,response,result ->
            if(response.statusCode != 200){
                throw Exception("Unable to get List of popular movies")
            }
            val (data, _) = result
            responseHandler.invoke(data as MovieResult)
        }
    }

    fun fetchNowPlaying(take: Int, responseHandler: (result: MovieResult) -> Unit? ) {
        Urls.getNowPlayingrUrl(take).httpGet().responseObject(TmdbDataDeserializer()){
            _,response,result ->
            if(response.statusCode != 200){
                throw Exception("Unable to get List of movies playing now in theatres")
            }
            val (data, _) = result
            responseHandler.invoke(data as MovieResult)
        }
    }

    fun fetchLatest(take: Int, responseHandler: (result: MovieResult) -> Unit?) {
        Urls.getLatestUrl(take).httpGet().responseObject(TmdbDataDeserializer()){
            _,response,result ->
            if(response.statusCode != 200){
                throw Exception("Unable to get List of latest movies")
            }
            val (data, _) = result
            responseHandler.invoke(data as MovieResult)
        }
    }
    class  TmdbDataDeserializer : ResponseDeserializable<MovieResult>{
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, MovieResult::class.java)
    }
}