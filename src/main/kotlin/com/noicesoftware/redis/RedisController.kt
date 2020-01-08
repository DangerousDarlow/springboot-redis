package com.noicesoftware.redis

import com.noicesoftware.redis.model.Game
import com.noicesoftware.redis.model.Player
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
class RedisController(
        // Ignore the 'Could not autowire' error. It's erroneous!
        val redisTemplate: RedisTemplate<String, Game>
) {

    @GetMapping("/{key}")
    fun get(@PathVariable key: String): Game {
        println("key: $key")
        return redisTemplate.opsForValue().get(key) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/example")
    fun getExample(): Game {
        return Game(id = UUID.randomUUID(), players = listOf(
                Player(id = UUID.randomUUID(), name = "anna"),
                Player(id = UUID.randomUUID(), name = "bill")
        ))
    }

    @PostMapping("/{key}")
    fun post(@PathVariable key: String, @RequestBody game: Game) {
        println("key: $key, value: $game")
        redisTemplate.opsForValue().set(key, game)
    }
}