package se.arctic.eam.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class JpaUserDetailsService: UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails? {
        return null;
    }
}