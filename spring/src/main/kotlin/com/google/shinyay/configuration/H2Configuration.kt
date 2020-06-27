package com.google.shinyay.configuration

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration

@Configuration
class H2Configuration : AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory() = H2ConnectionFactory(
            H2ConnectionConfiguration.builder()
                    .url("mem:testdb;DB_CLOSE_DELAY=-1;TRACE_LEVEL_FILE=4")
                    .username("sa")
                    .build())
}