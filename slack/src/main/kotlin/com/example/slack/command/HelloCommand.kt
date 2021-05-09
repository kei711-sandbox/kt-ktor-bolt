package com.example.slack.command

import com.slack.api.bolt.handler.builtin.SlashCommandHandler

class HelloCommand : Command {
    override val name = "/hello"
    override val handler = SlashCommandHandler { req, context ->
        context.respond("hello")
        context.respond("hello hello")
        context.ack()
    }
}
