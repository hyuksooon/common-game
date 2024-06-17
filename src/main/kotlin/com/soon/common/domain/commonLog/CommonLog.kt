package com.soon.common.domain.commonLog

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "common_log")
class CommonLog(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "common_log_no")
        val no: Int = 0,

        @Column(name = "service_no")
        val serviceNo: Int,

        @Column(name = "common_log_name")
        val logName: String,

        @Column(name = "int_column1")
        val intColumn1: Int?,

        @Column(name = "int_column2")
        val intColumn2: Int?,

        @Column(name = "double_column1")
        val doubleColumn1: Double?,

        @Column(name = "double_column2")
        val doubleColumn2: Double?,

        @Column(name = "datetime_column1")
        val dateTimeColumn1: LocalDateTime?,

        @Column(name = "datetime_column2")
        val dateTimeColumn2: LocalDateTime?,
) {
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()

    companion object
}