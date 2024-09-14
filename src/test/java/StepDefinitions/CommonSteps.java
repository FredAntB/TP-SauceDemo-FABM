package StepDefinitions;

import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CommonSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);

    @When("I set the user name text box with {string}")
    public void setUserNameTextBox(String username) {
        loginPage.setUserName(username);
    }

    @And("I set the password text box with {string}")
    public void setPasswordTextBox(String password) {
        loginPage.setPassword(password);
    }

    @And("I click on the login button")
    public void clickOnLoginButton() {
        loginPage.clickLoginButton();
    }
}
