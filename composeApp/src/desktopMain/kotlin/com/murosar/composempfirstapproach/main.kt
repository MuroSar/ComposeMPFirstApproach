package com.murosar.composempfirstapproach

import BatteryManager
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ComposeMPFirstApproach",
    ) {
        App(
            batteryManager = remember { BatteryManager() }
        )
    }
}