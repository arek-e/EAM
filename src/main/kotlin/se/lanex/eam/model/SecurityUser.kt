package se.lanex.eam.model

import org.slf4j.LoggerFactory
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

data class SecurityUser(private val user: User) : UserDetails{
    val logger = LoggerFactory.getLogger(this::class.java)
    override fun getAuthorities(): Collection<GrantedAuthority> {

        logger.info("Loading authorities for user: ${user.username}")
        val authorites = user.roles.map { role -> SimpleGrantedAuthority(role.name) }.toList()
        logger.info("Authorities for user: ${user.username} are: $authorites")
        return authorites
    }

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.username

    // TODO: Implement the following methods
    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}