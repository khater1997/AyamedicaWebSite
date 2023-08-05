@smoke
Feature: F04_blogAndEvents | user can get notified when our blog is launching and show our Events
       #positive Scenario
  Scenario:  user can get notified when our blog is launching by entering his email
    When user click on blog button
    And user Show an explanatory sentence
    And user can enter his email "mohamed3@ayamedica.com"
    And user click on enter button
    Then user should show the success message
       #negative Scenario
  Scenario:  user enter a subscribed email
    When user click on blog button
    And user Show an explanatory sentence
    And user can enter his email "mohamed2@ayamedica.com"
    And user click on enter button
    Then user should show the subscription message

  Scenario:  user can show our events
    When user click on events button
    And user click on see more to navigate to event details
   Then user can read about event section