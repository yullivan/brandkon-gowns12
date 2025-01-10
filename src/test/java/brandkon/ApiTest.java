package brandkon;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    @Transactional
    void readBrandByCategory() {
        RestAssured
                .given()
                .when()
                .get("/brands?category=cafe") // 서버로 GET /products 요청
                .then()
                .statusCode(200); // 요청에 대한 서버 응답의 상태코드가 200인지 검증
    }

    @Test
    void readBrandByBrandId() {
        RestAssured
                .given()
                .when()
                .get("/brands/1")
                .then()
                .statusCode(200);
    }

    @Test
    void readCategories() {
        RestAssured
                .given()
                .when()
                .get("/categories")
                .then()
                .statusCode(200);
    }

    @Test
    void readProducts() {
        RestAssured
                .given()
                .when()
                .get("/products")
                .then()
                .statusCode(200);

        RestAssured
                .given()
                .when()
                .get("/products?brandId=1")
                .then()
                .statusCode(200);
    }

    @Test
    void readDetails() {
        RestAssured
                .given()
                .when()
                .get("/products/1")
                .then()
                .statusCode(200);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "1, ",
            ", 1",
            ", "
    })
    void readPopularProducts(String p1, String p2) {
        RestAssured
                .given()
                .queryParam("categoryId",p1)
                .queryParam("brandId", p2)
                .when()
                .get("/products/popular")
                .then()
                .statusCode(200);
    }
}