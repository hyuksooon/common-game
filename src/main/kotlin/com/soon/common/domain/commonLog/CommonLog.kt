package com.soon.common.domain.commonLog

import com.soon.common.domain.commonLog.model.CommonLogCreateModel
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "common_log")
class CommonLog(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "common_log_no")
        val no: Int = 0,

        @Column(name = "common_log_info_no")
        val commonLogInfoNo: Int,

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

    companion object {
        fun create(model: CommonLogCreateModel) = CommonLog(
                commonLogInfoNo = model.commonLogInfoNo,
                intColumn1 = model.intColumn1,
                intColumn2 = model.intColumn2,
                doubleColumn1 = model.doubleColumn1,
                doubleColumn2 = model.doubleColumn2,
                dateTimeColumn1 = model.dateTimeColumn1,
                dateTimeColumn2 = model.dateTimeColumn2,
        )
    }
}