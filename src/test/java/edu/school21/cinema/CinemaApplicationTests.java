package edu.school21.cinema;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

import io.qameta.allure.restassured.AllureRestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "security.user.password=pass")
public class CinemaApplicationTests {

    @LocalServerPort
    private int serverPort;

    @Test
    public void initRestAssured() {
        int code = given()
                .get("/")
                .then()
                .extract()
                .response().statusCode();
        assertThat(code, Matchers.equalTo(HttpStatus.SC_OK));
    }

}
