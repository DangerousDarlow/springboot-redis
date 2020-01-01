package com.noicesoftware.redis

import com.noicesoftware.redis.config.RedisConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(RedisConfig::class)
class RedisApplication

fun main(args: Array<String>) {
    runApplication<RedisApplication>(*args)
}
