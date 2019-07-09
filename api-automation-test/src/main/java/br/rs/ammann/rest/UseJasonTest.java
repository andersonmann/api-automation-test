/**
 * 
 */
package br.rs.ammann.rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author andersonmann
 *
 */
public class UseJasonTest {
	
	@Test
	public void deveVerificarPrimeiroNivel() {
		given()
		.when()
			.get("http://restapi.wcaquino.me/users/1").
		then()
			.statusCode(200)
			.body("id", is(1))
			.body("name", containsString("Silva"))
			.body("age", greaterThan(18));
	}
	
	@Test
	public void deveVerificarPrimeiroNivelOutrasFormas() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me/users/1");
		//path
		Assert.assertEquals(new Integer(1), response.path("id"));
		
		//jsonpath
		JsonPath jsonPath = new JsonPath(response.asString());
		assertEquals(1, jsonPath.getInt("id"));
		
		//from
		int id = JsonPath.from(response.asString()).getInt("id");
		assertEquals(1, id);	
				
	}

}
