package com.noicesoftware.redis.model

import java.util.*


data class Game(
        val id: UUID,
        val players: List<Player>
)