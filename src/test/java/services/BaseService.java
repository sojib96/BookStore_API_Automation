package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.SettingsTestData;

public abstract class BaseService {
    private static final String BASE_URL = SettingsTestData.getEnvData().getBaseUrl();

    protected RequestSpecification getRequestSpecification() {
        return RestAssured.given().baseUri(BASE_URL);
    }

    private RequestSpecification addAuthorizationHeader(RequestSpecification requestSpec, String authToken) {
        return requestSpec.header("Authorization", "Bearer " + authToken);
    }

    protected Response get(String endPoint, String userId, String authToken) {
        RequestSpecification requestSpec = getRequestSpecification();
        requestSpec = addAuthorizationHeader(requestSpec, authToken);
        return requestSpec.get(endPoint + userId);
    }

    protected Response post(String endPoint, Object payload, boolean authRequired, String authToken) {
        RequestSpecification requestSpec = getRequestSpecification().body(payload).contentType(ContentType.JSON);
        if (authRequired) {
            requestSpec = addAuthorizationHeader(requestSpec, authToken);
        }
        return requestSpec.post(endPoint);
    }

    protected Response delete(String endPoint, String userId, String authToken) {
        RequestSpecification requestSpec = getRequestSpecification();
        requestSpec = addAuthorizationHeader(requestSpec, authToken);
        return requestSpec.delete(endPoint + userId);
    }

    protected void validateResponse(Response response) {
        if (response.getStatusCode() != 200 && response.getStatusCode() != 201) {
            throw new RuntimeException("API call failed with status code " + response.getStatusCode() + ": " + response.getBody().asString());
        }
    }
}
