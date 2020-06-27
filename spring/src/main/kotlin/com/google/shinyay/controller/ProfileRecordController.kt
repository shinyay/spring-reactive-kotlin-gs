package com.google.shinyay.controller

import com.google.shinyay.model.ProfileRecord
import com.google.shinyay.model.Status
import com.google.shinyay.repository.ProfileRecordRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
class ProfileRecordController(val repository: ProfileRecordRepository) {

    @PostMapping("/profile/{profileId}/record")
    fun storeProfileRecord(@PathVariable("profileId") profileId: Long, @RequestBody record: ProfileRecord): Mono<ProfileRecord>
            = repository.save(record)

    @GetMapping("/profile/{profileId}/average")
    fun fetchRecordAverage(@PathVariable("profileId") profileId: Long): Mono<Status>
    = repository.findByProfileId(profileId)
            .reduce(
                    Status(0, 0.0, 0.0, 0.0)
            , {s, r ->
                Status(s.cnt +1,
                s.temperature + r.temperature,
                s.bloodPressure + r.bloodPressure,
                s.heartRate + r.heartRate
                )
            }
            ).map { s ->
                Status(s.cnt,
                if (s.cnt !=0) s.temperature / s.cnt else 0.0
                        , if (s.cnt != 0) s.bloodPressure / s.cnt else 0.0
                        , if (s.cnt != 0) s.heartRate / s.cnt else 0.0)
            }
}