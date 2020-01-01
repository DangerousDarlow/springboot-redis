package com.noicesoftware.redis

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("redis")
data class RedisConfiguration(
        val host: String,
        val port: Int
)