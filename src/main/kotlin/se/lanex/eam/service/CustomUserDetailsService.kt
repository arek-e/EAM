package se.lanex.eam.service

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import se.lanex.eam.model.SecurityUser
import se.lanex.eam.repository.UserRepository

@Bean
fun testPasswordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder()
}

@Service
class CustomUserDetailsService(val userRepository: UserRepository) : UserDetailsService {
    val logger = LoggerFactory.getLogger(this::class.java)
    override fun loadUserByUsername(username: String): UserDetails {
        logger.info("Loading user with username: $username")

        val user = userRepository.findByUsername(username)

        val secUser = SecurityUser(user!!)
        logger.info("Loaded security user: ${secUser}")

        // Decrypt the password of the secUser
        val passwordEncoder = testPasswordEncoder()
        val decryptedPasswordMatches = passwordEncoder.matches("123", secUser.password)
        logger.info("Decrypted password matches: $decryptedPasswordMatches")

        return secUser
    }
}