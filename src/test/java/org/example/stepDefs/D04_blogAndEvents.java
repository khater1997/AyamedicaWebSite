package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import static org.example.stepDefs.Hooks.driver;

public class D04_blogAndEvents {

    @When("user click on blog button")
    public void user_click_on_blog_button() throws InterruptedException {
        WebElement blogBtn = driver.findElement(By.xpath("//a[@href='/blog']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(blogBtn).perform();
        blogBtn.click();
        Thread.sleep(4000);
    }

    @And("user Show an explanatory sentence")
    public void userShowAnExplanatorySentence() {
        WebElement launchSentence = driver.findElement(By.xpath("//div[@class='IntroSection_left__bVTZo']"));
        String actualResult = launchSentence.getText();
        System.out.println(actualResult);
        String expectedResult = "Get notified when our blog is launched, please provide your email address below.";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");

    }

    @And("user can enter his email {string}")
    public void userCanEnterHisEmail(String launchMail) {
        WebElement launchEmail = driver.findElement(By.xpath("//div[@class='BlogPage_blogEmail__jlETn']//input[@id='email']"));
        launchEmail.sendKeys(launchMail);
    }

    @And("user click on enter button")
    public void userClickOnEnterButton() throws InterruptedException {
        WebElement enterBtn = driver.findElement(By.xpath(
                "//div[@class='BlogPage_blogEmail__jlETn']//button[@type='button'][normalize-space()='Enter']"));
        enterBtn.click();
        Thread.sleep(1000);
    }

    @Then("user should show the success message")
    public void userShouldShowTheSuccessMessage() {
        String successMessageActualSuccessMessage = driver.findElement(By.xpath(
                "//div[@class='MessageRecieved_form__vwdwm']")).getText();
        System.out.println(successMessageActualSuccessMessage);
        Assert.assertTrue(successMessageActualSuccessMessage.contains("We will send you an email to let you know when the blog is ready for commenting and interaction"), "Assertion is Failed");

        WebElement done2Button = driver.findElement(By.xpath(
                "//button[normalize-space()='Done']"));
        done2Button.click();
        String currentURl = driver.getCurrentUrl();
        Assert.assertEquals(currentURl, "https://www.ayamedica.com/blog", "Assertion is failed");
        System.out.println(currentURl);
    }

    @Then("user should show the subscription message")
    public void userShouldShowTheSubscriptionMessage() {

        String warningTextActualResult = driver.findElement(By.xpath(
                "//p[normalize-space()='You are already subscribed']")).getText();
        Assert.assertEquals(warningTextActualResult, "You are already subscribed", "Assertion is failed");
        System.out.println(warningTextActualResult);
    }

    @When("user click on events button")
    public void userClickOnEventsButton() throws InterruptedException {
        WebElement eventBtn = driver.findElement(By.xpath(
                "//a[@href='/events']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(eventBtn).perform();
        eventBtn.click();
        Thread.sleep(4000);
        String schoolName = driver.findElement(By.xpath(
                "//p[normalize-space()='Manhattan Schools']")).getText();
        Assert.assertTrue(schoolName.contains("Manhattan Schools"));
        System.out.println(schoolName);
    }

    @And("user click on see more to navigate to event details")
    public void userClickOnSeeMoreToNavigateToEventDetails() {
        WebElement seeMore = driver.findElement(By.xpath("//div[@class='MainLayout_outletContainer__Im5lZ']//div[2]//a[1]"));
        seeMore.click();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement eventDetails = driver.findElement(By.xpath(
                "//p[@class='EventDetailsPage_desc__syEs+']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", eventDetails);
    }

    @Then("user can read about event section")
    public void userCanReadAboutEventSection() {
        String aboutEventActualResult = driver.findElement(By.xpath("//p[@class='EventDetailsPage_desc__syEs+']")).getText();
        Assert.assertTrue(aboutEventActualResult.contains(
                        "we held an information session for students’ parents to introduce them to Ayamedica and present our services"),
                "Assertion is failed");
        System.out.println(aboutEventActualResult);

    }
}
