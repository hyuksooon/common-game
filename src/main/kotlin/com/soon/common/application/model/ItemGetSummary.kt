package com.soon.common.application.model

import com.soon.common.domain.item.Item

data class ItemGetSummary(
        val serviceNo: Int,
        val title: String,
        val description: String,
) {
    companion object {
        fun of(item: Item) = ItemGetSummary(
                serviceNo = item.serviceNo,
                title = item.title,
                description = item.description,
        )
    }
}
