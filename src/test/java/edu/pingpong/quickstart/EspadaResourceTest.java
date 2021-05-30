package edu.pingpong.quickstart;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
// importado a mano equalTo

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.ws.rs.core.MediaType;

@QuarkusTest
@Transactional
public class EspadaResourceTest {
    @Test
    public void testListEndpoint() {
        List<Map<String, Object>> products =
                given()
                        .contentType(ContentType.JSON)
                        .when().get("/espadas")
                        .as(new TypeRef<List<Map<String, Object>>>() {
                        });

        Assertions.assertThat(products).hasSize(2);
        Assertions.assertThat(products.get(0)).containsKeys("nombre", "longitud");
    }

    @Test
    public void testList() {
        given()
                .contentType(ContentType.JSON)
                .when().get("/espadas")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "nombre", containsInAnyOrder("Dragonslayer", "Frostmourne"),
                        "longitud", containsInAnyOrder(100.0F, 200.0F),
                        "afilada", containsInAnyOrder(false, false)
                );
    }
    @Test
    public void testAddDelete() {
        given()
                .body("{\"nombre\": \"Excalibur\", \"longitud\": \"150.0F\", \"afilada\": \"false\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/espadas")
                .then()
                .statusCode(200);
        given()
                .when()
                .get("/espadas")
                .then()
                .body("$.size()", is(3),
                        "nombre", containsInAnyOrder("Dragonslayer", "Frostmourne","Excalibur"),
                        "longitud", containsInAnyOrder(100.0F, 200.0F, 150.0F));
        given()
                .when()
                .delete("/espadas/Excalibur")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "nombre", containsInAnyOrder("Dragonslayer", "Frostmourne"),
                        "longitud", containsInAnyOrder(100.0F, 200.0F));
    }
    public void getPathParamTest() {
        given()
                .pathParam("nombre", "Dragonslayer")
                .when()
                .get("/espadas/{nombre}")
                .then()
                .contentType(ContentType.JSON)
                .body("nombre", equalTo("Dragonslayer"),
                        "longitud", equalTo(200.0F),
                        "afilado", equalTo(false));

        given()
                .pathParam("nombre", "Excalibur")
                .when()
                .get("/espadas/{nombre}")
                .then()
                .statusCode(404);
    }
}
