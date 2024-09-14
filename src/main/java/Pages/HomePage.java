package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "product_sort_container")
    WebElement filterDropDown;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFilterOption(String filterOption)
    {
        Select selector = new Select(filterDropDown);
        selector.selectByVisibleText(filterOption);
    }

    public void clickCartLink()
    {
        shoppingCartLink.click();
    }
}
