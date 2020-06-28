package com.google.shinyay.repository

import com.google.shinyay.model.Person
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface PersonRepository : ReactiveCrudRepository<Person, Int> {

    @Query("SELECT id, name, age FROM person WHERE name = :name")
    fun findAllByName(name: String): Flux<Person>

    @Query("SELECT * FROM player WHERE age = :age")
    fun findByAge(age: Int)
}