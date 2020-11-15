package com.example.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity(primaryKeys = ["ownerId", "petId"])
data class OwnerPet(
    val ownerId: Long,
    val petId: Long
)

data class OwnerWithPets(
    @Embedded val owner: Owner,
    @Relation(
        parentColumn = "ownerId",
        entityColumn = "petId",
        entity = Pet::class,
        associateBy = Junction(OwnerPet::class)
    ) val pets: List<Pet>
)