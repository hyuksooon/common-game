package com.soon.common.application.commonLog.model

import com.soon.common.domain.commonLog.CommonLogInfo
import java.time.LocalDateTime

data class CommonLogInfoGetSummary(
        val commonLogInfoNo: Int,
        val logName: String,
        val description: String,
        val intColumn1Name: String?,
        val intColumn2Name: String?,
        val doubleColumn1Name: String?,
        val doubleColumn2Name: String?,
        val dateTimeColumn1Name: String?,
        val dateTimeColumn2Name: String?,
        val createdAt: LocalDateTime,
) {
    companion object {
        fun of(entity: CommonLogInfo) = CommonLogInfoGetSummary(
                commonLogInfoNo = entity.no,
                logName = entity.logName,
                description = entity.description,
                intColumn1Name = entity.intColumn1Name,
                intColumn2Name = entity.intColumn2Name,
                doubleColumn1Name = entity.doubleColumn1Name,
                doubleColumn2Name = entity.doubleColumn2Name,
                dateTimeColumn1Name = entity.dateTimeColumn1Name,
                dateTimeColumn2Name = entity.dateTimeColumn2Name,
                createdAt = entity.createdAt,
        )
    }
}