plugins { id("org.jetbrains.kotlin.js") version "1.3.50" }
repositories { mavenCentral() }

group = "dev.rocky"
version = "1.0-SNAPSHOT"

kotlin {
    target {
        useCommonJs()
        nodejs()
    }

    sourceSets["main"].dependencies {
        implementation(kotlin("stdlib-js"))
    }
}
