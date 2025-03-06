package com.murosar.composempfirstapproach

import kotlinx.datetime.TimeZone

data class City(
    val name: String,
    val timeZone: TimeZone
)

fun getMockCities() = listOf(
    City("Buenos Aires", TimeZone.of("America/Argentina/Buenos_Aires")),
    City("Berlin", TimeZone.of("Europe/Berlin")),
    City("London", TimeZone.of("Europe/London")),
    City("New York", TimeZone.of("America/New_York")),
    City("Los Angeles", TimeZone.of("America/Los_Angeles")),
    City("Tokyo", TimeZone.of("Asia/Tokyo")),
    City("Sydney", TimeZone.of("Australia/Sydney")),
)
