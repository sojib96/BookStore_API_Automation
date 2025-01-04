package models.response;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateUserResponse {
    private String userID;
    private String username;
    private List<String> books;
}

