@smoke
Feature: F01_HomeAndOurSolutions | user go to home page to show what about Ayamedica

  Scenario: user going to home and show our solutions
    When user in home page and show home sentence
    And user scroll down to show what featuring ayamedica
    And user scroll down to download ayamedica app for IOS by clicking on button
    Then user navigate to ios page "https://apps.apple.com/eg/app/ayamedica/id6444577440" and opened in new tab
    When user scroll down to download ayamedica app for Android by clicking on button
    Then user navigate to android page "https://play.google.com/store/apps/details?id=com.ayamedica.patient" and opened in new tab
    When user hover and click on our solutions button
    And click on start free trial button and enter the data

