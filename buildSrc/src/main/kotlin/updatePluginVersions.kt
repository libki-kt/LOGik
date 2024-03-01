import korlibs.io.file.std.localVfs
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import org.gradle.api.Project

@OptIn(ExperimentalSerializationApi::class)
fun Project.updatePluginVersions() = runBlocking {
    val propertiesFile = localVfs(projectDir.path)["gradle.properties"]

    val initialProperties = propertiesFile.readString().split('\n').associate {
        val pairs = it.replace(" ", "").split('=')
        pairs.first() to pairs[1]
    }.toMutableMap()

    if (initialProperties["kotlin.version"] != kotlin_version) {
        val targetProperties = initialProperties.apply {
            this["kotlin.version"] = kotlin_version
        }.toList().joinToString(
            separator = "\n"
        ) { pair ->
            "${pair.first} = ${pair.second}"
        }

        propertiesFile.writeString(targetProperties)
    }
}