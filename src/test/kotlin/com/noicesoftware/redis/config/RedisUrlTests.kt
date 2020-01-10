package com.noicesoftware.redis.config

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import io.lettuce.core.RedisURI
import org.junit.jupiter.api.Test

class RedisUrlTests {
    @Test
    fun testIt() {
        val envFromHeroku = "redis://h:uh29387645ijhdc876tq345@ec2-52-211-78-98.eu-west-1.compute.amazonaws.com:29079"
        val uri = RedisURI.create(envFromHeroku)
        assertThat(uri.host, equalTo("ec2-52-211-78-98.eu-west-1.compute.amazonaws.com"))
        assertThat(uri.port, equalTo(29079))
    }
}