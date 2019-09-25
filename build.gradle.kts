// Buildscript dependencies and plugins
//----------------------------------------------------------------------------------------------------------------------

plugins {
    id("de.fayard.buildSrcVersions") version "0.6.1"
    id("com.eden.orchidPlugin") version "0.17.5"
}

// Orchid setup
//----------------------------------------------------------------------------------------------------------------------
repositories {
    jcenter()
}

dependencies {
    val orchid_version = "0.17.5"
    compile("io.github.javaeden.orchid:OrchidCore:${orchid_version}")
    orchidCompile("io.github.javaeden.orchid:OrchidCore:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidPosts:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidPages:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidWiki:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidNetlifyCMS:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidPluginDocs:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidSearch:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidWritersBlocks:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidSyntaxHighlighter:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidTaxonomies:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidFutureImperfect:${orchid_version}")
    orchidRuntime("io.github.javaeden.orchid:OrchidAsciidoc:${orchid_version}")
}

project.version = "1"

orchid {
    version = "${project.version}"
    theme = "FutureImperfect"

    if (project.hasProperty("env") && project.property("env") == "prod") {
        environment = "production"
        val isPullRequest = System.getenv("PULL_REQUEST")
        if(isPullRequest == "true") {
            baseUrl = System.getenv("DEPLOY_URL")
        }
        else {
            baseUrl = System.getenv("URL")
        }
    }
    else {
        environment = "debug"
        baseUrl = "http://localhost:8080"
    }
}
