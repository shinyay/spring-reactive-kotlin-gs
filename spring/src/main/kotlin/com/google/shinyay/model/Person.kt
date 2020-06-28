package com.google.shinyay.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Person(@Id val id: Int,
                  val name: String,
                  val age: Int
)