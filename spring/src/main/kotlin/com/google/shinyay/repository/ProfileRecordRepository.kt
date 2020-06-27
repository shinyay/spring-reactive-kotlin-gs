package com.google.shinyay.repository

import com.google.shinyay.model.ProfileRecord
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfileRecordRepository : ReactiveCrudRepository<ProfileRecord, Long> {
}