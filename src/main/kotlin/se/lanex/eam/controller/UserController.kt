package se.lanex.eam.controller

import org.springframework.web.bind.annotation.*
import se.lanex.eam.model.CreateUser
import se.lanex.eam.model.User
import se.lanex.eam.model.ViewUser
import se.lanex.eam.model.toView
import se.lanex.eam.repository.UserRepository

@RestController
@RequestMapping("/users")
class UserController(val userRepository: UserRepository) {

    @GetMapping
    fun findAll(): Iterable<ViewUser> =
        userRepository.findAll().map(User::toView)

    @PostMapping
    fun create(@RequestBody createUser: CreateUser): ViewUser =
        userRepository.save(User(username = createUser.username)).toView()
}