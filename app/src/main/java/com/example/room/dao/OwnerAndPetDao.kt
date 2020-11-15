package com.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room.entity.OwnerPet
import com.example.room.entity.OwnerWithPets

@Dao
abstract class OwnerAndPetDao : OwnerDao, PetDao {

    @Query("SELECT * FROM owner WHERE ownerId == :ownerId")
    abstract fun getOwnerWithPets(ownerId: Long): LiveData<OwnerWithPets>

    @Insert
    abstract suspend fun insertOwnerPet(ownerPet: OwnerPet)
}