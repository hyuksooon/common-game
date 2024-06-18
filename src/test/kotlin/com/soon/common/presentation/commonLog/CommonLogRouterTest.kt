package com.soon.common.presentation.commonLog

import com.epages.restdocs.apispec.ResourceDocumentation.resource
import com.epages.restdocs.apispec.ResourceSnippetParameters.Companion.builder
import com.ninjasquad.springmockk.MockkBean
import com.soon.common.application.commonLog.CommonLogCommandService
import com.soon.common.application.commonLog.CommonLogQueryService
import com.soon.common.application.commonLog.model.CommonLogInfoGetSummary
import com.soon.common.presentation.handler.commonLog.CommonLogHandler
import com.soon.common.presentation.handler.commonLog.model.CommonLogInfoCreateRequest
import com.soon.common.presentation.router.commonLog.CommonLogRouter
import io.mockk.coEvery
import io.mockk.coJustRun
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.ApplicationContext
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation
import org.springframework.restdocs.webtestclient.WebTestClientRestDocumentation.document
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.LocalDateTime

@ExtendWith(RestDocumentationExtension::class, SpringExtension::class, MockKExtension::class)
@ContextConfiguration(classes = [CommonLogRouter::class, CommonLogHandler::class])
@AutoConfigureRestDocs
@AutoConfigureWebFlux
@WebFluxTest
class CommonLogRouterTest(private val context: ApplicationContext) {

    private lateinit var webTestClient: WebTestClient


    @MockkBean
    private lateinit var commonLogQueryService: CommonLogQueryService

    @MockkBean
    private lateinit var commonLogCommandService: CommonLogCommandService


    @BeforeEach
    fun setUp(restDocumentation: RestDocumentationContextProvider) {
        webTestClient = WebTestClient.bindToApplicationContext(context)
                .configureClient()
                .baseUrl("http://localhost:8084")
                .filter(WebTestClientRestDocumentation.documentationConfiguration(restDocumentation))
                .build()
    }

    @Test
    fun `공통 로그 정보 조회 api`() {
        val commonLogInfoNo = 1

        val summary = CommonLogInfoGetSummary(
                commonLogInfoNo = 1,
                logName = "logName",
                description = "description",
                intColumn1Name = "intColumn1Name",
                intColumn2Name = "intColumn2Name",
                doubleColumn1Name = "doubleColumn1Name",
                doubleColumn2Name = "doubleColumn2Name",
                dateTimeColumn1Name = "dateTimeColumn1Name",
                dateTimeColumn2Name = "dateTimeColumn2Name",
                createdAt = LocalDateTime.now(),
        )

        coEvery { commonLogQueryService.getCommonLogInfo(any(), any()) } returns summary
        webTestClient.get()
                .uri("/common/commonLog/info?commonLogInfoNo={commonLogInfoNo}", commonLogInfoNo)
                .header("Service-Code", "eyJubyI6MSwidGl0bGUiOiJ0aXRsZSJ9")
                .exchange()
                .expectStatus().isOk
                .expectBody().consumeWith(
                        document(
                                "common-log-create",
                                resource(
                                        builder()
                                                .tag("common-log")
                                                .description("공통 로그 정보 조회")
                                                .queryParameters(
                                                        parameterWithName("commonLogInfoNo").description("공통 로그 정보 시퀀스")
                                                )
                                                .responseFields(
                                                        fieldWithPath("commonLogInfoNo").type(JsonFieldType.NUMBER).description("공통 로그 정보 시퀀스").optional(),
                                                        fieldWithPath("logName").type(JsonFieldType.STRING).description("공통 로그 정보 이름"),
                                                        fieldWithPath("description").type(JsonFieldType.STRING).description("공통 로그 정보 설명"),
                                                        fieldWithPath("intColumn1Name").type(JsonFieldType.STRING).description("정수 칼럼1 이름"),
                                                        fieldWithPath("intColumn2Name").type(JsonFieldType.STRING).description("정수 칼럼2 이름"),
                                                        fieldWithPath("doubleColumn1Name").type(JsonFieldType.STRING).description("소수 칼럼1 이름"),
                                                        fieldWithPath("doubleColumn2Name").type(JsonFieldType.STRING).description("소수 칼럼2 이름"),
                                                        fieldWithPath("dateTimeColumn1Name").type(JsonFieldType.STRING).description("날짜 칼럼1 이름"),
                                                        fieldWithPath("dateTimeColumn2Name").type(JsonFieldType.STRING).description("날짜 칼럼2 이름"),
                                                        fieldWithPath("createdAt").type(JsonFieldType.STRING).description("공통 로그 정보 생성 시각"),
                                                ).build()
                                )
                        )
                )
    }

    @Test
    fun `공통 로그 정보 생성 api`() {

        val request = CommonLogInfoCreateRequest(
                logName = "logName",
                description = "description",
                intColumn1Name = "intColumn1Name",
                intColumn2Name = "intColumn2Name",
                doubleColumn1Name = "doubleColumn1Name",
                doubleColumn2Name = "doubleColumn2Name",
                dateTimeColumn1Name = "dateTimeColumn1Name",
                dateTimeColumn2Name = "dateTimeColumn2Name",
        )

        coJustRun { commonLogCommandService.createCommonLogInfo(any()) }
        webTestClient.post()
                .uri("/common/commonLog/info")
                .header("Service-Code", "eyJubyI6MSwidGl0bGUiOiJ0aXRsZSJ9")
                .bodyValue(request)
                .exchange()
                .expectStatus().isNoContent
                .expectBody().consumeWith(
                        document(
                                "common-log",
                                resource(
                                        builder()
                                                .tag("common-log")
                                                .description("공통 로그 정보 조회")
                                                .requestFields(
                                                        fieldWithPath("logName").type(JsonFieldType.STRING).description("공통 로그 정보 이름"),
                                                        fieldWithPath("description").type(JsonFieldType.STRING).description("공통 로그 정보 설명"),
                                                        fieldWithPath("intColumn1Name").type(JsonFieldType.STRING).description("정수 칼럼1 이름"),
                                                        fieldWithPath("intColumn2Name").type(JsonFieldType.STRING).description("정수 칼럼2 이름"),
                                                        fieldWithPath("doubleColumn1Name").type(JsonFieldType.STRING).description("소수 칼럼1 이름"),
                                                        fieldWithPath("doubleColumn2Name").type(JsonFieldType.STRING).description("소수 칼럼2 이름"),
                                                        fieldWithPath("dateTimeColumn1Name").type(JsonFieldType.STRING).description("날짜 칼럼1 이름"),
                                                        fieldWithPath("dateTimeColumn2Name").type(JsonFieldType.STRING).description("날짜 칼럼2 이름"),
                                                ).build()
                                )
                        )
                )
    }
}