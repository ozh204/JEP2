package TJE2;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import domain.Waffle;
import domain.Orders;
import com.jayway.restassured.RestAssured;

public class RestTest {

    @BeforeClass
    public static void initialize(){
        RestAssured.baseURI = "http://orzech-ms-7971";
        RestAssured.port = 8080;
        RestAssured.basePath = "/TJE2/api";
    }


//    @Test
//    public void addWaffle(){
//
//        Waffle waffle = new Waffle();
//
//        waffle.setType("Testowy");
//        waffle.setSugar("Tak");
//        waffle.setTopping("Nie");
//        waffle.setPrice(5);
//        waffle.setFruit("Tak");
//        waffle.setCream("Nie");
//
//        given().contentType(MediaType.APPLICATION_JSON).body(waffle).
//                when().post("/waffle/create").
//                then().statusCode(201);
//
//    }
//
//    @Test
//    public void getAllWaffles() {
//
//        when().get("/waffle/").
//                then().statusCode(200);
//
//    }

//    @Test
//    public void getWaffle() {
//
//        when().get("/waffle/details/1").
//                then().statusCode(200);
//
//    }

//    @Test
//    public void modifyWaffle() {
//
//        Waffle waffle = new Waffle();
//
//        waffle.setId(1L);
//        waffle.setType("Testowy2");
//        waffle.setSugar("Nie");
//        waffle.setTopping("Tak");
//        waffle.setPrice(55);
//        waffle.setFruit("Nie");
//        waffle.setCream("Tak");
//
//        given().contentType(MediaType.APPLICATION_JSON).body(waffle).
//                when().put("/waffle/edit").
//                then().statusCode(200);
//
//    }
//
//    @Test
//    public void deleteWaffle() {
//
//        given().when().delete("/waffle/delete/1").
//                then().statusCode(200);
//
//    }

}