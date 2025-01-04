package models.requests;

import lombok.Getter;

@Getter
public class UserDataPayload {
    private String userName;
    private String password;
}