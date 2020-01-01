package com.noicesoftware.redis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(RedisConfiguration::class)
class RedisApplication

fun main(args: Array<String>) {
    runApplication<RedisApplication>(*args)
}
