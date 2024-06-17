package com.soon.common.presentation.handler.item.model

import com.soon.common.application.item.model.ItemCreateCommand
import jakarta.validation.constraints.NotBlank

data class ItemCreateRequest(
        @field:NotBlank
        val title: String,
        @field:NotBlank
        val description: String,
        @field:NotBlank
        val thumbnail: String,
) {
    fun toCommand(serviceNo: Int) = ItemCreateCommand(
            serviceNo = serviceNo,
            title = title,
            description = description,
            thumbnail = thumbnail,
    )
}
