Feature: Register Account Funtionality

  Scenario: Verify Registering Account With Mandatory fields
    Given User navigates to Register page
    When User enters the below fields
      | firstName       | Tanveer     |
      | lastName        | Galagali    |
      | TelephoneNumber | 89965665522 |
      | Password        | admin       |
    And User Select Privacy Policy field
    And User clicks on Continue button
    Then User shoud get logged in
    And User Shoud be naviagated to Account Success page
    And Proper Details Shoud be displayed Account Success page
    When User Clicks on continue on Account Success page
    Then User Shoud be navigated to MyAccountpage

  Scenario: Verify Registering Account by filling all the fields
    Given User navigates to Register page
    When User enters the below fields
      | firstName       | Tanveer     |
      | lastName        | Galagali    |
      | TelephoneNumber | 89965665522 |
      | Password        | admin       |
    And User selects Yes option for the Newsletter
    And User Select Privacy Policy field
    And User clicks on Continue button
    Then User shoud get logged in
    And User Shoud be naviagated to Account Success page
