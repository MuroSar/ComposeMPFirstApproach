package com.murosar.composempfirstapproach

import com.murosar.composempfirstapproach.BatteryManager
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.murosar.composempfirstapproach.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "ComposeMPFirstApproach",
        ) {
            App(
                batteryManager = remember { BatteryManager() }
            )
        }
    }
}