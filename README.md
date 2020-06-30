# Spring Reactive Kotlin Getting Started

Spring Reactive with WebFlux and R2DBC using Kotlin

## Description
### Dependencies
This project adds the followinf dependencies to use Reactive

```
repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("io.r2dbc:r2dbc-h2")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.boot.experimental:spring-boot-test-autoconfigure-r2dbc")
}
```

## Demo
### 1. Database Configuration for Connection and Schema

```kotlin
@Bean
fun initializer(connectionFactory: ConnectionFactory?): ConnectionFactoryInitializer? {

	val populator = CompositeDatabasePopulator().apply {
		addPopulators(ResourceDatabasePopulator(ClassPathResource("schema.sql")))
		addPopulators(ResourceDatabasePopulator(ClassPathResource("data.sql")))
	}

	return ConnectionFactoryInitializer().apply {
		setConnectionFactory(connectionFactory!!)
		setDatabasePopulator(populator)
	}
}
```

### 2. R2DBC Configuration

- *application.yml*

```yaml
spring:
  application:
    name: reactive-kotlin
  r2dbc:
    url: r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    name: sa
    password:
```

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
