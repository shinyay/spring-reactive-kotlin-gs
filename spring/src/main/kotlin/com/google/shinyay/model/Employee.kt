package com.google.shinyay.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("employee")
data class Employee(@Id val id: Long?,
                    @Column("first_name") val firstName: String,
                    @Column("last_name")val lastName: String
){constructor(firstName: String, lastName: String) : this(id = null, firstName = firstName, lastName = lastName) }