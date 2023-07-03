package br.com.fugisawa.adopetbackendkotlin.domain.user.dto

class UserUpdate(
    val name: String,
    val password: String,
    val about: String? = null,
)