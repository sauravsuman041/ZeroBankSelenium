Feature: Verify the correctness of account details displayed

	Background:
		Given User should be logged in with "username" and "password"

  @accountSummaryPageLoading
  Scenario Outline: Account Summary Page Loads Correctly
    When User clicks on ONLINE BANKING and then clicks on Account Summary
    Then User should be redirected to the Account Summary page

  @validatingAccountTypes
  Scenario Outline: Validate Account Types
    Given User is on the Account Summary Page
    Then Checking is Displayed
    And Savings is Displayed
    And Credit Card is Displayed
    And Loan is Displayed