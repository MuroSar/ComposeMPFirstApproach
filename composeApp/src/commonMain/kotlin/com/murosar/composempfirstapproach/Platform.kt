package com.murosar.composempfirstapproach

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

