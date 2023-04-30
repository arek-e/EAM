package se.lanex.eam.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @GetMapping
    fun home(): String = "Hello World!"

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    fun admin(): String = "Hello Admin!"

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    fun user(): String = "Hello User!"
}