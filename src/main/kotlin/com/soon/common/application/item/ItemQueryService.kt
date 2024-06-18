package com.soon.common.application.item

import com.soon.common.application.item.model.ItemGetSummary
import com.soon.common.domain.item.ItemRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ItemQueryService(
        private val itemRepository: ItemRepository,
) {
    fun getItem(itemNo: Int): ItemGetSummary {
        return itemRepository.findByIdOrNull(itemNo)?.let {
            ItemGetSummary.of(it)
        } ?: throw IllegalArgumentException()
    }
}