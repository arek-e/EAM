package se.lanex.eam.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val username: String = "",
)

data class CreateUser(
    val username: String,
)

data class ViewUser(
    val id: Long,
    val username: String,
)

fun User.toView() =
    ViewUser(id, username)
