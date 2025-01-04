package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.response.CreateUserResponse;
import models.response.GenerateTokenResponse;
import org.testng.Assert;
import services.AccountService;
import utils.SettingsTestData;

public class AccountSteps {

    private static final AccountService accountService = new AccountService();
    private static Response response;
    private CreateUserResponse createUserResponse;
    private GenerateTokenResponse generateTokenResponse;

    @Given("the user provides valid details to create a new account")
    public void theUserProvidesValidDetailsToCreateANewAccount() {
        response = accountService.createUser(SettingsTestData.getUserData());
        createUserResponse = response.getBody().as(CreateUserResponse.class);
    }

    @Then("the account should be successfully created with a non-null userId")
    public void theAccountShouldBeSuccessfullyCreatedWithANonNullUserId() {
        Assert.assertFalse(createUserResponse.getUserID().isEmpty(), "UserID is null");
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int arg0) {
        Assert.assertEquals(response.getStatusCode(), arg0, "Response code does not match");
    }

    @When("the user submits their details to generate an authentication key")
    public void theUserSubmitsTheirDetailsToGenerateAnAuthenticationKey() {
        response = accountService.generateToken(SettingsTestData.getUserData());
        generateTokenResponse = response.getBody().as(GenerateTokenResponse.class);
    }

    @Then("the response status should be {string}")
    public void theResponseStatusShouldBe(String arg0) {
        Assert.assertEquals(response.getBody().jsonPath().getString("status"), arg0, "Status does not match");
    }

    @When("the user includes the authentication key in the request body for authorization")
    public void theUserIncludesTheAuthenticationKeyInTheRequestBodyForAuthorization() {
        response = accountService.authorized(SettingsTestData.getUserData(), generateTokenResponse.getToken());
    }

    @Then("the user should receive a response body of {string}")
    public void theUserShouldReceiveAResponseBodyOf(String arg0) {
        Assert.assertEquals(response.getBody().asString(), arg0, "User is not authorized");
    }

    @When("the user submits the unique userId to retrieve account details")
    public void theUserSubmitsTheUniqueUserIdToRetrieveAccountDetails() {
        response = accountService.getUser(createUserResponse.getUserID(), generateTokenResponse.getToken());
    }

    @Then("the system should return the user's complete information containing same userId")
    public void theSystemShouldReturnTheUserSCompleteInformationContainingTheUserId() {
        Assert.assertEquals(response.getBody().jsonPath().getString("userId"), createUserResponse.getUserID(), "User id does not match");
    }

    @When("the user provides the unique userId to delete the account")
    public void theUserProvidesTheUniqueUserIdToDeleteTheAccount() {
        response = accountService.deleteUser(createUserResponse.getUserID(), generateTokenResponse.getToken());
    }

    @Then("the user should receive a return code of {int}")
    public void theUserShouldReceiveAReturnCodeOf(int arg0) {
        Assert.assertEquals(response.getBody().jsonPath().getInt("code"), arg0, "User is not authorized to delete the account");
    }
}
