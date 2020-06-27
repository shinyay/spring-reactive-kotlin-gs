package com.google.shinyay.controller

import com.google.shinyay.model.Profile
import com.google.shinyay.repository.ProfileRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ProfileController(val repository: ProfileRepository) {

    @PostMapping("/profile")
    fun save(@RequestBody profile: Profile): Mono<Profile> = repository.save(profile)
}