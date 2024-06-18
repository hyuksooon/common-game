package com.soon.common.presentation.handler.commonLog

import com.soon.common.application.commonLog.CommonLogCommandService
import com.soon.common.application.commonLog.CommonLogQueryService
import com.soon.common.application.util.coroutines.ApplicationDispatchers
import com.soon.common.presentation.extension.extractServiceCodeHeader
import com.soon.common.presentation.extension.intQueryParam
import com.soon.common.presentation.handler.commonLog.model.CommonLogInfoCreateRequest
import com.soon.common.presentation.handler.commonLog.model.CommonLogInfoResponse
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.*

@Service
class CommonLogHandler(
        private val commonLogCommandService: CommonLogCommandService,
        private val commonLogQueryService: CommonLogQueryService,
) {
    suspend fun createCommonLogInfo(request: ServerRequest): ServerResponse = withContext(ApplicationDispatchers.IO) {
        val serviceHeader = request.extractServiceCodeHeader()
        val command = request.awaitBodyOrNull<CommonLogInfoCreateRequest>()?.toCommand(serviceHeader.no)
                ?: throw IllegalArgumentException()

        commonLogCommandService.createCommonLogInfo(command)
        ServerResponse.noContent().buildAndAwait()
    }

    suspend fun getCommonLogInfo(request: ServerRequest): ServerResponse = withContext(ApplicationDispatchers.IO) {
        val serviceHeader = request.extractServiceCodeHeader()
        val commonLogInfoNo = request.intQueryParam("commonLogInfoNo")
        val summary = commonLogQueryService.getCommonLogInfo(serviceHeader.no, commonLogInfoNo)
        ServerResponse.ok().bodyValueAndAwait(CommonLogInfoResponse.of(summary))
    }
}