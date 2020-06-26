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

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot.experimental:spring-boot-bom-r2dbc:0.1.0.M3")
	}
}
```

## Demo

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
