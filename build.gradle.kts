// Buildscript dependencies and plugins
//----------------------------------------------------------------------------------------------------------------------

plugins {
    id("de.fayard.buildSrcVersions") version "0.6.1"
    id("com.eden.orchidPlugin") version "0.17.5"
    kotlin("jvm") version "1.3.50"
}

// Orchid setup
//----------------------------------------------------------------------------------------------------------------------
repositories {
    jcenter()
}

dependencies {
    val orchid_version = "0.17.5"
    compile("io.github.javaeden.orchid:OrchidCore:$orchid_version")
    orchidCompile("io.github.javaeden.orchid:OrchidCore:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidPosts:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidPages:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidWiki:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidNetlifyCMS:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidPluginDocs:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidSearch:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidWritersBlocks:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidSyntaxHighlighter:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidTaxonomies:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidFutureImperfect:$orchid_version")
    orchidRuntime("io.github.javaeden.orchid:OrchidAsciidoc:$orchid_version")
}

project.version = "1"

fun envOrProperty(name: String, required: Boolean = false): String? {
    val result = project.findProperty(name) as? String ?: System.getenv(name)
    check(result != null || required.not()) { "Missing required environment property:\n  export $name=\"...\"" }
    return result
}

project.version = "1"

orchid {
    val isProd = envOrProperty("env") == "prod"
    version = "${project.version}"
    theme = "FutureImperfect"
    environment = if (isProd) "production" else "debug"
    baseUrl = when {
        isProd && envOrProperty("PULL_REQUEST") == "true" -> envOrProperty("DEPLOY_URL", required = true)
        isProd -> envOrProperty("URL", required = true)
        else -> "http://localhost:8080"
    }

}

/** To update Gradle, run
 *    ./gradlew refreshVersions && ./gradlew wrapper
 ***/
tasks.withType<Wrapper> {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = findProperty("gradleLatestVersion") as? String ?: gradle.gradleVersion
}
