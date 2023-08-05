package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_aboutUs {
    public P03_aboutUs() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(css = "a[href='/about-us']")
    public WebElement aboutBtn;

    @FindBy(css = ".AboutUsPage_desc__ywTUt")
    public WebElement ourStory;

    @FindBy(css = ".SectionLayout_desc__xJ9-X")
    public WebElement whatDO;
    @FindBy(xpath = "//div[@class='AboutUsPage_cardsList__3boLr']//div[1]")
    public WebElement optionOne;

    @FindBy(xpath = "//div[@class='AboutUsPage_cardsList__3boLr']//div[2]")
    public WebElement optionTwo;

    @FindBy(xpath = "//div[@class='AboutUsPage_cardsList__3boLr']//div[3]")
    public WebElement optionThree;

    @FindBy(xpath = "//p[contains(text(),'Our Vision')]")
    public WebElement ourVision;
    @FindBy(xpath = "//p[contains(text(),'Our Mission')]")
    public WebElement ourMission;

    @FindBy(css = "div[class=\"swiper swiper-initialized swiper-horizontal CustomSwiper_swiper__aV-Wr\"]")
    public WebElement slider;
    @FindBy(css = ".AboutUsPage_description__b4tWl")
    public WebElement ourTeam;
}
