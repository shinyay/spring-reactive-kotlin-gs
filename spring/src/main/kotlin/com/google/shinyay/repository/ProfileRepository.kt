package com.google.shinyay.repository

import com.google.shinyay.model.Profile
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfileRepository : ReactiveCrudRepository<Profile, Long>