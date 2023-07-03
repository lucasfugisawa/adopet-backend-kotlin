package br.com.fugisawa.adopetbackendkotlin.domain.pet.dto

import br.com.fugisawa.adopetbackendkotlin.domain.pet.PetSpecies

data class PetCreate(
    var name: String,
    var species: PetSpecies,
    var personality: String,
    var city: String,
    var state: String,
    var ownerId: Long,
    var profilePictureUrl: String,
)