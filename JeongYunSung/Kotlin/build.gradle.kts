group = "triple.idiots.jeongyunsung"
version = "0.0.1"

plugins {
    id("jys.kotlin-convention")
}

tasks.named("runKtlintFormatOverMainSourceSet") {
    enabled = false
}

repositories {
    mavenCentral()
}
