
Feature: Verify Login functionality

 
  Scenario: Verify login with valid Credentials
    Given User Navigates to Login Page
    When User enters Valid Email and valid password into the fields
    And Clicks on Login Button
    Then User shoud Get logged in Succesfully
    And User Shoud be taken to My Account page
    

		Scenario: Verify login with invalid Credentials
    Given User Navigates to Login Page
    When User enters inValid Email and invalid password into the fields
    And Clicks on Login Button
    Then User shoud not Get loggedin
    And User Shoud get a proper warning message
 
