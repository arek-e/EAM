package se.arctic.eam.service

import se.arctic.eam.model.User

interface UserService {
    fun save(user: User): User
    fun findByUsername(username: String): User?
}