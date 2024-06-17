package com.soon.common.presentation.handler.item

import com.soon.common.application.item.ItemCommandService
import com.soon.common.application.item.ItemQueryService
import com.soon.common.application.util.coroutines.ApplicationDispatchers
import com.soon.common.presentation.extension.extractServiceCodeHeader
import com.soon.common.presentation.extension.intQueryParam
import com.soon.common.presentation.handler.item.model.ItemCreateRequest
import com.soon.common.presentation.handler.item.model.ItemGetResponse
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.*

@Service
class ItemHandler(
        private val itemCommandService: ItemCommandService,
        private val itemQueryService: ItemQueryService,
) {
    suspend fun createItem(request: ServerRequest): ServerResponse = withContext(ApplicationDispatchers.IO) {
        val serviceHeader = request.extractServiceCodeHeader()
        val command = request.awaitBodyOrNull<ItemCreateRequest>()?.toCommand(serviceHeader.no)
                ?: throw IllegalArgumentException()

        itemCommandService.createItem(command)
        ServerResponse.noContent().buildAndAwait()
    }

    suspend fun getItem(request: ServerRequest): ServerResponse = withContext(ApplicationDispatchers.IO) {
        val itemNo = request.intQueryParam("itemNo")
        val summary = itemQueryService.getItem(itemNo)
        ServerResponse.ok().bodyValueAndAwait(ItemGetResponse.of(summary))
    }
}