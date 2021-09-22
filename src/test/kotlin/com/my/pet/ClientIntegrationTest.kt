package com.my.pet

import org.junit.jupiter.api.Test

class ClientIntegrationTest : AbstractIntegrationTest() {
    private var URI: String = "/api/v1/clients"

    @Test
    fun `get all`() {
        //TODO: переписать закомментированный код
//        val clients : List<Client> = objectMapper.readValue(readJson())
//
//        val result: ResponseEntity<List<Client>> = testRestTemplate.getForEntity(
//            URI,
//            new Parametr
//        )
    }

    @Test
    fun `get by id`() {

    }

    @Test
    fun create() {
    }

    @Test
    fun `delete by id`() {
    }
}