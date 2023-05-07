package br.com.fugisawa.adopetbackendkotlin.controller

import br.com.fugisawa.adopetbackendkotlin.domain.user.User
import br.com.fugisawa.adopetbackendkotlin.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping
    fun listUsers() = userService.findAll()

    @GetMapping("/{id}")
    fun listUser(@PathVariable id: Long): ResponseEntity<User> = userService.findById(id)
        ?.let { ResponseEntity.ok(it) }
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User $id not found.")

    @GetMapping("/email/{email}")
    fun listUsersByEmail(
        @PathVariable email: String,
    ) = userService.findByEmail(email)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: User) = userService.create(user)

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateUser(@RequestBody user: User) = userService.update(user)

    @PostMapping("/disable/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun disableUser(@PathVariable id: Long) = userService.disable(id)

    @PostMapping("/enable/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun enableUser(@PathVariable id: Long) = userService.enable(id)
}