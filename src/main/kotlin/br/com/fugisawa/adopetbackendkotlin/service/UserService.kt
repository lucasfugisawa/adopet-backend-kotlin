package br.com.fugisawa.adopetbackendkotlin.service

import br.com.fugisawa.adopetbackendkotlin.domain.user.User
import br.com.fugisawa.adopetbackendkotlin.repository.UserRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll(): List<User> = userRepository.findAll()

    fun findById(id: Long): User? = userRepository.findById(id).getOrNull()

}