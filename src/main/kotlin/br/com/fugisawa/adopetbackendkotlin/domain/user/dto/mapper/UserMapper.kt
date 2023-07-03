package br.com.fugisawa.adopetbackendkotlin.domain.user.dto.mapper

import br.com.fugisawa.adopetbackendkotlin.domain.user.User
import br.com.fugisawa.adopetbackendkotlin.domain.user.dto.UserView
import org.springframework.stereotype.Component

@Component
class UserMapper : (User) -> (UserView) {
    override fun invoke(user: User): UserView {
        return UserView(
            id = user.id,
            email = user.email,
            name = user.name,
            about = user.about,
            enabled = user.enabled,
        )
    }
}