package br.com.fugisawa.adopetbackendkotlin.domain.user.dto

class UserCreate(
    val email: String,
    val name: String,
    val password: String,
    val about: String? = null,
)
