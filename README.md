# springboot-redis

This simple application, written in Kotlin, demonstrates the use of SpringBoot and Redis to set and retrieve.

## Prerequisites

This application assumes a Redis server is running and available for connection on localhost:6379. An easy way to achieve this is to run the official Redis docker container; https://hub.docker.com/_/redis.

## Running the application

Run the application using the command line

    .\gradlew.bat bootRun
  
Or using your IDE of choice. I used IntelliJ IDEA.

## Using the application

Post data to service

    curl --location --request POST 'localhost:8080/a95c07a6-4c0b-4ec9-a3b9-1ebbdd50db9e' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": "a95c07a6-4c0b-4ec9-a3b9-1ebbdd50db9e",
        "players": [
            {
                "id": "bb089b3c-9fd7-499e-b468-fa27b91728b4",
                "name": "anna"
            },
            {
                "id": "1efb2617-702e-425d-8107-8fe5c3064d90",
                "name": "bill"
            }
        ]
    }'

Retrieve data from the service

    curl --location --request GET 'localhost:8080/a95c07a6-4c0b-4ec9-a3b9-1ebbdd50db9e'
    
Retrieve sample data from the service

    curl --location --request GET 'localhost:8080/example'
    
## Notes on Heroku

I wrote this with the intention of hosting it on Heroku. I added the Heroku Redis add-on (https://devcenter.heroku.com/articles/heroku-redis) with the free plan. Heroku adds an environment variable REDIS_URL to the environment of the running app containing all the details needed to connect. It looks like this (credentials changed)

	redis://h:uh29387645ijhdc876tq345@ec2-52-211-78-98.eu-west-1.compute.amazonaws.com:29079

I found the easiest way to use this was to parse it using `RedisURI.create` and then set properties of `RedisStandaloneConfiguration` accordingly. You can find this in `RedisTemplateConfig.kt`

	val uri = RedisURI.create(configuration.redisUrl)
	val config = RedisStandaloneConfiguration(uri.host, uri.port)
	config.setPassword(uri.password)
	LettuceConnectionFactory(config)
