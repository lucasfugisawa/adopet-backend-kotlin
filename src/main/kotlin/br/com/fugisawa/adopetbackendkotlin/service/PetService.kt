package br.com.fugisawa.adopetbackendkotlin.service

import br.com.fugisawa.adopetbackendkotlin.domain.pet.Pet
import br.com.fugisawa.adopetbackendkotlin.domain.pet.PetSpecies
import br.com.fugisawa.adopetbackendkotlin.domain.user.User
import br.com.fugisawa.adopetbackendkotlin.repository.PetRepository
import jakarta.persistence.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class PetService(val petRepository: PetRepository) {

    fun findAll(): List<Pet> = petRepository.findAll()

    fun findById(id: Long): Pet? = petRepository.findById(id).getOrNull()

    @Transactional
    fun create(pet: Pet): Pet = petRepository.save(pet)

    @Transactional
    fun update(pet: Pet) {
        pet.id?.let { petId ->
            petRepository.findById(petId).getOrNull()
                ?.apply {
                    name = pet.name
                    species = pet.species
                    personality = pet.personality
                    city = pet.city
                    state = pet.state
                    owner = pet.owner
                    profilePictureUrl = pet.profilePictureUrl
                }
                ?.also { petRepository.save(it) }
        }
    }
}