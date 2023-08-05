package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_aboutUs;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;


public class D03_aboutUs {

    public static P03_aboutUs about = new P03_aboutUs();

    @When("user hover and click on about button")
    public void user_hover_and_click_on_about_button() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(about.aboutBtn).perform();
        about.aboutBtn.click();
        Thread.sleep(4000);
    }

    @Then("user could show our story")
    public void user_could_show_our_story() {
        String actualResult = about.ourStory.getText();
        System.out.println(actualResult);
        String expectedResult = "When relocation to Egypt, his goal was to offer the most comprehensive medical system to the Egyptian market";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");

    }

    @And("user could scroll to know what we do")
    public void userCouldScrollToKnowWhatWeDo() {
        String actualResult = about.whatDO.getText();
        System.out.println(actualResult);
        String expectedResult = "Ayamedica’s solutions connect the patient with their own medical records, as provided by the medical professional, in a method that is secure, accessible and discrete";
        Assert.assertEquals(expectedResult, actualResult, "Assertion is failed");
    }

    @And("user show the options")
    public void userShowTheOptions() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", about.optionOne);

        String actualResult = about.optionOne.getText();
        System.out.println(actualResult);
        String expectedResult = "Schedule Appointments";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");

        String actualResult2 = about.optionTwo.getText();
        System.out.println(actualResult2);
        String expectedResult2 = "Organize Personal Healthcare";
        Assert.assertTrue(actualResult2.contains(expectedResult2), "Assertion is failed");

        String actualResult3 = about.optionThree.getText();
        System.out.println(actualResult3);
        String expectedResult3 = "Medical Records";
        Assert.assertTrue(actualResult3.contains(expectedResult3), "Assertion is failed");
    }

    @And("user could scroll to know our vision")
    public void userCouldScrollToKnowOurVision() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", about.ourVision);
        String actualResult = about.ourVision.getText();
        System.out.println(actualResult);
    }

    @And("user could scroll to know our mission")
    public void userCouldScrollToKnowOurMission() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", about.ourMission);
        String actualResult = about.ourMission.getText();
        System.out.println(actualResult);
    }

    @When("user scroll down to show the team in slider")
    public void userScrollDownToShowTheTeamInSlider() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", about.slider);
        about.slider.isSelected();
        Thread.sleep(4000);
    }

    @Then("user should show the team")
    public void userShouldShowTheTeam() {
        String actualResult = about.ourTeam.getText();
        System.out.println(actualResult);
        String expectedResult = "These are the People that Make the Magic Happen!";
        Assert.assertTrue(actualResult.contains(expectedResult), "Assertion is failed");
    }
}

