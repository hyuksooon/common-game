package com.soon.member.presentation.extension

import com.soon.common.domain.extension.decodeBase64ToDto
import com.soon.common.presentation.extension.ServiceHeader
import org.springframework.web.reactive.function.server.ServerRequest

fun ServerRequest.extractMemberCodeHeader() :MemberHeader{
    return headers().header("Member-Code").firstOrNull()
    ?.let{
        it.decodeBase64ToDto<MemberHeader>()
    }?:throw IllegalArgumentException()
}

fun ServerRequest.extractServiceCodeHeader() :ServiceHeader{
    return headers().header("Service-Code").firstOrNull()
        ?.let{
            it.decodeBase64ToDto<ServiceHeader>()
        }?:throw IllegalArgumentException()
}