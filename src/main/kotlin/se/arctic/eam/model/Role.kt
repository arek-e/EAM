package se.arctic.eam.model

import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class Role (
    @Column(nullable = false, unique = true)
    var name: String,
    @ManyToMany(mappedBy = "roles")
    var users: Set<User> = setOf()
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}