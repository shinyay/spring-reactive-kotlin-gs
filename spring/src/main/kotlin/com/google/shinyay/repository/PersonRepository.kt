package com.google.shinyay.repository

import com.google.shinyay.model.Person
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface PersonRepository : ReactiveCrudRepository<Person, Int> {

    @Query("select id, name, age from person where name = :name")
    fun findAllByName(name: String): Flux<Person>

    @Query("select * from player where age = :age")
    fun findByAge(age: Int)
}