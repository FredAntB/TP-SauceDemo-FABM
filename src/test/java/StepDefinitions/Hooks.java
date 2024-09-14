package StepDefinitions;

import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
    LoginPage loginPage;

    @Before
    public void beforeScenario()
    {
        DriverManager.getDriver().driver.get("https://www.saucedemo.com/");
        DriverManager.getDriver().driver.manage().window().maximize();
    }
}
