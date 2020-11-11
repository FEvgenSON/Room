package com.example.room.entity

import androidx.room.Embedded
import androidx.room.Relation

data class OwnerWithPets(
    @Embedded val owner: Owner,
    @Relation(parentColumn = "id", entityColumn = "ownerId") val pets: List<Pet>
)