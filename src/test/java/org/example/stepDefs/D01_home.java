package org.example.stepDefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    ArrayList<String> tabs;

    @When("user in home page and show home sentence")
    public void user_in_home_page_and_show_home_sentence() {
        String actualResult = driver.findElement(By.xpath("//p[@class='IntroSection_text_2__BkDvj']")).getText();
        System.out.println(actualResult);
        String expectedResult = "Enhance your healthcare services by adopting new technologies and developing a patient-centered care approach";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");
        System.out.println(driver.getCurrentUrl());

    }


    @And("user scroll down to show what featuring ayamedica")
    public void userScrollDownToShowWhatFeaturingAyamedica() throws InterruptedException {

        WebElement video = driver.findElement(By.xpath("//div[@class='VideoCard_poster__IfHUL d-flex']"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", video);

        WebDriverWait videoLoadWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        videoLoadWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("div[@class='VideoCard_poster__IfHUL d-flex']")));
        WebElement playBtn = driver.findElement(By.xpath("//button[@class='VideoCard_video_controler__3ardJ']"));
        playBtn.click();

        String actualResult = driver.findElement(By.xpath("//p[normalize-space()='Carry Your Medical History In Your Pocket!']")).getText();
        System.out.println(actualResult);
        String expectedResult = "Carry Your Medical History In Your Pocket!";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");

        Thread.sleep(10000);

    }

    @And("user scroll down to download ayamedica app for IOS by clicking on button")
    public void userScrollDownToDownloadAyamedicaAppForIOSByClickingOnButton() {
        WebElement iosButton = driver.findElement(By.xpath("//div[@class='HomePage_downloadMobile__HbPlE']//div[@class='DownloadCard_card__jrI+g']//div//p[contains(text(),'Download for IOS')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", iosButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        tabs = new ArrayList<>(driver.getWindowHandles());
    }

    @Then("user navigate to ios page {string} and opened in new tab")
    public void userNavigateToIosPageAndOpenedInNewTab(String expectedIOSUrl) throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        String actualIOSUrl = driver.getCurrentUrl();                                         //get tab 1 (IOS page) url
        System.out.println(actualIOSUrl);                                                      // to confirm when run
        //assertion check if actual IOS page url equal expected one
        Assert.assertEquals(actualIOSUrl, expectedIOSUrl, "IOS Downloading assertion is failed");

    }


    @When("user scroll down to download ayamedica app for Android by clicking on button")
    public void userScrollDownToDownloadAyamedicaAppForAndroidByClickingOnButton() {
        driver.switchTo().window(tabs.get(0));
        WebElement androidButton = driver.findElement(By.xpath("//div[@class='HomePage_downloadMobile__HbPlE']//div[@class='DownloadCard_card__jrI+g']//div//p[contains(text(),'Download for Android')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", androidButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        tabs = new ArrayList<>(driver.getWindowHandles());

    }

    @Then("user navigate to android page {string} and opened in new tab")
    public void userNavigateToAndroidPageAndOpenedInNewTab(String expectedAndroidUrl) throws InterruptedException {
        driver.switchTo().window(tabs.get(2));
        Thread.sleep(2000);
        String actualAndroidUrl = driver.getCurrentUrl();        //get tab 1 (Android page) url
        System.out.println(actualAndroidUrl);                         // to confirm when run

        //assertion check if actual Android page url equal expected one
        Assert.assertEquals(actualAndroidUrl, expectedAndroidUrl, "Android Downloading assertion is failed");

    }

    @When("user hover and click on our solutions button")
    public void userHoverAndClickOnOurSolutionsButton() throws InterruptedException {
        driver.switchTo().window(tabs.get(0));

        String actualResult2 = driver.findElement(By.xpath("//p[@class='HomePage_desc__3HO7z']")).getText();
        System.out.println(actualResult2);
        String expectedResult2 = "Introducing a faster, more accessible solution";
        Assert.assertTrue(actualResult2.contains(expectedResult2), "Assertion is failed");

        Actions actions = new Actions(driver);
        WebElement solutionBtn = driver.findElement(By.xpath("//a[@href='/our-solutions']"));
        actions.moveToElement(solutionBtn).perform();
        solutionBtn.click();
        Thread.sleep(4000);

        String schoolSelection = driver.findElement(By.xpath("//p[contains(text(),'Our goal is to improve communication between paren')]")).getText();
        Assert.assertTrue(schoolSelection.contains("Our goal is to improve communication between parents and the school"));
        System.out.println(schoolSelection);
    }

    @And("click on start free trial button and enter the data")
    public void clickOnStartFreeTrialButtonAndEnterTheData() {
        WebElement freeTrialButton = driver.findElement(By.xpath(" //button[normalize-space()='Start Free Trial']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", freeTrialButton);

        WebElement fullNameField = driver.findElement(By.xpath("//input[@id='fullName']"));
        fullNameField.sendKeys("Mohamed Khater");                    // enter Full name

        WebElement organizationField = driver.findElement(By.xpath("//input[@id='providerName']"));
        organizationField.sendKeys("Ayamedica");                      // enter Organization name

        WebElement emailField = driver.findElement(By.xpath("//input[@id='providerEmail']"));
        emailField.sendKeys("mohamed.khater@ayamedica.org");          // enter Email

        WebElement countryBox = driver.findElement(By.xpath("//button[@id='rfs-btn']"));
        countryBox.click();

        WebElement countryCode = driver.findElement(By.xpath("//li[@id='rfs-EG']//span[@class='ReactFlagsSelect-module_selectOptionValue__vS99-']"));
        countryCode.click();

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='phoneNumber']"));
        phoneNumber.sendKeys("01096347693");

        WebElement howHearing = driver.findElement(By.xpath("//div[contains(text(),'How did you hear about us?')]"));
        howHearing.click();

        WebElement dropListClicking= driver.findElement(By.xpath(
                "/html/body/div[5]/div/div/div[2]/div/div[3]/div[2]/div/div/div[2]/div"));

        Actions actions = new Actions(driver);
        actions.moveToElement(dropListClicking).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/div[2]/div/div[3]/div[2]/div/div/div[2]/div")));
        driver.findElement(By.xpath("//div[contains(text(),'LinkedIn')]")).click();

    }
}
