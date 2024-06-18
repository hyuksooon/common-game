package com.soon.common.application.item

import com.soon.common.application.item.model.ItemCreateCommand
import com.soon.common.domain.item.Item
import com.soon.common.domain.item.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemCommandService(
        private val itemRepository: ItemRepository,
) {
    suspend fun createItem(command: ItemCreateCommand) {
        itemRepository.save(Item.create(command.toCreateModel()))
    }
}