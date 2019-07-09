/**
 * 
 */
package br.rs.ammann.rest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

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

		given().
		when().
			get("http://restapi.wcaquino.me/ola").
		then().
			statusCode(200);
	}

	@Test
	public void devoConhecerMatchersHamcrest() {
		assertThat("Maria", Matchers.is("Maria"));
		assertThat(128, Matchers.isA(Integer.class));
		assertThat(128, Matchers.greaterThan(120));
		
		java.util.List<Integer> impares = Arrays.asList(1,3,5,7,9);
		assertThat(impares, hasSize(5));
		assertThat(impares, contains(1,3,5,7,9));
		assertThat(impares, hasItem(9));
		assertThat(impares, hasItems(9,5));
		assertThat(impares, containsInAnyOrder(9,5,1,7,3));
		
		assertThat("Maria", is(not("João")));
		assertThat("Maria", not("João"));
		assertThat("Maria", anyOf(is("Maria"),is("Joaquina")));
	}
	
	@Test
	public void devoValidarBody() {
		given()
		.when()
			.get("http://restapi.wcaquino.me/ola").
		then()
			.statusCode(200)
			.body(is("Ola Mundo!"))
			.body(containsString("Mundo"))
			.body(is(not(nullValue())));
		
	}
	
	
	

}