package com.soon.common.presentation.handler.model

import com.soon.common.application.model.ItemGetSummary

data class ItemGetResponse(
        val itemNo: Int,
        val serviceNo: Int,
        val title: String,
        val description: String,
        val thumbnail: String,
) {
    companion object {
        fun of(summary: ItemGetSummary) = ItemGetResponse(
                itemNo = summary.itemNo,
                serviceNo = summary.serviceNo,
                title = summary.title,
                description = summary.description,
                thumbnail = summary.thumbnail,
        )
    }
}
