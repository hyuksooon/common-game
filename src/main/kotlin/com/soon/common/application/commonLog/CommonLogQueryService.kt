package com.soon.common.application.commonLog

import com.soon.common.application.commonLog.model.CommonLogInfoGetSummary
import com.soon.common.domain.commonLog.CommonLogInfoRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CommonLogQueryService
(
        private val commonLogInfoRepository: CommonLogInfoRepository,
) {
    suspend fun getCommonLogInfo(serviceNo: Int, commonLogInfoNo: Int): CommonLogInfoGetSummary {

        return commonLogInfoRepository.findByIdOrNull(commonLogInfoNo)?.let {
            CommonLogInfoGetSummary.of(it)
        } ?: throw NotFoundException()
    }
}