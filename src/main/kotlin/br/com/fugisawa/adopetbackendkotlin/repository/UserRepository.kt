package br.com.fugisawa.adopetbackendkotlin.repository

import br.com.fugisawa.adopetbackendkotlin.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}
