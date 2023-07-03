package br.com.fugisawa.adopetbackendkotlin.controller

import br.com.fugisawa.adopetbackendkotlin.domain.pet.Pet
import br.com.fugisawa.adopetbackendkotlin.domain.pet.dto.PetCreate
import br.com.fugisawa.adopetbackendkotlin.service.PetService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/pet")
class PetController(val petService: PetService) {

    @GetMapping
    fun listAll(): List<Pet> = petService.findAll()

    @GetMapping("/{id}")
    fun listPet(@PathVariable id: Long): ResponseEntity<Pet> = petService.findById(id)
        ?.let { ResponseEntity.ok(it) }
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User $id not found.")

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPet(@RequestBody pet: PetCreate) = petService.create(pet)

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updatePet(@RequestBody pet: Pet) = petService.update(pet)
}