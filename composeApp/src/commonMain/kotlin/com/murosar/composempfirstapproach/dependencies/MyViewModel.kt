package com.murosar.composempfirstapproach.dependencies

import androidx.lifecycle.ViewModel

class MyViewModel(
    private val repository: MyRepository
): ViewModel() {

    fun helloWorld(): String {
        return repository.helloWorld()
    }
}