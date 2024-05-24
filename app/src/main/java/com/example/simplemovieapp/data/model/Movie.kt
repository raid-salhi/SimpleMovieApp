package com.example.simplemovieapp.data.model

import com.google.gson.annotations.SerializedName


//this data class holds only necessary information about the movie in the app
data class Movie(
    val id: Int,
    val title: String,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("poster_path")
    val poster:String,
    val overview: String
){
    fun getYear(): String = date.split("-").first()
}
