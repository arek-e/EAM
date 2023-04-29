package se.lanex.eam.model

import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(nullable = false, unique = true)
    val name: String,
    @ManyToMany(mappedBy = "roles")
    val users: Set<User> = setOf()
)
