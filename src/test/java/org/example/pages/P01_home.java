package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_home {
    public P01_home() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(css = ".IntroSection_text_2__BkDvj")
    public WebElement homeSentence;

    @FindBy(css = "section[class='HomePage_videoSection__jGm8d'] p")
    public WebElement featureSentence;

    @FindBy(css = ".HomePage_desc__3HO7z")
    public WebElement downloadSentence;

    @FindBy(css = "a[href=\"/our-solutions\"]")
    public WebElement solutionBtn;

    @FindBy(css = "div[id='schools'] p[class='SolutionLayout_desc__c3xQt']")
    public WebElement schoolDetails;

    @FindBy(xpath = "//button[normalize-space()='Start Free Trial']")
    public WebElement freeTrialBtn;

}
