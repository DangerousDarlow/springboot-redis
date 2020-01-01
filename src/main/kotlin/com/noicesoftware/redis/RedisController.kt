package com.noicesoftware.redis

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RedisController(val configuration: RedisConfiguration) {

    @GetMapping
    fun get(): String {
        return "${configuration.host} ${configuration.port}"
    }
}