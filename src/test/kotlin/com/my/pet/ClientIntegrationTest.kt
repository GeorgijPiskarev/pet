package com.my.pet

import com.my.pet.model.dto.ClientListDto
import com.my.pet.model.dto.Credentials
import com.my.pet.security.AuthenticationDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.*
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlConfig


@Sql(scripts = ["/sql/users.sql", "/sql/clients.sql"], config = SqlConfig(encoding = "UTF-8"))
class ClientIntegrationTest : AbstractIntegrationTest() {
    private var URI: String = "/api/v1/clients"

    @Test
    fun `get all`() {
        val auth: ResponseEntity<Credentials> = testRestTemplate.postForEntity(
            "/api/v1/auth/login",
            AuthenticationDTO("gg111@mail.ru", "12345"),
            Credentials::class.java
        )
        println(auth.body?.token)
        Assertions.assertEquals(HttpStatus.OK, auth.statusCode)
        //TODO: рефакторинг для переиспользования
        val headers = HttpHeaders()
        headers.set("Authorization", auth.body?.token)

        val request: HttpEntity<*> = HttpEntity<Any?>(headers)

        val result: ResponseEntity<ClientListDto> = testRestTemplate.exchange(
            URI, HttpMethod.GET, request, ClientListDto::class.java
        )
        println(result)
        Assertions.assertEquals(HttpStatus.OK, result.statusCode)

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