package com.soon.common.application.commonLog.model

import com.soon.common.domain.commonLog.model.CommonLogInfoCreateModel

data class CommonLogInfoCreateCommand(
        val serviceNo: Int,
        val logName: String,
        val description: String,
        val intColumn1Name: String?,
        val intColumn2Name: String?,
        val doubleColumn1Name: String?,
        val doubleColumn2Name: String?,
        val dateTimeColumn1Name: String?,
        val dateTimeColumn2Name: String?,
) {
    fun toCreateModel() = CommonLogInfoCreateModel(
            serviceNo = serviceNo,
            logName = logName,
            description = description,
            intColumn1Name = intColumn1Name,
            intColumn2Name = intColumn2Name,
            doubleColumn1Name = doubleColumn1Name,
            doubleColumn2Name = doubleColumn2Name,
            dateTimeColumn1Name = dateTimeColumn1Name,
            dateTimeColumn2Name = dateTimeColumn2Name,
    )
}