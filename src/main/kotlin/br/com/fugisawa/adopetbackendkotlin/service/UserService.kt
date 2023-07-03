package br.com.fugisawa.adopetbackendkotlin.service

import br.com.fugisawa.adopetbackendkotlin.domain.user.User
import br.com.fugisawa.adopetbackendkotlin.domain.user.dto.UserCreate
import br.com.fugisawa.adopetbackendkotlin.domain.user.dto.UserUpdate
import br.com.fugisawa.adopetbackendkotlin.domain.user.dto.UserView
import br.com.fugisawa.adopetbackendkotlin.repository.UserRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userToView: (User) -> (UserView),
    private val userCreateToUser: (UserCreate) -> (User),
) {

    fun findAll(pageable: Pageable) = userRepository.findAll(pageable).map(userToView)

    fun findById(id: Long) = userRepository.findById(id).getOrNull()?.let(userToView)

    fun findByEmail(email: String) = userRepository.findByEmailIgnoreCase(email)?.let(userToView)

    @Transactional
    fun create(user: UserCreate) = userCreateToUser(user)
            .apply { userRepository.save(this) }
            .let(userToView)

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
        .let(userToView)

    @Transactional
    fun enable(id: Long) = userRepository.getReferenceById(id)
        .apply { enabled = true }
        .run { userRepository.save(this) }
        .let(userToView)

}