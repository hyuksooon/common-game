package com.soon.common


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.soon.common.domain"])
class CommonApplication

fun main(args: Array<String>) {
    runApplication<CommonApplication>(*args)
}
