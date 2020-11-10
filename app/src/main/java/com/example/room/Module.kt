package com.example.room

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val Module = module {
    viewModel { MainViewModel() }
}