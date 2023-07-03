package br.com.fugisawa.adopetbackendkotlin.domain.user.dto.mapper

import br.com.fugisawa.adopetbackendkotlin.domain.user.User
import br.com.fugisawa.adopetbackendkotlin.domain.user.dto.UserCreate
import org.springframework.stereotype.Service

@Service
class UserCreateMapper : (UserCreate) -> (User) {
    override fun invoke(user: UserCreate): User {
        return User(
            email = user.email,
            name = user.name,
            password = user.password,
            about = user.about,
            enabled = true,
        )
    }
}