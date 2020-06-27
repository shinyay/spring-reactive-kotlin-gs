package com.google.shinyay.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.core.DatabaseClient

@Configuration
class DBConfiguration(client: DatabaseClient) {
    init {
        client.execute {
            """
            CREATE TABLE IF NOT EXISTS profile (
                id SERIAL PRIMARY KEY,
                first_name VARCHAR(20) NOT NULL,
                last_name VARCHAR(20) NOT NULL,
                birth_date DATE NOT NULL
            );
            CREATE TABLE IF NOT EXISTS health_record(
                id SERIAL PRIMARY KEY,
                profile_id LONG NOT NULL,
                temperature DECIMAL NOT NULL,
                blood_pressure DECIMAL NOT NULL,
                heart_rate DECIMAL,
                date DATE NOT NULL
            );
            """
        }.also {
            it.then().subscribe()
        }
    }
}