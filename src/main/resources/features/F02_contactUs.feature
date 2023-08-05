@smoke
Feature: F02_contactUs | users could contact us and open followUs links

  Scenario: user call us and contact us
    When user hover and click on call icon
    Then can show number to call us with it
    When user click on contact us button and enter his data
    Then user click on send button to send data

  Scenario: user opens facebook link
    When user click on facebook icon
    Then user navigate to facebook page "https://www.facebook.com/Ayamedica.egy/?_rdc=2&_rdr" and opened in new tab

  Scenario: user opens instagram link
    When user click on instagram icon
    Then user navigate to instagram page "https://www.instagram.com/ayamedica/?hl=en" and opened in new tab

  Scenario: user opens whatsapp link
    When user click on whatsapp icon
    Then user navigate to rss page"https://api.whatsapp.com/send?phone=+201091808186&text=Send20%a20%quote" and opened in new tab

  Scenario: user opens linkedin link
    When user click on linkedin icon
    Then user navigate to linkedin page "https://www.linkedin.com/company/ayamedica/" and opened in new tab

  Scenario: user opens youtube link
    When user click on youtube icon
    Then user navigate to youtube page "https://www.youtube.com/@ayamedica3109" and opened in new tab



