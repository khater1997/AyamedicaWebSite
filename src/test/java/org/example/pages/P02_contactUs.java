package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P02_contactUs {

    public P02_contactUs() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(css = "div[class=\"Navbar_phone_icon_list__VIODb\"]")
    public WebElement callBtn;

    @FindBy(css = "div[class='Navbar_list__Skbcw d-none'] div[class='PhoneList_list_nums__5tn3Y']")
    public List<WebElement> phoneNumbers;
    @FindBy(xpath = "//button[normalize-space()='Contact Us']")
    public WebElement contactBtn;
    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstName;
    @FindBy(css = "input[id=\"lastName\"]")
    public WebElement lastName;
    @FindBy(css = "input[id=\"email\"]")
    public WebElement email;
    @FindBy(css = "div[class=\"ReactFlagsSelect-module_flagsSelect__2pfa2 menu-flags\"]")
    public WebElement countryBox;
    @FindBy(id = "rfs-EG")
    public WebElement countryCode;
    @FindBy(css = "input[name=\"phoneNumber\"]")
    public WebElement phoneNum;

    @FindBy(css = "input[id=\"message\"]")
    public WebElement message;

    @FindBy(css = "div[class=\"MessageRecieved_form__vwdwm\"]")
    public WebElement successMes;
}
