package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_partner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D05_partner {
    P05_partner partner = new P05_partner();

    @When("user click on our partner button")
    public void user_click_on_our_partner_button() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement ourPartnerBtn = driver.findElement(By.xpath("//a[@href=\"/our-partners\"]"));
        actions.moveToElement(ourPartnerBtn).perform();
        ourPartnerBtn.click();
        Thread.sleep(4000);
    }

    @Then("user can show partners explanatory sentence")
    public void userCanShowPartnersExplanatorySentence() {
        String partnerSentenceActualResult = driver.findElement(By.xpath("//p[@class='IntroSection_text_2__BkDvj']")).getText();
        System.out.println(partnerSentenceActualResult);
        String expectedResult = "We are always looking for partners who want to collaborate with us to improve healthcare for everyone";
        Assert.assertTrue(partnerSentenceActualResult.contains(expectedResult), "Assertion is failed");

    }

    @When("user click on become a partner button")
    public void userClickOnBecomeAPartnerButton() {
        WebElement becomeBtn = driver.findElement(By.xpath("//button[normalize-space()='Become a Partner']"));
        becomeBtn.click();
    }

    @And("user enter his full name {string}")
    public void userEnterHisFullName(String fullName) {
        WebElement fullNameField = driver.findElement(By.xpath("//input[@id='fullName']"));
        fullNameField.sendKeys(fullName);                    // enter Full name
    }

    @And("user enter organization name {string}")
    public void userEnterOrganizationName(String orgName) {
        WebElement organizationField = driver.findElement(By.xpath("//input[@id='providerName']"));
        organizationField.sendKeys(orgName);                      // enter Organization name
    }

    @And("user enter business email {string}")
    public void userEnterBusinessEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@id='providerEmail']"));
        emailField.sendKeys(email);                        // enter Email
    }

    @And("user select his country code and enter his phone number {string}")
    public void userSelectHisCountryCodeAndEnterHisPhoneNumber(String phoneNum) {
        WebElement countryBox = driver.findElement(By.xpath("//button[@id='rfs-btn']"));
        countryBox.click();

        WebElement countryCode = driver.findElement(By.xpath("//li[@id='rfs-EG']//span[@class='ReactFlagsSelect-module_selectOptionValue__vS99-']"));
        countryCode.click();

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='phoneNumber']"));
        phoneNumber.sendKeys(phoneNum);
    }

    @And("user select which interested in")
    public void userSelectWhichInterestedIn() {

        WebElement indicator = driver.findElement(By.xpath(
                "/html/body/div[5]/div/div/div[2]/div/div[3]/div[1]/div/div/div[2]/div"));
        new Actions(driver).click(indicator).perform();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'School')]")));
        driver.findElement(By.xpath("//div[contains(text(),'School')]")).click();

    }

    @And("user select How did hearing about us")
    public void userSelectHowDidHearingAboutUs() {
        WebElement howHearing = driver.findElement(By.xpath("//div[contains(text(),'How did you hear about us?')]"));
        howHearing.click();

        WebElement indicator2 = driver.findElement(By.xpath(
                "//div[@class='BePartnerForm_form__-0ti-']//div[1]//div[1]//div[1]//div[2]//div[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(indicator2).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Facebook')]")));
        WebElement hearingSelect = driver.findElement(By.xpath("//div[contains(text(),'Facebook')]"));
        hearingSelect.click();

    }

    @And("user enter his notes {string}")
    public void userEnterHisNotes(String note) {
        WebElement notesField = driver.findElement(By.xpath("//input[@id='note']"));
        notesField.sendKeys(note);
    }

    @And("user click on send button")
    public void userClickOnSendButton() {
        WebElement sendBtn = driver.findElement(By.xpath("//button[normalize-space()='Send']"));
        sendBtn.click();
    }

    @Then("show become a partner successful message")
    public void showBecomeAPartnerSuccessfulMessage() {
        String successMsgActualResult = driver.findElement(By.xpath("//p[@class='MessageRecieved_desc__mVY3g']")).getText();
        System.out.println(successMsgActualResult);
        String expectedResult = "We appreciate your interest. We are so happy about your request, we will review it and get back to you soon!";
        Assert.assertTrue(successMsgActualResult.contains(expectedResult), "assertion failed");
    }

    @And("user click on done button to go back")
    public void userClickOnDoneButtonToGoBack() {
        WebElement doneBtn = driver.findElement(By.xpath("//button[normalize-space()='Done']"));
        doneBtn.click();
    }

}
