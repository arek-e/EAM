package se.arctic.eam.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import se.arctic.eam.model.User
import se.arctic.eam.repository.UserRepository


@RestController
@RequestMapping("/api/users")
class UserController(
    @Autowired
    private val userRepository: UserRepository
) {
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User {
        return userRepository.findById(id).get()
    }

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        return userRepository.save(user)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User {
        val existingUser = userRepository.findById(id).get()
        existingUser.firstName = user.firstName
        existingUser.email = user.email
        return userRepository.save(existingUser)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): String {
        return try {
            userRepository.findById(id).get()
            userRepository.deleteById(id)
            "User deleted successfully"
        } catch (e: Exception) {
            "User not found"
        }
    }
}