package com.noicesoftware.redis.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("redis")
data class RedisConfig(
        val redisUrl: String
)