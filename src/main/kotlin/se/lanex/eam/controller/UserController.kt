package se.lanex.eam.controller

import org.slf4j.LoggerFactory
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*
import se.lanex.eam.model.CreateUser
import se.lanex.eam.model.User
import se.lanex.eam.model.ViewUser
import se.lanex.eam.model.toView
import se.lanex.eam.repository.RoleRepository
import se.lanex.eam.repository.UserRepository

@RestController
@RequestMapping("/users")
class UserController(val userRepository: UserRepository, val roleRepository: RoleRepository, val passwordEncoder: BCryptPasswordEncoder) {
    val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun findAll(): Iterable<ViewUser> =
        userRepository.findAll().map(User::toView)

    @PostMapping("/signup")
    fun create(@RequestBody createUser: CreateUser): ViewUser {
        logger.info("Creating user: $createUser")
        val user = User(
            username = createUser.username,
            password = passwordEncoder.encode(createUser.password),
            isEnabled = false,
            roles = mutableSetOf(roleRepository.findByName("USER"))
        )
        logger.info("Created user: $user")
        val savedUser = userRepository.save(user)
        logger.info("Saved user: $savedUser")

        return savedUser.toView()
    }
}