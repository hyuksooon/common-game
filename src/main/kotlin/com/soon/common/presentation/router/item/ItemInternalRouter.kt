package com.soon.common.presentation.router.item

import com.soon.common.presentation.handler.ItemHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class ItemInternalRouter(private val itemHandler: ItemHandler) {
    @Bean
    fun itemBackOfficeRoute(): RouterFunction<ServerResponse> {
        return coRouter {
            (accept(MediaType.APPLICATION_JSON) and "/internal/common/item").nest {
                POST("", itemHandler::createItem)
            }
        }
    }
}
