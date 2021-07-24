import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.net.URL
import kotlin.system.measureTimeMillis

val mapper = jacksonObjectMapper()

val resource: URL = object {}.javaClass.getResource("/jmdict-eng-common-3.1.0.json")
val resourceMin = object {}.javaClass.getResource("/jmdict-eng-common-3.1.0-min.json")


fun main(args: Array<String>) {
    for (n in 1..1) {
        val measureTimeMillis = measureTimeMillis {
            val a = readJson(resource)
            val b = readJson(resourceMin)
            println()
        }
        println("$n $measureTimeMillis")
    }
}

fun readJson(resource: URL) : Any{
    val text = resource.readText()
    val readValue = mapper.readValue<Any>(text)
    return readValue
}
