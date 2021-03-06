package bdd.devto;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class DevtoStepsDefinitions {

    WebDriver driver;

    @Before //wykonuje się przed każdym testem
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
    }
    @Given("Chrome browser open")
    public void chrome_browser_open() {
        driver = new ChromeDriver();
    }
    @When("go to devto main page")
    public void go_to_devto_main_page() {
        driver.get("https://dev.to/");
    }
    @When("click on first blog displayed")
    public void click_on_first_blog_displayed() {
        driver.findElement(By.className("crayons-story__body")).click();
    }
    @Then("should be redirected to blog page")
    public void should_be_redirected_to_blog_page() {

    }
}
