package bdd.devto;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevtoStepsDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    String firstBlogTitle;
    String firstPodcastTitle;

    @Before //wykonuje się przed każdym testem
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Given("go to devto main page")
    public void go_to_devto_main_page() {
        driver.get("https://dev.to/");
    }
    @When("click on first blog displayed")
    public void click_on_first_blog_displayed() {
        WebElement firstBlog = driver.findElement(By.cssSelector("h2.crayons-story__title > a"));
        firstBlogTitle = firstBlog.getText();
        firstBlog.click();
    }
    @Then("should be redirected to blog page")
    public void should_be_redirected_to_blog_page() {
        wait.until(ExpectedConditions.titleContains(firstBlogTitle));
        WebElement blogTitle = driver.findElement(By.tagName("h1"));
        String blogTitleText = blogTitle.getText();
        Assert.assertEquals(firstBlogTitle, blogTitleText);
    }

    @When("I click on podcasts")
    public void i_click_on_podcasts() {
        WebElement podcasts = driver.findElement(By.partialLinkText("Podcasts"));
        podcasts.click();
    }
    @When("I click on first podcast displayed")
    public void i_click_on_first_podcast_displayed() {
        wait.until(ExpectedConditions.titleContains("Podcasts"));
        WebElement firstPodcast = driver.findElement(By.tagName("h3"));
        firstPodcastTitle = firstPodcast.getText();
        firstPodcastTitle = firstPodcastTitle.replace("podcast","");
        firstPodcast.click();
    }
    @Then("should be redirected to podcast")
    public void should_be_redirected_to_podcast() {
        wait.until(ExpectedConditions.titleContains(firstPodcastTitle));
        WebElement podcastTitle = driver.findElement(By.tagName("h1"));
        String podcastTitleText = podcastTitle.getText();
        Assert.assertEquals(firstPodcastTitle, podcastTitleText);
    }
}
