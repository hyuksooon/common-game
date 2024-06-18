package com.soon.common.domain.commonLog

import com.soon.common.domain.commonLog.model.CommonLogInfoCreateModel
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "common_log_info")
class CommonLogInfo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "common_log_info_no")
        val no: Int = 0,

        @Column(name = "service_no")
        val serviceNo: Int,

        @Column(name = "common_log_name")
        val logName: String,

        @Column(name = "common_log_description")
        val description: String,

        @Column(name = "int_column1_name")
        val intColumn1Name: String?,

        @Column(name = "int_column2_name")
        val intColumn2Name: String?,

        @Column(name = "double_column1_name")
        val doubleColumn1Name: String?,

        @Column(name = "double_column2_name")
        val doubleColumn2Name: String?,

        @Column(name = "datetime_column1_name")
        val dateTimeColumn1Name: String?,

        @Column(name = "datetime_column2_name")
        val dateTimeColumn2Name: String?,
) {
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()

    companion object {
        fun create(model: CommonLogInfoCreateModel) = CommonLogInfo(
                serviceNo = model.serviceNo,
                logName = model.logName,
                description = model.description,
                intColumn1Name = model.intColumn1Name,
                intColumn2Name = model.intColumn2Name,
                doubleColumn1Name = model.doubleColumn1Name,
                doubleColumn2Name = model.doubleColumn2Name,
                dateTimeColumn1Name = model.dateTimeColumn1Name,
                dateTimeColumn2Name = model.dateTimeColumn2Name,
        )
    }
}