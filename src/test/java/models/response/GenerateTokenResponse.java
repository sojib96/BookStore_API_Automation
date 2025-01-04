package models.response;

import lombok.Getter;

@Getter
public class GenerateTokenResponse {
    private String token;
    private String expires;
    private String status;
    private String result;
}
