package StepDefinitions;

import Pages.CheckoutPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class CheckoutPageSteps {
    CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);

    @And("I fill checkout information with")
    public void fillCheckoutInformationWith(DataTable checkoutInformation) {
        List<String> data = checkoutInformation.transpose().asList();

        if(data.get(0) != null) { checkoutPage.setFirstNameTextBox(data.getFirst()); }
        if(data.get(1) != null) { checkoutPage.setLastNameTextBox(data.get(1)); }
        if(data.get(2) != null) { checkoutPage.setPostalCodeTextBox(data.get(2)); }
    }

    @And("I click on the continue button")
    public void clickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @Then("An error message is displayed")
    public void errorMessageIsDisplayed() {
        Assertions.assertTrue(checkoutPage.errorMessageIsDisplayed());
    }
}
