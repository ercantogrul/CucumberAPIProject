@Contact
Feature: Patch Contact

  @PatchContact @Api
  Scenario: PatchUpdate Contact Scenario
    Given set the url for update contact
    And set the expected data for patch contact
    When send the patch request and get the response for patch contact
    Then do assertion for patch contact