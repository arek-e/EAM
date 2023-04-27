package se.arctic.eam.service

import se.arctic.eam.model.User
import se.arctic.eam.repository.UserRepository

class UserServiceImpl(private  val userRepository: UserRepository): UserService {
    override fun save(user: User): User {
       return userRepository.save(user)
    }

    override fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username)
    }
}