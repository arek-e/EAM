package se.lanex.eam.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

data class SecurityUser(private val user: User) : UserDetails{
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        //TODO: Get the roles from the user and return them, also need to update database to have roles
    }

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}