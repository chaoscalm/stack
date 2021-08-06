buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(Dep.aboutLibrariesGradlePlugin)
        classpath(Dep.androidGradlePlugin)
        classpath(Dep.daggerHiltGradlePlugin)
        classpath(Dep.detektGradlePlugin)
        classpath(Dep.firebaseCrashlyticsGradlePlugin)
        classpath(Dep.googleServicesPlugin)
        classpath(Dep.kotlinPlugin)
        classpath(Dep.ktlintGradlePlugin)
        classpath(Dep.metalavaGradlePlugin)
        classpath(Dep.screenshotTestingPlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jitpack()
    }

    configurations.all {
        // https://github.com/noties/Markwon/issues/148
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
