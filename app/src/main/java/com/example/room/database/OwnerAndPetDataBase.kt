package com.example.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room.dao.OwnerAndPetDao
import com.example.room.entity.Owner
import com.example.room.entity.OwnerPet
import com.example.room.entity.Pet

@Database(entities = [Owner::class, Pet::class, OwnerPet::class], version = 1, exportSchema = false)
abstract class OwnerAndPetDataBase : RoomDatabase() {

    abstract fun getDao(): OwnerAndPetDao
}