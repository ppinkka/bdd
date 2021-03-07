package bdd.devto;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class DevtoStepsDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    String firstBlogTitle;
    String firstPodcastTitle;
    String searchPhrase;

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

    @When("I search for {string} phrase")
    public void i_search_for_phrase(String phrase) {
        WebElement searchbar = driver.findElement(By.name("q"));
        searchbar.sendKeys(phrase);
        searchPhrase = phrase;
        searchbar.sendKeys(Keys.ENTER); // Keys.RETURN to to samo
    }
    @Then("top {int} blogs found should have the keyword in title")
    public void top_blogs_found_should_have_the_keyword_in_title(Integer int1) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.crayons-story__title")));
        wait.until(ExpectedConditions.attributeContains(By.id("substories"),"class","search-results-loaded"));
        List<WebElement> allPosts = driver.findElements(By.cssSelector(".crayons-story__title > a"));
        if (allPosts.size()>=int1) {
            for (int i=0; i<int1; i++) {
                WebElement singlePost = allPosts.get(i);
                String singlePostTitle = singlePost.getText().toLowerCase();
                Boolean containsKeyword = singlePostTitle.contains(searchPhrase);
                Assert.assertTrue(containsKeyword);
            }
        }
    }
}
