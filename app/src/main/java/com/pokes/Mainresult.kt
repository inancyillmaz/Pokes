package com.pokes

import com.google.gson.annotations.SerializedName

data class Mainresult(
    @SerializedName("name")
    val name: String = "default",
    @SerializedName("url")
    val title: String = "",
    )