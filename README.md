# Kotest Extensions Library

[![Build](https://github.com/opengood-aio/kotest-extensions/workflows/build/badge.svg)](https://github.com/opengood-aio/kotest-extensions/actions?query=workflow%3Abuild)
[![Release](https://github.com/opengood-aio/kotest-extensions/workflows/release/badge.svg)](https://github.com/opengood-aio/kotest-extensions/actions?query=workflow%3Arelease)
[![CodeQL](https://github.com/opengood-aio/kotest-extensions/actions/workflows/codeql.yml/badge.svg)](https://github.com/opengood-aio/kotest-extensions/actions/workflows/codeql.yml)
[![Codecov](https://codecov.io/gh/opengood-aio/kotest-extensions/branch/main/graph/badge.svg?token=AEEYTGK87F)](https://codecov.io/gh/opengood-aio/kotest-extensions)
[![Release Version](https://img.shields.io/github/release/opengood-aio/kotest-extensions.svg)](https://github.com/opengood-aio/kotest-extensions/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/io.opengood.extensions/kotest-extensions.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.opengood.extensions%22%20AND%20a:%22kotest-extensions%22)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/opengood-aio/kotest-extensions/master/LICENSE)

Library containing reusable extensions and functions for Kotest

## Compatibility

* Java 21
* Spring Boot 3

## Setup

### Add Dependency

#### Gradle

```groovy
implementation("io.opengood.extensions:kotest-extensions:VERSION")
```

#### Maven

```xml
<dependency>
    <groupId>io.opengood.extensions</groupId>
    <artifactId>kotest-extensions</artifactId>
    <version>VERSION</version>
</dependency>
```

**Note:** See *Release* version badge above for latest version.

## Features

### Matchers

#### Map

* Assert list of maps are equal ignoring specific keys:

    Example:

    ```kotlin
    import io.opengood.extensions.kotest.matcher
    
    val expected = listOf(
        mapOf("foo" to "bar"),
        mapOf("foo" to "baz")
    )

    val items = listOf(
        mapOf(
            "none" to "none",
            "foo" to "bar"
        ),
        mapOf(
            "none" to "none",
            "foo" to "baz"
        )
    )

    items.shouldBeEqualIgnoringKeys(expected, "none")
    ```

* Assert map entries are equal:

    Example:

    ```kotlin
    import io.opengood.extensions.kotest.matcher
    
    fun makeEntry(key: String, value: String) = object : Map.Entry<String, String> {
        override val key: String = key
        override val value: String = value
    }

    val expected = makeEntry("foo", "bar")

    makeEntry("foo", "bar") shouldBeMapEntry expected
    ```
