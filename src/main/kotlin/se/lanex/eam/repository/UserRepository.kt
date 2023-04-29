package se.lanex.eam.repository

import org.springframework.data.repository.CrudRepository
import se.lanex.eam.model.User

interface UserRepository: CrudRepository<User, Long> {
    fun findByUsername(username: String): User?
}
