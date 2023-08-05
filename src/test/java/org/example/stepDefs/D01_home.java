package org.example.stepDefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_home;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D01_home {

    P01_home home = new P01_home();

    @When("user in home page and show home sentence")
    public void user_in_home_page_and_show_home_sentence() {
        String actualResult = home.homeSentence.getText();
        System.out.println(actualResult);
        String expectedResult = "Enhance your healthcare services by adopting new technologies and developing a patient-centered care approach";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");
        System.out.println(driver.getCurrentUrl());

    }


    @And("user scroll down to show what featuring ayamedica")
    public void userScrollDownToShowWhatFeaturingAyamedica() throws InterruptedException {
        WebElement video = driver.findElement(By.cssSelector(".VideoCard_poster__IfHUL.d-flex"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", video);

        WebElement play = driver.findElement(By.xpath("//button[@class='VideoCard_video_controler__3ardJ']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(play));
        Actions actions = new Actions(driver);
        actions.moveToElement(play).clickAndHold();
        Thread.sleep(4000);

        String actualResult = home.featureSentence.getText();
        System.out.println(actualResult);
        String expectedResult = "Carry Your Medical History In Your Pocket!";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");
    }


    @And("user scroll down to download ayamedica app by clicking on button")
    public void userScrollDownToDownloadAyamedicaAppByClickingOnButton() throws InterruptedException {
        WebElement download = driver.findElement(By.cssSelector(".HomePage_right__LQG0u"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", download);
        String actualResult2 = home.downloadSentence.getText();
        System.out.println(actualResult2);
        String expectedResult2 = "Introducing a faster, more accessible solution";
        Assert.assertTrue(actualResult2.contains(expectedResult2), "Assertion is failed");
        Thread.sleep(4000);
    }


    @When("user hover and click on our solutions button")
    public void userHoverAndClickOnOurSolutionsButton() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(home.solutionBtn).perform();
        home.solutionBtn.click();
        Thread.sleep(4000);
        String schoolSelection = home.schoolDetails.getText();
        Assert.assertTrue(schoolSelection.contains("Our goal is to improve communication between parents and the school"));
        System.out.println(schoolSelection);
    }


}
