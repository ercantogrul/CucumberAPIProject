@End2End
Feature: End To End Test

@
  Scenario: Create User

    Given user goes to "https://thinking-tester-contact-list.herokuapp.com/"
    When user clicks on sing up button
    And user enters firstname
    And user enters lastname
    And user enters email
    And user enters password
    And user clicks on submit button
    Then validate logout button
    And close browser

  # herhangi bir adimda "" icinde bir veri tanimlarsak String bir parametre gönderir
  # herhangi bir adimda 123 seklinde bir veri tanimlarsak int bir parametre gönderir


