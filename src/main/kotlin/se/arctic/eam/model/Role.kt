package se.arctic.eam.model

import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, unique = true)
    val name: String,
    @ManyToMany(mappedBy = "roles")
    val users: Set<User> = setOf()
)