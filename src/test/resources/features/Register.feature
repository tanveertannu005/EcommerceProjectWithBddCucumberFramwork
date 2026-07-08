Feature: Register Account Funtionality

  Scenario: User navigates to Register Page
    Given User navigates to Register page
    When User enters the below fields
      | firstName       | Tanveer     |
      | lastName        | Galagali    |
      | TelephoneNumber | 89965665522 |
      | Password        | admin       |
    And User Select Privacy Policy field
    And user clicks on Continue button
    Then User shoud get logged in
    And User Shoud be naviagated to Account Success page
    And Proper Details Shoud be displayed Account Success page
    When User Clicks on continue on Account Success page
    Then User Shoud be navigated to MyAccountpage
