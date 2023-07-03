package br.com.fugisawa.adopetbackendkotlin.domain.pet.dto.mapper

import br.com.fugisawa.adopetbackendkotlin.domain.pet.Pet
import br.com.fugisawa.adopetbackendkotlin.domain.pet.dto.PetCreate
import br.com.fugisawa.adopetbackendkotlin.exception.NotFoundException
import br.com.fugisawa.adopetbackendkotlin.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class PetCreateMapper(private val userRepository: UserRepository) : (PetCreate) -> (Pet) {
    override fun invoke(pet: PetCreate): Pet {
        return Pet(
            name = pet.name,
            species = pet.species,
            personality = pet.personality,
            city = pet.city,
            state = pet.state,
            owner = userRepository.findById(pet.ownerId).orElseThrow { NotFoundException("Owner ${pet.ownerId} not found.") },
            profilePictureUrl = pet.profilePictureUrl,
        )
    }
}