Feature: verify search functionality

  Scenario: Verify Searching with existing Product
    Given User is on the home page
    When User Enters existing Product into the search box field
    And User clicks on search Button
    Then Product shoud be displayed in search results

  Scenario: Verify Searching with non existing Product
    Given User is on the home page
    When User Enters non existing Product into the search box field
    And User clicks on search Button
    Then Proper message shoud be displayed in search results
