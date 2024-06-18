package com.soon.common.domain.commonLog.model

data class CommonLogInfoCreateModel(
        val serviceNo: Int,
        val logName: String,
        val description: String,
        val intColumn1Name: String?,
        val intColumn2Name: String?,
        val doubleColumn1Name: String?,
        val doubleColumn2Name: String?,
        val dateTimeColumn1Name: String?,
        val dateTimeColumn2Name: String?,
)