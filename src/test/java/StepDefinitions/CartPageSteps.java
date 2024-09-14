package StepDefinitions;

import Pages.CartPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;

public class CartPageSteps {
    CartPage cartPage = new CartPage(DriverManager.getDriver().driver);

    @And("I click on the checkout button")
    public void clickCheckoutButton() {
        cartPage.clickCheckoutButton();
    }
}
