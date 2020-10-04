Feature: To test the weather details of a city on the NDTV website

  Background: User Navigate to NDTV Weather Page
    Given User open browser
    And User is on the NDTV Home Page
    When User click on Weather link
    Then User navigate to NDTV Weather Page

    Scenario: Check weather details of a city
      When User enter the city name in the Pin Your City search field
      And User select the city from the list
      Then User should see the city name displayed on the map
      And User should see the temperature displayed on the map
