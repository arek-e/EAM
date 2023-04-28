package se.lanex.eam.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/hello")
    fun hello(): String {
        logger.trace("Trace message")
        logger.debug("Debug message")

        logger.info("Info message")
        logger.warn("Warn message")
        logger.error("Error message")

        logger.info("INFO {} {}", 1, "abc")
        try {
            val x = 1 / 0
        }catch (e: Throwable){
            logger.error("Error message", e)
        }

        return "Hello, World!"
    }
}