package com.soon.common.application.item.model

import com.soon.common.domain.item.Item

data class ItemGetSummary(
        val itemNo: Int,
        val serviceNo: Int,
        val title: String,
        val description: String,
        val thumbnail: String,
) {
    companion object {
        fun of(item: Item) = ItemGetSummary(
                itemNo = item.no,
                serviceNo = item.serviceNo,
                title = item.title,
                description = item.description,
                thumbnail = item.thumbnail,
        )
    }
}
