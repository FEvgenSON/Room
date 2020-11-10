package com.example.room

import androidx.room.Room
import com.example.room.database.OwnerAndPetDataBase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val Module = module {
    single {
        Room.databaseBuilder(get(), OwnerAndPetDataBase::class.java, "Data base Name").build()
    }
    single {
        get<OwnerAndPetDataBase>().getDao()
    }
    viewModel { MainViewModel(get()) }
    viewModel { (ownerId: Long) -> OwnerViewModel(ownerId, get()) }
}