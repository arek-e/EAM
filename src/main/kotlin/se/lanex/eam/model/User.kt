package se.lanex.eam.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotNull
    val username: String = "",

    @NotNull
    val password: String = "",

    @NotNull
    @Column(name = "enabled")
    val isEnabled: Boolean = false,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val roles: Set<Role> = setOf()
)

data class CreateUser(
    @field:Size(min=2, max=20)
    val username: String,
)

data class ViewUser(
    val id: Long,
    val username: String,
)

fun User.toView() =
    ViewUser(id, username)
