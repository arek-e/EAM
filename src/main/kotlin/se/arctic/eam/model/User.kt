package se.arctic.eam.model

import jakarta.persistence.*
import org.aspectj.weaver.ast.FieldGet

@Entity
@Table(name = "users")
data class User (
    @Column(nullable = false)
    var username: String,
    @Column(nullable = false)
    var password: String,

    var email: String,
    var firstName: String,
    var lastName: String,
    var isEnabled: Boolean = false,
    var isLocked: Boolean = false,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: Set<Role> = setOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
