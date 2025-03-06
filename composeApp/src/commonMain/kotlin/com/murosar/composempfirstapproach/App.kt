@file:OptIn(KoinExperimentalAPI::class)

package com.murosar.composempfirstapproach

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.murosar.composempfirstapproach.dependencies.MyViewModel
import composempfirstapproach.composeapp.generated.resources.Res
import composempfirstapproach.composeapp.generated.resources.baseline_add_reaction_24
import composempfirstapproach.composeapp.generated.resources.compose_multiplatform
import composempfirstapproach.composeapp.generated.resources.home_text
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@Preview
fun App(
    // This should be injected in the ViewModel, let it here as an example
    batteryManager: BatteryManager,
    // This is another way to inject things, but it is not recommended
    // dbClient: DbClient = koinInject()
) {
    MaterialTheme {
        // Needed to be able to inject things
        KoinContext {
            // DI
            val myViewModel = koinViewModel<MyViewModel>()

            var showBasicContent by remember { mutableStateOf(false) }
            var showBatteryLevel by remember { mutableStateOf(false) }
            var showResources by remember { mutableStateOf(false) }
            var showKoinInjection by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { showBasicContent = !showBasicContent }
                ) {
                    Text("Show basic content!")
                }
                AnimatedVisibility(showBasicContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(Color.LightGray)
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Just created project example...",
                            textAlign = TextAlign.Center,
                            color = Color.Red
                        )
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "Compose: $greeting",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { showBatteryLevel = !showBatteryLevel }
                ) {
                    Text("Show battery level!")
                }
                AnimatedVisibility(showBatteryLevel) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(Color.LightGray)
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Example of different implementation for each platform...",
                            textAlign = TextAlign.Center,
                            color = Color.Red
                        )
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "The battery level is: ${batteryManager.getBatteryLevel()}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { showResources = !showResources }
                ) {
                    Text("Show resources!")
                }
                AnimatedVisibility(showResources) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(Color.LightGray)
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painterResource(Res.drawable.baseline_add_reaction_24), null)
                        Text(
                            text = "Example of string localization, change the device's language to Spanish to test it...",
                            textAlign = TextAlign.Center,
                            color = Color.Red
                        )
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = stringResource(Res.string.home_text),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { showKoinInjection = !showKoinInjection }
                ) {
                    Text("Show Koin injection!")
                }
                AnimatedVisibility(showKoinInjection) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(Color.LightGray)
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Example of a injected ViewModel, Repository and DbClient",
                            textAlign = TextAlign.Center,
                            color = Color.Red
                        )
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = myViewModel.helloWorld(),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}