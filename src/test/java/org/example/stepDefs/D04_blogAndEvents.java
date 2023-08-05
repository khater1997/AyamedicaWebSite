package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_blogAndEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import static org.example.stepDefs.Hooks.driver;

public class D04_blogAndEvents {
    public static P04_blogAndEvents blogAndEvent = new P04_blogAndEvents();

    @When("user click on blog button")
    public void user_click_on_blog_button() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(blogAndEvent.blogBtn).perform();
        blogAndEvent.blogBtn.click();
        Thread.sleep(4000);
    }

    @And("user Show an explanatory sentence")
    public void userShowAnExplanatorySentence() {
        String actualResult = blogAndEvent.launchSentence.getText();
        System.out.println(actualResult);
        String expectedResult = "Get notified when our blog is launched, please provide your email address below.";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");

    }

    @And("user can enter his email {string}")
    public void userCanEnterHisEmail(String launchEmail) {
        blogAndEvent.launchEmail.sendKeys(launchEmail);
    }

    @And("user click on enter button")
    public void userClickOnEnterButton() {
        blogAndEvent.enterBtn.click();
    }

    @Then("user should show the success message")
    public void userShouldShowTheSuccessMessage() {
        String actualSuccessMessage = blogAndEvent.successMessage.getText();
        System.out.println(actualSuccessMessage);
        Assert.assertTrue(actualSuccessMessage.contains("We will send you an email to let you know when the blog is ready for commenting and interaction"), "Assertion is Failed");

        WebElement done2Button = driver.findElement(By.xpath(
                "//button[normalize-space()='Done']"));
        done2Button.click();
        String currentURl = driver.getCurrentUrl();
        Assert.assertEquals(currentURl, "https://www.ayamedica.com/blog", "Assertion is failed");
        System.out.println(currentURl);
    }

    @Then("user should show the subscription message")
    public void userShouldShowTheSubscriptionMessage() {

        String actualResult = blogAndEvent.warningText.getText();
        Assert.assertEquals(actualResult, "You are already subscribed", "Assertion is failed");
        System.out.println(actualResult);
    }

    @When("user click on events button")
    public void userClickOnEventsButton() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(blogAndEvent.eventBtn).perform();
        blogAndEvent.eventBtn.click();
        Thread.sleep(4000);
        String schoolName = blogAndEvent.schoolEvent.getText();
        Assert.assertTrue(schoolName.contains("Manhattan Schools"));
        System.out.println(schoolName);
    }

    @And("user click on see more to navigate to event details")
    public void userClickOnSeeMoreToNavigateToEventDetails() {

        // click on see more button
        blogAndEvent.seeMoreBtn.click();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", blogAndEvent.eventDetails);
    }

    @Then("user can read about event section")
    public void userCanReadAboutEventSection() {
        String actualResult = blogAndEvent.aboutEvent.getText();
        Assert.assertTrue(actualResult.contains(
                        "we held an information session for students’ parents to introduce them to Ayamedica and present our services"),
                "Assertion is failed");
        System.out.println(actualResult);

    }
}
