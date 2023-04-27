package se.arctic.eam.repository

import org.springframework.data.jpa.repository.JpaRepository
import se.arctic.eam.model.User

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}