package StepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
    @Before
    public void beforeScenario()
    {
        DriverManager.getDriver().driver.get("https://www.saucedemo.com/");
        DriverManager.getDriver().driver.manage().window().maximize();
    }

    @After
    public  void afterScenario(){
        DriverManager.getDriver().driver.quit();
    }
}
