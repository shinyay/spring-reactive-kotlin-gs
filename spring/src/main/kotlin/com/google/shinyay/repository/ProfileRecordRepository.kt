package com.google.shinyay.repository

import com.google.shinyay.model.ProfileRecord
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ProfileRecordRepository : ReactiveCrudRepository<ProfileRecord, Long> {

    @Query("select p.* from profile_record p where p.profile_id = :profileId")
    fun findByProfileId(profileId: Long): Flux<ProfileRecord>
}