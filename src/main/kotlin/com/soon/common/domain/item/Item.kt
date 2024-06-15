package com.soon.common.domain.item

import com.soon.common.domain.item.model.ItemCreateModel
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "item")
class Item(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "item_no")
        val no: Int = 0,

        @Column(name = "service_no")
        val serviceNo: Int,

        @Column(name = "title")
        val title: String,

        @Column(name = "description")
        val description: String,
) {
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun create(createModel: ItemCreateModel) = Item(
                serviceNo = createModel.serviceNo,
                title = createModel.title,
                description = createModel.description,
        )
    }
}