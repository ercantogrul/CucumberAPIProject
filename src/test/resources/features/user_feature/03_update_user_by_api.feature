@End2End
Feature: Update User By Api

  @Update @Api
  Scenario: Update User Scenario

    Given set the url for patch request
    And set the expected data for patch request
    When send the patch request and get the response
    Then do assertion for patch request