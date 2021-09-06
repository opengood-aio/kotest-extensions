# Kotest Extensions Library

[![Build](https://github.com/opengoodio/kotest-extensions/workflows/build/badge.svg)](https://github.com/opengoodio/kotest-extensions/actions?query=workflow%3Abuild)
[![Release](https://github.com/opengoodio/kotest-extensions/workflows/release/badge.svg)](https://github.com/opengoodio/kotest-extensions/actions?query=workflow%3Arelease)
[![Codecov](https://codecov.io/gh/opengoodio/kotest-extensions/branch/main/graph/badge.svg?token=AEEYTGK87F)](https://codecov.io/gh/opengoodio/kotest-extensions)
[![Release Version](https://img.shields.io/github/release/opengoodio/kotest-extensions.svg)](https://github.com/opengoodio/kotest-extensions/releases/latest)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.opengood.extensions/kotest-extensions/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.opengood.extensions/kotest-extensions)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/opengoodio/kotest-extensions/master/LICENSE)
[![FOSSA](https://app.fossa.com/api/projects/custom%2B22161%2Fgithub.com%2Fopengoodio%2Fkotest-extensions.svg?type=small)](https://app.fossa.com/projects/custom%2B22161%2Fgithub.com%2Fopengoodio%2Fkotest-extensions?ref=badge_small)

Library containing reusable extensions and functions for Kotest

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