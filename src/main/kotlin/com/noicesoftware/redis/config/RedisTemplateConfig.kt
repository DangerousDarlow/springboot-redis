package com.noicesoftware.redis.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisTemplateConfig(
        val configuration: RedisConfig
) {
    @Bean
    fun connectionFactory(): LettuceConnectionFactory {
        val config = RedisStandaloneConfiguration(
                configuration.host,
                configuration.port)

        return LettuceConnectionFactory(config)
    }

    @Bean
    fun <T> redisTemplate(): RedisTemplate<String, T> {
        val template = RedisTemplate<String, T>()
        template.setConnectionFactory(connectionFactory())
        return template
    }
}