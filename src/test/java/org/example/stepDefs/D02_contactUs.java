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
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D02_contactUs {
    ArrayList<String> tabs;

    @When("user hover and click on call icon")
    public void user_hover_and_click_on_call_icon() {
        Actions actions = new Actions(driver);
        WebElement callBtn = driver.findElement(By.xpath("//div[@class='Navbar_phone_icon_list__VIODb']"));
        actions.moveToElement(callBtn).perform();
    }

    @Then("can show number to call us with it")
    public void canShowNumberToCallUsWithIt() {
        List<WebElement> phoneNumbers = driver.findElements(By.xpath("//div[@class='Navbar_list__Skbcw d-none']//div[@class='PhoneList_list_nums__5tn3Y']"));
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < phoneNumbers.size(); i++) {
            String actualPhoneNum = phoneNumbers.get(i).getText();
            String expectedPhoneNumbers = "+201156677424";
            softAssert.assertTrue(actualPhoneNum.contains(expectedPhoneNumbers), "assertion failed ");
            softAssert.assertAll();
        }
    }

    @When("user click on contact us button and enter his data")
    public void userClickOnContactUsButtonAndEnterHisData() throws InterruptedException {

        WebElement contactButton = driver.findElement(By.xpath("//button[normalize-space()='Contact Us']"));
        contactButton.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Mohamed");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("Khater");

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("mo.khater@ayamedica.com");

        WebElement countryBox = driver.findElement(By.xpath("//div[@class='ReactFlagsSelect-module_flagsSelect__2pfa2 menu-flags']"));
        countryBox.click();

        WebElement countryCode = driver.findElement(By.id("rfs-EG"));
        countryCode.click();

        WebElement phoneNum = driver.findElement(By.xpath("//input[@id='phoneNumber']"));
        phoneNum.sendKeys("01096347693");

        WebElement message = driver.findElement(By.xpath("//input[@id='message']"));
        message.sendKeys("Ayamedica, let's talk");
        Thread.sleep(1000);
    }


    @Then("user click on send button to send data")
    public void user_click_on_send_button_to_send_data() throws InterruptedException {
        WebElement sendButton = driver.findElement(By.xpath(
                "//button[normalize-space()='Send']"));
        sendButton.click();
        Thread.sleep(1000);

        String actualSuccessMessage = driver.findElement(By.xpath("//div[@class='MessageRecieved_form__vwdwm']")).getText();
        System.out.println(actualSuccessMessage);
        Assert.assertTrue(actualSuccessMessage.contains("Your message has been sent Successfully"), "Assertion is Failed");

        WebElement doneButton = driver.findElement(By.xpath(
                "//button[normalize-space()='Done']"));
        doneButton.click();
        Thread.sleep(1000);
        String currentURl = driver.getCurrentUrl();
        System.out.println(currentURl);
        Assert.assertEquals(currentURl, "https://www.ayamedica.com/contact-us", "Assertion is failed");
        Thread.sleep(2000);
    }

    @When("user click on facebook icon")
    public void userClickOnFacebookIcon() {

        WebElement faceIcon = driver.findElement(By.xpath("(//*[contains(@href,'facebook')])"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", faceIcon);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        tabs = new ArrayList<>(driver.getWindowHandles());

    }

    @Then("user navigate to facebook page {string} and opened in new tab")
    public void userNavigateToFacebookPageAndOpenedInNewTab(String expectedFacebookUrl) throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        String actualFacebookUrl = driver.getCurrentUrl();     //get tab 1 (facebook page) url
        System.out.println(actualFacebookUrl);                         // to confirm when run

        //assertion check if actual facebook page url equal expected one
        Assert.assertEquals(actualFacebookUrl, expectedFacebookUrl, "facebook assertion is failed");
    }

    @And("user click on instagram icon")
    public void userClickOnInstagramIcon() {
        WebElement instagram = driver.findElement(By.xpath("//*[contains(@href,'instagram')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", instagram);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        tabs = new ArrayList<>(driver.getWindowHandles());

    }

    @Then("user navigate to instagram page {string} and opened in new tab")
    public void userNavigateToInstagramPageAndOpenedInNewTab(String expectedFacebookUrl) throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        String actualInstagramUrl = driver.getCurrentUrl();     //get tab 1 (instagram page) url
        System.out.println(actualInstagramUrl);                         // to confirm when run

        //assertion check if actual instagram page url equal expected one
        Assert.assertEquals(actualInstagramUrl, expectedFacebookUrl, "instagram assertion is failed");
    }

    @When("user click on whatsapp icon")
    public void userClickOnWhatsappIcon() {
        WebElement whatsapp = driver.findElement(By.xpath("//*[contains(@href,'whatsapp')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", whatsapp);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        tabs = new ArrayList<>(driver.getWindowHandles());
    }

    @Then("user navigate to rss page{string} and opened in new tab")
    public void userNavigateToRssPageAndOpenedInNewTab(String expectedWhatsappUrl) throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        String actualInstagramUrl = driver.getCurrentUrl();     //get tab 1 (whatsapp page) url
        System.out.println(actualInstagramUrl);                         // to confirm when run

        //assertion check if actual whatsapp page url equal expected one
        Assert.assertEquals(actualInstagramUrl, expectedWhatsappUrl, "whatsapp assertion is failed");
    }

    @When("user click on linkedin icon")
    public void userClickOnLinkedinIcon() {
        WebElement linkedin = driver.findElement(By.xpath("//*[contains(@href,'linkedin')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", linkedin);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        tabs = new ArrayList<>(driver.getWindowHandles());
    }

    @Then("user navigate to linkedin page {string} and opened in new tab")
    public void userNavigateToLinkedinPageAndOpenedInNewTab(String expectedLinkedinUrl) throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        String actualInstagramUrl = driver.getCurrentUrl();     //get tab 1 (linkedin page) url
        System.out.println(actualInstagramUrl);                         // to confirm when run

        //assertion check if actual linked In page url equal expected one
        Assert.assertEquals(actualInstagramUrl, expectedLinkedinUrl, "linkedin assertion is failed");

    }

    @When("user click on youtube icon")
    public void userClickOnYoutubeIcon() {
        WebElement youtube = driver.findElement(By.xpath("//*[contains(@href,'youtube')]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", youtube);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        tabs = new ArrayList<>(driver.getWindowHandles());
    }

    @Then("user navigate to youtube page {string} and opened in new tab")
    public void userNavigateToYoutubePageAndOpenedInNewTab(String expectedYoutubeUrl) throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        String actualInstagramUrl = driver.getCurrentUrl();     //get tab 1 (youtube page) url
        System.out.println(actualInstagramUrl);                         // to confirm when run

        //assertion check if actual YouTube page url equal expected one
        Assert.assertEquals(actualInstagramUrl, expectedYoutubeUrl, "youtube assertion is failed");

    }

}
