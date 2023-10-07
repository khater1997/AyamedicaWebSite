package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;


public class D03_aboutUs {

    @When("user hover and click on about button")
    public void user_hover_and_click_on_about_button() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement aboutBtn = driver.findElement(By.xpath("//a[@href='/about-us']"));
        actions.moveToElement(aboutBtn).perform();
        aboutBtn.click();
        Thread.sleep(4000);
    }

    @Then("user could show our story")
    public void user_could_show_our_story() {
        String ourStoryActualResult = driver.findElement(By.xpath("//p[@class='AboutUsPage_desc__ywTUt']")).getText();
        System.out.println(ourStoryActualResult);
        String expectedResult = "When relocation to Egypt, his goal was to offer the most comprehensive medical system to the Egyptian market";
        Assert.assertTrue(ourStoryActualResult.contains(expectedResult), "Assertion is failed");

    }

    @And("user could scroll to know what we do")
    public void userCouldScrollToKnowWhatWeDo() {
        WebElement whatWeDo =driver.findElement(By.xpath("//p[@class='SectionLayout_desc__xJ9-X']"));
        String whatWeDoActualResult = whatWeDo.getText();
        System.out.println(whatWeDoActualResult);
        String expectedResult = "Ayamedica’s solutions connect the patient with their own medical records, as provided by the medical professional, in a method that is secure, accessible and discrete";
        Assert.assertEquals(expectedResult, whatWeDoActualResult, "Assertion is failed");
    }

    @And("user show the options")
    public void userShowTheOptions() {
        WebElement optionOne = driver.findElement(By.xpath("//div[@class='AboutUsPage_cardsList__3boLr']//div[1]"));
        WebElement optionTwo = driver.findElement(By.xpath("//div[@class='AboutUsPage_cardsList__3boLr']//div[2]"));
        WebElement optionThree = driver.findElement(By.xpath("//div[@class='AboutUsPage_cardsList__3boLr']//div[3]"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", optionOne);

        String actualResult = optionOne.getText();
        System.out.println(actualResult);
        String expectedResult = "Schedule Appointments";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");

        String actualResult2 = optionTwo.getText();
        System.out.println(actualResult2);
        String expectedResult2 = "Organize Personal Healthcare";
        Assert.assertTrue(actualResult2.contains(expectedResult2), "Assertion is failed");

        String actualResult3 = optionThree.getText();
        System.out.println(actualResult3);
        String expectedResult3 = "Medical Records";
        Assert.assertTrue(actualResult3.contains(expectedResult3), "Assertion is failed");
    }

    @And("user could scroll to know our vision")
    public void userCouldScrollToKnowOurVision() {
        WebElement ourVision = driver.findElement(By.xpath("//p[contains(text(),'Our Vision')]"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ourVision);
        String ourVisionActualResult = ourVision.getText();
        System.out.println(ourVisionActualResult);
    }

    @And("user could scroll to know our mission")
    public void userCouldScrollToKnowOurMission() {
        WebElement ourMission = driver.findElement(By.xpath("//p[contains(text(),'Our Mission')]"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ourMission);
        String ourMissionActualResult = ourMission.getText();
        System.out.println(ourMissionActualResult);
    }

    @When("user scroll down to show the team in slider")
    public void userScrollDownToShowTheTeamInSlider() throws InterruptedException {
        WebElement slider = driver.findElement(By.xpath("//div[@class='swiper swiper-initialized swiper-horizontal CustomSwiper_swiper__aV-Wr']"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", slider);
        slider.isSelected();
        Thread.sleep(4000);
    }

    @Then("user should show the team")
    public void userShouldShowTheTeam() {
        WebElement ourTeam = driver.findElement(By.xpath("//p[@class='AboutUsPage_description__b4tWl']"));
        String ourTeamActualResult = ourTeam.getText();
        System.out.println(ourTeamActualResult);
        String expectedResult = "These are the People that Make the Magic Happen!";
        Assert.assertTrue(ourTeamActualResult.contains(expectedResult), "Assertion is failed");
    }
}

