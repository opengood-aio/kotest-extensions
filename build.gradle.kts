plugins {
    id("io.opengood.gradle.config")
}

group = "io.opengood.extensions"

opengood {
    features {
        spring = false
    }
    artifact {
        description = "Library containing reusable extensions and functions for Kotest"
    }
}

dependencies {
    implementation("io.kotest:kotest-extensions-junit5:_")
    implementation("io.kotest:kotest-runner-junit5:_")
    implementation(files("/Users/cjaehnen/workspace/opengood/config-gradle-plugin/build/libs/config-gradle-plugin-2.12.0-SNAPSHOT.jar"))
}

tasks.named("javadocJar").configure {
    enabled = false
}
