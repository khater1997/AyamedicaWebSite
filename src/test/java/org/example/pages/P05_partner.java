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


    @FindBy(css = "input[id=\"note\"]")
    public WebElement notesField;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    public WebElement sendBtn;

    @FindBy(xpath = "//p[@class='MessageRecieved_desc__mVY3g']")
    public WebElement successMsg;

    @FindBy(css = "div[class='MessageRecieved_form__vwdwm'] button[type='button']")
    public WebElement doneBtn;

}
