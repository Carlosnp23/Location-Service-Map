package com.example.carlosnorambuena_mapd721_optionalassignment.Model

data class Location (
    val title: String,
    val logo: Int,
    val desc: String,
    var isExpandable: Boolean = false
)