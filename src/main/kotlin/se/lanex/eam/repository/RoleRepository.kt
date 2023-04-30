package se.lanex.eam.repository

import org.springframework.data.repository.CrudRepository
import se.lanex.eam.model.Role

interface RoleRepository: CrudRepository<Role, Long> {
    fun findByName(name: String): Role
}
