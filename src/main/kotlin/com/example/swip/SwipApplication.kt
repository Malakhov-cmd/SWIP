package com.example.swip

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication
class SwipApplication

fun main(args: Array<String>) {
    runApplication<SwipApplication>(*args)
}

@Bean
fun corsConfigurer(): WebMvcConfigurer? {
    return object : WebMvcConfigurer {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry.addMapping("/**").allowedOrigins("http://localhost:8080")
        }
    }
}
