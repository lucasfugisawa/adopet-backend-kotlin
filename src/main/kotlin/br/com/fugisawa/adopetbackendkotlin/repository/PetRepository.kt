package br.com.fugisawa.adopetbackendkotlin.repository

import br.com.fugisawa.adopetbackendkotlin.domain.pet.Pet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : JpaRepository<Pet, Long> {
}