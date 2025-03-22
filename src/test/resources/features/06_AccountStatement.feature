Feature: Verify that account statements can be downloaded.

  Background: 
    Given User should be logged in with "username" and "password"

	@accountStatement
  Scenario Outline: Download Account Statement
    When User navigates to the online statement section
    And selects an account "<Account>" and year <Year>
    And clicks on the pdf "<PDF>" to download
    Then the pdf "<PDF Name>" should be downloaded successfully

    Examples: 
      | Account | Year | PDF | PDF Name |  
      | Savings | 2010.0 | Statement 01/12/10(57K) | 8534567-05-12-11.pdf |  
