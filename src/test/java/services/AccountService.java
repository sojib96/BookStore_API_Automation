package services;

import constants.AccountEndPoints;
import io.restassured.response.Response;

public class AccountService extends BaseService {

    public Response createUser(Object userPayload) {
        Response response = post(AccountEndPoints.CREATE_ACCOUNT.getEndPoint(), userPayload, false, null);
        validateResponse(response);
        return response;
    }

    public Response generateToken(Object userPayload) {
        Response response = post(AccountEndPoints.GENERATE_TOKEN.getEndPoint(), userPayload, false, null);
        validateResponse(response);
        return response;
    }

    public Response authorized(Object userPayload, String authToken) {
        Response response = post(AccountEndPoints.AUTHORIZED_USER.getEndPoint(), userPayload, true, authToken);
        validateResponse(response);
        return response;
    }

    public Response getUser(String userId, String authToken) {
        Response response = get(AccountEndPoints.GET_USER.getEndPoint(), userId, authToken);
        validateResponse(response);
        return response;
    }

    public Response deleteUser(String userId, String authToken) {
        Response response = delete(AccountEndPoints.DELETE_USER.getEndPoint(), userId, authToken);
        validateResponse(response);
        return response;
    }
}
