package com.stl.AdminManager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminAddManagerApplicationTests {

    @Test
    @Order(1)
    public void testaddManager() {
        String jsonbody="{\"firstname\":\"Lekhaz\",\"lastname\":\"Suvari\",\"manageremail\":\"lekhaz@gmail.com\",\"phonenumber\":\"6303534597\",\"password\":\"lekhaz\",\"gender\":\"Male\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8082/adminManager/addmanager")
                .then()
                .assertThat().statusCode(201)
                .extract().response().asString();
    }
    
    
    @Test
    @Order(2)
    public void testgetallManagers() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8082/adminManager/get")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    @Test
    @Order(3)
    public void testgetbyManager() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8082/adminManager/get/lekhaz@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
    @Test
    @Order(4)
    public void testdeleteManager() {
        String jsonbody= "{\"email\" : \"pavan@gmail.com\",\"password\" : \"pavan0209\"}";
        String token=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .delete("http://localhost:8082/adminManager/delete/lekhaz@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
}
