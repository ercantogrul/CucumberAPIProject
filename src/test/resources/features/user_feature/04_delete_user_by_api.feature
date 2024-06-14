@End2End
Feature: Delete User By Api

  @Delete @Api
  Scenario: Delete Updeted User

    Given set the url for delete request
    When send the delete request and get the response
    Then do assertion for delete request
