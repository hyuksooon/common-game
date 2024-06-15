package com.soon.common.presentation.handler.model

import com.soon.common.application.model.ItemCreateCommand

data class ItemCreateRequest(
        val title: String,
        val description: String,
) {
    fun toCommand(serviceNo: Int) = ItemCreateCommand(
            serviceNo = serviceNo,
            title = title,
            description = description,
    )
}
