package bdd.devto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SinglePodcastPage {

    WebDriver driver;

    @FindBy(id = "record")
    WebElement playButton;
    @FindBy(className = "status-message")
    public WebElement initializing;
    @FindBy(xpath = "//img[contains(@class,'pause-butt')]")
    public WebElement pauseBtn;

    public SinglePodcastPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver , this);
    }
    public void playPodcast(){
        playButton.click();
    }
}
