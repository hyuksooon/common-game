package com.soon.common.presentation.router.commonLog

import com.soon.common.presentation.handler.commonLog.CommonLogHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class CommonLogRouter(private val commonLogHandler: CommonLogHandler) {
    @Bean
    fun commonLogRoute(): RouterFunction<ServerResponse> {
        return coRouter {
            (accept(MediaType.APPLICATION_JSON) and "/common/commonLog").nest {
                POST("info", commonLogHandler::createCommonLogInfo)
                GET("info", commonLogHandler::getCommonLogInfo)
            }
        }
    }
}
