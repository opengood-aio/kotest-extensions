import io.opengood.gradle.constant.Dependencies
import io.opengood.gradle.enumeration.ProjectType

plugins {
    id("io.opengood.gradle.config") version "1.22.0"
}

group = "io.opengood.extensions"

opengood {
    main {
        projectType = ProjectType.LIB
    }
    features {
        spring = false
    }
    artifact {
        description = "Library containing reusable extensions and functions for Kotest"
    }
}

dependencies {
    implementation(Dependencies.KOTEST)
    implementation(Dependencies.KOTEST_EXTENSIONS)
}
