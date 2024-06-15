package com.soon.common.application.model

import com.soon.common.domain.item.model.ItemCreateModel

data class ItemCreateCommand(
        val serviceNo: Int,
        val title: String,
        val description: String,
        val thumbnail: String,
) {
    fun toCreateModel() = ItemCreateModel(
            serviceNo = serviceNo,
            title = title,
            description = description,
            thumbnail = thumbnail,
    )
}