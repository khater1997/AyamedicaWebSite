@smoke
Feature: F04_partner | user can show our partner and become one of them

  Scenario: user could go to our partner page to become a partner
    When user click on our partner button
    Then user can show partners explanatory sentence
    When user click on become a partner button
    And user enter his full name "Mohamed Khater"
    And user enter organization name "Ayamedica"
    And user enter business email "mohamed.khater@ayamedica.org"
    And user select his country code and enter his phone number "01096347693"
    And user select which interested in
    And user select How did hearing about us
    And user enter his notes "let's start and become a partner"
    And user click on send button
    Then show become a partner successful message
    And user click on done button to go back
