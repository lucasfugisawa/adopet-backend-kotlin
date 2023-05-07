package br.com.fugisawa.adopetbackendkotlin.service

import br.com.fugisawa.adopetbackendkotlin.domain.user.User
import br.com.fugisawa.adopetbackendkotlin.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll(): List<User> = userRepository.findAll()

    fun findById(id: Long): User? = userRepository.findById(id).getOrNull()

    fun findByEmail(email: String) = userRepository.findByEmailIgnoreCase(email)

    @Transactional
    fun create(user: User): User = userRepository.save(user)

    @Transactional
    fun update(user: User) {
        user.id?.let { userId ->
            userRepository.findById(userId).getOrNull()
                ?.apply {
                    name = user.name
                    email = user.email
                    password = user.password
                    about = user.about
                }
                ?.also { userRepository.save(it) }
        }
    }

    @Transactional
    fun disable(id: Long) = userRepository.getReferenceById(id)
        .apply { enabled = false }
        .run { userRepository.save(this) }

    @Transactional
    fun enable(id: Long) = userRepository.getReferenceById(id)
        .apply { enabled = true }
        .run { userRepository.save(this) }

}