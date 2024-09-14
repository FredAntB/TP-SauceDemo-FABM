package StepDefinitions;

import Pages.HomePage;
import Utilities.DriverManager;
import com.google.common.collect.Ordering;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePageSteps {
    HomePage homepage = new HomePage(DriverManager.getDriver().driver);

    private boolean checkSortByName(String order)
    {
        List<WebElement> products = DriverManager.getDriver().driver.findElements(By.className("inventory_item_name"));
        List<String> productsNames = new ArrayList<>();

        for(WebElement product : products)
        {
            // System.out.println(product.getText());
            productsNames.add(product.getText());
        }

        if(order.equals("ascending")) //Ascending means sorted from A to Z
            return Ordering.natural().isOrdered(productsNames);
        else if(order.equals("descending")) //Descending means sorted from Z to A
            return Ordering.natural().reverse().isOrdered(productsNames);
        else
            throw new RuntimeException(String.format("%s is not a valid way of sorting", order));
    }

    private boolean checkSortByPrice(String order)
    {
        List<WebElement> products = DriverManager.getDriver().driver.findElements(By.className("inventory_item_price"));
        List<Double> productsPrices = new ArrayList<>();

        for(WebElement product : products)
        {
            productsPrices.add(Double.parseDouble(product.getText().substring(1)));
        }

        if(order.equals("ascending"))
            return Ordering.natural().isOrdered(productsPrices);
        else if(order.equals("descending"))
            return Ordering.natural().reverse().isOrdered(productsPrices);
        else
            throw new RuntimeException(String.format("%s is not a valid way of sorting", order));
    }

    @Given("I sort the home page products by {string}")
    public void sortProductsBy(String option) {
        homepage.selectFilterOption(option);
    }

    @Then("The products should be sorted by {string} in {string} order")
    public void checkProductsAreSortedBy(String option, String order) {
        boolean isSorted;

        if(option.equals("name")) { isSorted = checkSortByName(order); }
        else if(option.equals("price")) { isSorted = checkSortByPrice(order); }
        else { throw new RuntimeException(String.format("%s is not a valid option", option)); }

        Assertions.assertTrue(isSorted);
    }

    @Given("I click on the cart icon")
    public void clickCartIcon() {
        homepage.clickCartLink();
    }
}
