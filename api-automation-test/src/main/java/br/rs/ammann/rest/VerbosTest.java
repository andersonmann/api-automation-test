package br.rs.ammann.rest;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class VerbosTest {
	
	@Test
	public void test() {
		ArrayList<String> names =
		given()
		.when()
			.get("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador")
		.then()
			.statusCode(200)
			.extract().path("meses.findAll{it != null}")
			;
		assertEquals(4, names.size());
	}

}
