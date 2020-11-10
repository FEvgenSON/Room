package com.example.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room.dao.OwnerAndPetDao
import com.example.room.entity.Owner

@Database(entities = [Owner::class], version = 1, exportSchema = false)
abstract class OwnerAndPetDataBase : RoomDatabase() {

    abstract fun getDao(): OwnerAndPetDao
}