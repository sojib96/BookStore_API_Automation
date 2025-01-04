package constants;

import lombok.Getter;

@Getter
public enum AccountEndPoints {
    CREATE_ACCOUNT("/Account/v1/User"),
    GENERATE_TOKEN("/Account/v1/GenerateToken"),
    AUTHORIZED_USER("/Account/v1/Authorized"),
    GET_USER("/Account/v1/User/"),
    DELETE_USER("/Account/v1/User/");

    private final String endPoint;

    AccountEndPoints(String endPoint) {
        this.endPoint = endPoint;
    }
}

