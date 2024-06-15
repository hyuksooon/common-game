package com.soon.common.application.util

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Retry.Topic

interface MessageBroker {
    suspend fun sendMessage(topic: Topic, message: String)
}