plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    api(libs.commons.math3)
    implementation(libs.guava)
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("2.3.0")
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }

    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["java"])
        }
    }
}
