Feature: Verify adding a new payee functionality.

  Background: 
    Given User should be logged in with "username" and "password"

  @succesfullAddingPayee
  Scenario Outline: Successfully Add a New Payee
    Given User navigate to Add New Payee Section.
    When User Enter the payee details "<Name>" "<Address>" <Account No.>
    And clicks the add button
    Then User can see the Payee added successfully "The new payee " "<Name>" " was successfully created."

    Examples: 
      | Name   | Address       | Account No. |
      | Saurav | Munger, Bihar |      123456 |

  @missingDetailAddingPayee
  Scenario Outline: Add Payee with Missing Details
    Given User navigate to Add New Payee Section.
    When User Enter the payee with missing details "<Address>" <Account No.>
    And clicks the add button
    Then User can see the error meesage "All fields are required."

    Examples: 
      | Address       | Account No. |
      | Munger, Bihar |      123456 |
