package com.my.pet

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(classes = [PetApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class AbstractIntegrationTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    protected val objectMapper = jacksonObjectMapper()

    protected fun assertEqualsAsJson(expectedObj: Any?, actualObj: Any?, strict: Boolean = false) {
        val expectedStr: String = if (expectedObj !is String) objectMapper.writeValueAsString(expectedObj)
        else expectedObj
        val actualStr: String = if (actualObj !is String) objectMapper.writeValueAsString(actualObj)
        else actualObj
        JSONAssert.assertEquals(expectedStr, actualStr, strict)
    }

    protected fun readJson(filePath: String): String {
        return this.javaClass.classLoader.getResource(filePath).readText()
    }
}