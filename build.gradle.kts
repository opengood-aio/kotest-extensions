import io.opengood.gradle.enumeration.ProjectType

plugins {
    id("io.opengood.gradle.config") version "1.18.0"
}

group = "io.opengood.commons"

opengood {
    main {
        projectType = ProjectType.LIB
    }
    features {
        spring = false
    }
    artifact {
        description = "Commons library containing reusable functions, extensions, and objects for Kotlin"
    }
}
