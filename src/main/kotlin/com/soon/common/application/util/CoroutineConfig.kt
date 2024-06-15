package com.soon.common.application.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.reactor.asCoroutineDispatcher
import kotlinx.coroutines.withContext
import org.springframework.transaction.support.TransactionSynchronizationManager
import org.springframework.transaction.support.TransactionTemplate
import reactor.core.scheduler.Schedulers
import kotlin.coroutines.CoroutineContext

val boundedElasticDispatcher= Schedulers.boundedElastic().asCoroutineDispatcher()

val boundedElasticScope:CoroutineScope
    get()= CoroutineScope(boundedElasticDispatcher)