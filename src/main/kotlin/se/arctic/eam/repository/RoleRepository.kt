package se.arctic.eam.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import se.arctic.eam.model.Role
import se.arctic.eam.model.User

@Repository
interface RoleRepository : JpaRepository<Role?, Long?>