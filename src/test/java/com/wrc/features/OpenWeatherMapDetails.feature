Feature: To test the weather details of a city using open weather map api

  @NegativeTest @RegressionTest
  Scenario: Test 1: Validate that attempt to fetch weather details without APIKey gives (response code = 401 - error)
    When I fetch weather details from OpenWhetherMap "without" APIKey and city name as "Hyderabad"
    Then I should see the response body with "cod" as "401"
    Then I should see the response body with "message" as "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info."

    # Scenario 2 - Using "GET/weather" API to verify that the details are fetched as per the mentioned city
  @AffirmativeTest @RegressionTest
  Scenario: Test 2: Fetch weather details of a city (response code = 200)
    When I fetch weather details from OpenWhetherMap "with" APIKey and city name as "Hyderabad"
    Then I have received HTTP response code of "200"
    Then I should see the response body with "lon" as "78.47"
    #Then I see weather details with values as "<latitude>","<longitude>"
