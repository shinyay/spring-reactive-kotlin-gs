package com.google.shinyay.controller

import com.google.shinyay.model.Person
import com.google.shinyay.repository.PersonRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class PersonController(val repository: PersonRepository) {

    @GetMapping("/person")
    fun findAll() = repository.findAll()

    @GetMapping("/person/{name}")
    fun findAllByName(@PathVariable("name") name: String): Flux<Person> =
            repository.findAllByName(name)
}