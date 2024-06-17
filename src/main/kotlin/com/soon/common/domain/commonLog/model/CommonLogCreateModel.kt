package com.soon.common.domain.commonLog.model

import java.time.LocalDateTime

data class CommonLogCreateModel(
        val commonLogInfoNo: Int,
        val intColumn1: Int?,
        val intColumn2: Int?,
        val doubleColumn1: Double?,
        val doubleColumn2: Double?,
        val dateTimeColumn1: LocalDateTime?,
        val dateTimeColumn2: LocalDateTime?,
)