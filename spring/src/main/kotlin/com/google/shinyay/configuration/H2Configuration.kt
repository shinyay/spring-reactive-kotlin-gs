package com.google.shinyay.configuration

import com.google.shinyay.model.Employee
import com.google.shinyay.repository.EmployeeRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.stream.Stream

@Component
class ApplicationConfiguration {

    @Bean
    fun runner(employeeRepository: EmployeeRepository, db: DatabaseClient) = ApplicationRunner {
        val initDb = db.execute {
            """ CREATE TABLE employee (
                    id SERIAL PRIMARY KEY,
                    first_name VARCHAR(255) NOT NULL,
                    last_name VARCHAR(255) NOT NULL
                );
            """
        }

        val stream = Stream.of(
                Employee(null, "Shinya", "Yanagihara")
        )

        val saveAll = employeeRepository.saveAll(Flux.fromStream(stream))

        initDb // initialize the database
                .then()
                .thenMany(saveAll) // then save our Sample Employees
                .subscribe() // execute
    }
}