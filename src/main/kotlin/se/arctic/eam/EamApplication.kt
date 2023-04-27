package se.arctic.eam

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EamApplication

fun main(args: Array<String>) {
    runApplication<EamApplication>(*args)
}
