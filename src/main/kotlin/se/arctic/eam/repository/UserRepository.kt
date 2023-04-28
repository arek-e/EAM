package se.arctic.eam.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import se.arctic.eam.model.User

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByEmail(email: String): User?
}