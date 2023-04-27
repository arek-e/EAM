package se.arctic.eam.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    val username: String,
    @Column(nullable = false)
    val password: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val isEnabled: Boolean = false,
    val isLocked: Boolean = false,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val roles: Set<Role> = setOf()
)