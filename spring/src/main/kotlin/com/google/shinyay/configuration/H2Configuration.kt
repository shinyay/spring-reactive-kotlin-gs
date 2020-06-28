package com.google.shinyay.configuration

import com.google.shinyay.model.Employee
import com.google.shinyay.repository.EmployeeRepository
import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator
import org.springframework.stereotype.Component


@Component
class ApplicationConfiguration(val repository: EmployeeRepository) : ApplicationRunner {

    @Bean
    fun initializer(connectionFactory: ConnectionFactory?): ConnectionFactoryInitializer? {
        val initializer = ConnectionFactoryInitializer()
        initializer.setConnectionFactory(connectionFactory!!)
        val populator = CompositeDatabasePopulator()
        populator.addPopulators(ResourceDatabasePopulator(ClassPathResource("schema.sql")))
        populator.addPopulators(ResourceDatabasePopulator(ClassPathResource("data.sql")))
        initializer.setDatabasePopulator(populator)
        return initializer
    }

    override fun run(args: ApplicationArguments?) {
        repository
                .saveAll(listOf(
                        Employee("Shinji", "Ikari"),
                        Employee("Asuka", "Soryu")
                )).thenMany(
                        repository.findAll()
                )
                .subscribe()
    }
}