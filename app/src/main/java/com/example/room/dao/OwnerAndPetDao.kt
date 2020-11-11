package com.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.room.entity.OwnerWithPets

@Dao
abstract class OwnerAndPetDao : OwnerDao, PetDao {

    @Query("SELECT * FROM owner WHERE id == :ownerId")
    abstract fun getOwnerWithPets(ownerId: Long): LiveData<OwnerWithPets>
}