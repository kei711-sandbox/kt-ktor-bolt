package com.example.plugins

import com.example.slack.createApp
import com.example.slack.createRequestParser
import com.example.slack.toBoltRequest
import com.slack.api.bolt.ktor.respond
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

fun Application.configureRouting() {
    val app = createApp()
    val parser = app.createRequestParser()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/healthz") {
            call.respondText("OK")
        }
        post("/slack/events") {
            respond(call, app.run(call.toBoltRequest(parser)))
        }
    }
}
