package com.example.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.dao.OwnerAndPetDao
import com.example.room.entity.Owner
import com.example.room.entity.Pet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OwnerViewModel(
    private val ownerId: Long,
    private val dao: OwnerAndPetDao
) : ViewModel() {

    private val _owner = MutableLiveData<Owner>()
    val owner: LiveData<Owner>
        get() = _owner

    val pets = dao.getPetsByOwnerId(ownerId)

    init {
        viewModelScope.launch {
            val owner = withContext(Dispatchers.IO) { dao.getOwner(ownerId) }
            _owner.value = owner
        }
    }

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