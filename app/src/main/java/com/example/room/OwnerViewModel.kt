package com.example.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.dao.OwnerAndPetDao
import com.example.room.entity.Pet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OwnerViewModel(
    ownerId: Long,
    private val dao: OwnerAndPetDao
) : ViewModel() {

    val ownerWithPets = dao.getOwnerWithPets(ownerId)

    fun addPet(pet: Pet) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.savePet(pet)
            }
        }
    }

    fun deletePet(pet: Pet) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.deletePet(pet)
            }
        }
    }
}