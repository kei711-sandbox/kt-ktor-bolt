package com.example.slack

import com.example.slack.command.Command
import com.example.slack.command.HelloCommand
import com.slack.api.bolt.App
import com.slack.api.bolt.ktor.toBoltRequest
import com.slack.api.bolt.util.SlackRequestParser
import io.ktor.application.ApplicationCall

fun createApp(): App {
    return App().also {
        val commands = listOf<Command>(HelloCommand())
        commands.forEach { command -> command.apply(it) }
    }
}

fun App.createRequestParser() = SlackRequestParser(config())

suspend fun ApplicationCall.toBoltRequest(parser: SlackRequestParser) = toBoltRequest(this, parser)
