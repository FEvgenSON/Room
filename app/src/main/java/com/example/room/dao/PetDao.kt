package com.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.room.entity.Pet

@Dao
interface PetDao {

    @Query("SELECT * FROM Pet")
    fun getAllPets(): LiveData<List<Pet>>

    @Query("SELECT * FROM Pet WHERE ownerId == :ownerId")
    fun getPetsByOwnerId(ownerId: Long): LiveData<List<Pet>>

    @Insert
    suspend fun savePet(pet: Pet)

    @Delete
    suspend fun deletePet(pet: Pet)
}