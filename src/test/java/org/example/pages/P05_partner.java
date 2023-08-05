package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_partner {
    public P05_partner() {
        PageFactory.initElements(Hooks.driver, this);
    }
    @FindBy(css = "a[href=\"/our-partners\"]")
    public WebElement ourPartnerBtn;
    @FindBy(xpath = "//button[normalize-space()='Become a Partner']")
    public WebElement becomeBtn;
    @FindBy(css = ".IntroSection_text_2__BkDvj")
    public WebElement partnerSentence;

    @FindBy(css = "input[id=\"fullName\"]")
    public WebElement fullNameField;

    @FindBy(css = "input[id=\"providerName\"]")
    public WebElement orgNameField;

    @FindBy(css = "input[id=\"providerEmail\"]")
    public WebElement emailField;

    @FindBy(xpath = "//button[@id='rfs-btn']")
    public WebElement countryDropList;

    @FindBy(xpath = "//li[@id='rfs-EG']")
    public WebElement countryCode;

    @FindBy(css = "input[name=\"phoneNumber\"]")
    public WebElement phoneNumber;

    @FindBy(css = "div[class=\"select__value-container select__value-container--has-value css-f0ja12\"] div[class=\"select__single-value css-19r6m3w-singleValue\"]")
    public WebElement interestDropList;

   /* @FindBy(css = "//div[@class='select__single-value css-19r6m3w-singleValue']")
    public WebElement interestSelect;*/


    @FindBy(css = "input[id=\"note\"]")
    public WebElement notesField;

    @FindBy(css = "input[//button[normalize-space()='Send']]")
    public WebElement sendBtn;

    @FindBy(xpath = "//p[@class='MessageRecieved_desc__mVY3g']")
    public WebElement successMsg;

    @FindBy(css = "div[class='MessageRecieved_form__vwdwm'] button[type='button']")
    public WebElement doneBtn;

}
