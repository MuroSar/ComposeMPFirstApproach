package com.murosar.composempfirstapproach

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.murosar.composempfirstapproach.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App(batteryManager = remember { BatteryManager() })
}