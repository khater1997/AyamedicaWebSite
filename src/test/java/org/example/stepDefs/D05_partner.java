package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_partner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D05_partner {
    P05_partner partner = new P05_partner();

    @When("user click on our partner button")
    public void user_click_on_our_partner_button() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(partner.ourPartnerBtn).perform();
        partner.ourPartnerBtn.click();
        Thread.sleep(4000);
    }

    @Then("user can show partners explanatory sentence")
    public void userCanShowPartnersExplanatorySentence() {
        String actualResult = partner.partnerSentence.getText();
        System.out.println(actualResult);
        String expectedResult = "We are always looking for partners who want to collaborate with us to improve healthcare for everyone";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");

    }

    @When("user click on become a partner button")
    public void userClickOnBecomeAPartnerButton() {
        partner.becomeBtn.click();
    }

    @And("user enter his full name {string}")
    public void userEnterHisFullName(String fullName) {
        partner.fullNameField.sendKeys(fullName);
    }

    @And("user enter organization name {string}")
    public void userEnterOrganizationName(String orgName) {
        partner.orgNameField.sendKeys(orgName);
    }

    @And("user enter business email {string}")
    public void userEnterBusinessEmail(String email) {
        partner.emailField.sendKeys(email);
    }

    @And("user select his country code and enter his phone number {string}")
    public void userSelectHisCountryCodeAndEnterHisPhoneNumber(String phoneNumber) {
        partner.countryDropList.click();
        partner.countryCode.click();
        partner.phoneNumber.sendKeys(phoneNumber);
    }

    @And("user select which interested in")
    public void userSelectWhichInterestedIn() {

        WebElement interestField = driver.findElement(By.xpath(
                "//body/div[@role='dialog']/div[@class='modal-dialog withModal_modal__H0wEd modal-lg modal-dialog-centered']/div[@class='modal-content']/div[@class='modal-body']/div[@class='BePartnerForm_form__-0ti-']/div[3]/div[1]"));
        interestField.click();

        selectFromDropDown(driver.findElement(By.cssSelector("div[class=\"select__control select__control--is-focused select__control--menu-is-open css-g1zzb2-control\"]")), "School");
    }


    @And("user enter his notes {string}")
    public void userEnterHisNotes(String note) {
        partner.notesField.sendKeys(note);
    }

    @And("user click on send button")
    public void userClickOnSendButton() {
        partner.sendBtn.click();
    }

    @Then("show become a partner successful message")
    public void showBecomeAPartnerSuccessfulMessage() {
        String actualResult = partner.successMsg.getText();
        System.out.println(actualResult);
        String expectedResult = "We appreciate your interest. We are so happy about your request, we will review it and get back to you soon!";
        Assert.assertTrue(actualResult.contains(expectedResult), "assertion failed");
    }

    @And("user click on done button to go back")
    public void userClickOnDoneButtonToGoBack() {
        partner.doneBtn.click();
    }

    public static void selectFromDropDown(WebElement element, String Visibletext) {
        Select select = new Select(element);
        select.selectByVisibleText(Visibletext);
    }
}
