package com.soon.common.presentation.handler

import com.soon.common.application.ItemCommandService
import com.soon.common.application.util.coroutines.ApplicationDispatchers
import com.soon.common.presentation.handler.model.ItemCreateRequest
import com.soon.member.presentation.extension.extractServiceCodeHeader
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBodyOrNull
import org.springframework.web.reactive.function.server.buildAndAwait

@Service
class ItemHandler(
        private val itemCommandService: ItemCommandService
) {
    suspend fun createItem(request: ServerRequest): ServerResponse = withContext(ApplicationDispatchers.IO) {
        val serviceHeader = request.extractServiceCodeHeader()
        val command = request.awaitBodyOrNull<ItemCreateRequest>()?.toCommand(serviceHeader.no)
                ?: throw IllegalArgumentException()

        itemCommandService.createItem(command)
        ServerResponse.noContent().buildAndAwait()
    }

}