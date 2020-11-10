package com.example.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room.dao.OwnerAndPetDao
import com.example.room.entity.Owner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val dao: OwnerAndPetDao
) : ViewModel() {

    val owners = dao.getAllOwners()

    fun addOwner(owner: Owner) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.saveOwner(owner)
            }
        }
    }

    fun deleteOwner(owner: Owner) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dao.deleteOwner(owner)
            }
        }
    }
}