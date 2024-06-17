package com.soon.common.presentation.handler.commonLog.model

import com.soon.common.application.commonLog.model.CommonLogInfoGetSummary
import java.time.LocalDateTime

data class CommonLogInfoResponse(
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
        fun of(summary: CommonLogInfoGetSummary) = CommonLogInfoResponse(
                commonLogInfoNo = summary.commonLogInfoNo,
                logName = summary.logName,
                description = summary.description,
                intColumn1Name = summary.intColumn1Name,
                intColumn2Name = summary.intColumn2Name,
                doubleColumn1Name = summary.doubleColumn1Name,
                doubleColumn2Name = summary.doubleColumn2Name,
                dateTimeColumn1Name = summary.dateTimeColumn1Name,
                dateTimeColumn2Name = summary.dateTimeColumn2Name,
                createdAt = summary.createdAt,
        )
    }
}

