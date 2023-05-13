package com.example.saifapp

data class Poster(val imageId: Int, val title: String)
class PosterList {val list = arrayListOf(
    Poster(R.drawable.`s1`, ""),
    Poster(R.drawable.s2, ""),
    Poster(R.drawable.s3, ""),
    Poster(R.drawable.s4, ""),
    Poster(R.drawable.s5, ""))}
