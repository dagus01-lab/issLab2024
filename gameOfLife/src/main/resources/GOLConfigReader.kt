package main.resources

import com.fasterxml.jackson.module.kotlin.*
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
data class GOLConfig(
	val rows : Int = 10,
	val columns : Int = 10,
	val cellSize : Int = 10
)
object GOLConfigReader {

    private val mapper = ObjectMapper().registerKotlinModule()
    private lateinit var config : GOLConfig

    fun loadGOLConfig(filePath: String): GOLConfig {
        if(!::config.isInitialized)
            config = mapper.readValue(File(filePath))
        return config
    }
}