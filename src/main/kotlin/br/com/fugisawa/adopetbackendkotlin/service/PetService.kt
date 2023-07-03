package br.com.fugisawa.adopetbackendkotlin.service

import br.com.fugisawa.adopetbackendkotlin.domain.pet.Pet
import br.com.fugisawa.adopetbackendkotlin.domain.pet.dto.PetCreate
import br.com.fugisawa.adopetbackendkotlin.domain.pet.dto.mapper.PetCreateMapper
import br.com.fugisawa.adopetbackendkotlin.repository.PetRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class PetService(
    private val petRepository: PetRepository,
    private val petCreateToPet: PetCreateMapper,
) {

    fun findAll(): List<Pet> = petRepository.findAll()

    fun findById(id: Long): Pet? = petRepository.findById(id).getOrNull()

    @Transactional
    fun create(pet: PetCreate): Pet = petRepository.save(pet.let(petCreateToPet))

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