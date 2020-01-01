package com.noicesoftware.redis

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RedisController(
        val redisTemplate: RedisTemplate<String, String>
) {

    @GetMapping
    fun get(): String {
        val v = redisTemplate.opsForValue().get("hi")
        return v ?: "none"
    }

    @PostMapping
    fun post(@RequestBody body: String) = println(body)
}