package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class TodoApiChainTests {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Test
    public void testCreateUpdateRetrieveTodo() {
        // Step 1: Create
        // Step 2: Update
        // Step 3: Retrieve and Validate
    }
}
