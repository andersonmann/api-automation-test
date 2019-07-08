/**
 * 
 */
package br.rs.ammann.rest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

/**
 * @author andersonmann
 *
 */
public class HelloWorld {
	public static void main(String[] args) {
		Response response = RestAssured.request(Method.GET, "http://restapi.wcaquino.me/ola");
		System.out.println(response.getBody().asString().equals("Ola Mundo!"));
		System.out.println(response.getStatusCode() == 200);

		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
	}
}