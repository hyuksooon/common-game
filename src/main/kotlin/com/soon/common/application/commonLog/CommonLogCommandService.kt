package com.soon.common.application.commonLog

import com.soon.common.application.commonLog.model.CommonLogInfoCreateCommand
import com.soon.common.domain.commonLog.CommonLogInfo
import com.soon.common.domain.commonLog.CommonLogInfoRepository
import org.springframework.stereotype.Service


@Service
class CommonLogCommandService
(
        private val commonLogInfoRepository: CommonLogInfoRepository,
) {
    suspend fun createCommonLogInfo(command: CommonLogInfoCreateCommand) {

        commonLogInfoRepository.save(CommonLogInfo.create(command.toCreateModel()))
    }
}