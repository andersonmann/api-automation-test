/**
 * 
 */
package br.rs.ammann.rest;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

/**
 * @author andersonmann
 *
 */
public class HelloWorldTest {

	@Test
	public void testHelloWorld() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
		assertTrue(response.getBody().asString().equals("Ola Mundo!"));
		assertTrue(response.getStatusCode() == 200);
		assertEquals(200, response.getStatusCode());
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
	}

	@Test
	public void devoConhecerOutrasFormasRestAssured() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
		get("http://restapi.wcaquino.me/ola").then().statusCode(200);

		given() 
		.when() 
			.get("http://restapi.wcaquino.me/ola")
		.then()
			.statusCode(201);
	}
}