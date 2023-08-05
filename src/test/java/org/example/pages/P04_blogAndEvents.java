package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_blogAndEvents {
    public P04_blogAndEvents() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(css = "a[href=\"/blog\"]")
    public WebElement blogBtn;

    @FindBy(css = ".IntroSection_left__bVTZo")
    public WebElement launchSentence;

    @FindBy(css = "div[class=\"Input_container__uEvQB\"] input[name=\"email\"]")
    public WebElement launchEmail;

    @FindBy(xpath = "//div[@class='BlogPage_blogEmail__jlETn']//button[@type='button'][normalize-space()='Enter']")
    public WebElement enterBtn;

    @FindBy(css = ".MessageRecieved_desc__mVY3g")
    public WebElement successMessage;
    @FindBy(xpath = "//p[normalize-space()='You are already subscribed']")
    public WebElement warningText;

    @FindBy(css = "a[href=\"/events\"]")
    public WebElement eventBtn;
    @FindBy(xpath = "//p[normalize-space()='Manhattan Schools']")
    public WebElement schoolEvent;
    @FindBy(xpath = "//div[@class='EventsPage_eventsCards__8XBnS']//div[2]//a[1]")
    public WebElement seeMoreBtn;

    @FindBy(xpath = "//div[@class='EventDetailsPage_familySection__6yuBj']")
    public WebElement eventDetails;

    @FindBy(xpath = "//p[@class='EventDetailsPage_desc__syEs+']")
    public WebElement aboutEvent;
}
