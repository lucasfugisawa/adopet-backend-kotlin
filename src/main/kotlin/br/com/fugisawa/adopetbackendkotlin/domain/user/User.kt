package br.com.fugisawa.adopetbackendkotlin.domain.user

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var email: String,
    val name: String,
    var password: String,
    var about: String? = null,
)
