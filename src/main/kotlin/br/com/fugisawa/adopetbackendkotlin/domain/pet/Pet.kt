package br.com.fugisawa.adopetbackendkotlin.domain.pet

import br.com.fugisawa.adopetbackendkotlin.domain.user.User
import jakarta.persistence.*

@Entity
class Pet(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name: String,

    @Enumerated(EnumType.STRING)
    var species: PetSpecies,

    var personality: String,
    var city: String,
    var state: String,

    @ManyToOne
    var owner: User?,

    var profilePictureUrl: String,
)