package br.com.fugisawa.adopetbackendkotlin.controller

import br.com.fugisawa.adopetbackendkotlin.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping
    fun listUsers() = userService.findAll()

    // GET /user/1
    @GetMapping("/{id}")
    fun listUser(@PathVariable id: Long) = userService.findById(id)
}