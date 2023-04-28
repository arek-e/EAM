package se.arctic.eam

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.Order
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Component
import se.arctic.eam.model.Role
import se.arctic.eam.model.User
import se.arctic.eam.repository.RoleRepository
import se.arctic.eam.repository.UserRepository

@SpringBootApplication
class EamApplication
    fun main(args: Array<String>) {
        runApplication<EamApplication>(*args)
    }

    @Bean
    fun commandLineRunner(userRepository: UserRepository, roleRepository: RoleRepository): CommandLineRunner{
        return CommandLineRunner {
            roleRepository.save(Role("ROLE_USER"))
            roleRepository.save(Role("ROLE_ADMIN"))
            userRepository.save(User("alex", "password", "alex@gmail.com", "Alex", "Eklund"))
        }
    }

