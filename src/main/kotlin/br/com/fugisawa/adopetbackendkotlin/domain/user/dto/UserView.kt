package br.com.fugisawa.adopetbackendkotlin.domain.user.dto

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class UserView(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var email: String,
    var name: String,
    var about: String? = null,
    var enabled: Boolean,
)
