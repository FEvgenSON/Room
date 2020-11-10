package com.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.room.entity.Owner

@Dao
interface OwnerDao {

    @Query("SELECT * FROM Owner")
    fun getAllOwners(): LiveData<List<Owner>>

    @Query("SELECT * FROM Owner WHERE id = :id")
    suspend fun getOwner(id: Long): Owner

    @Insert
    suspend fun saveOwner(owner: Owner)

    @Delete
    suspend fun deleteOwner(owner: Owner)
}