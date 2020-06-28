package com.google.shinyay.repository

import com.google.shinyay.model.Employee
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface EmployeeRepository : ReactiveCrudRepository<Employee, Long> {

    @Query("select e.* from Employee e where e.last_name = :lastName")
    fun findEmployeeByLastName(lastName: String): Mono<Employee>

//    @Query("SELECT id, name, age FROM person WHERE name = :name")
//    fun findAllByName(name: String): Flux<Employee>
//
//    @Query("SELECT * FROM player WHERE age = :age")
//    fun findByAge(age: Int)
}