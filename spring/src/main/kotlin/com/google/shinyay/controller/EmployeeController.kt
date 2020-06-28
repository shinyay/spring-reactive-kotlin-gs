package com.google.shinyay.controller

import com.google.shinyay.model.Employee
import com.google.shinyay.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
class EmployeeController(val repository: EmployeeRepository) {

    @GetMapping
    fun getAll() = repository.findAll()

    @GetMapping("/{lastName}")
    fun getByLastName(@PathVariable lastName: String) = repository.findEmployeeByLastName(lastName)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody employee: Employee) = repository.save(employee)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun save(@PathVariable id: Long) = repository.deleteById(id)
}