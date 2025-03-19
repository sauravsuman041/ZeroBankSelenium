Feature: Verify bill payment functionalities.

  Background: 
    Given User should be logged in with "username" and "password"

  @successfulPayment
  Scenario Outline: Successful Bill Payment
    Given User is on the Bill Payment Page
    When User selects the "<Payee>" Account and "<From Account>"
    And User enter a valid amount <amount> ,select a "<date>" and click pay
    Then User can see the payment successfull "<message>"

    Examples: 
      | Payee  | From Account | amount | date       | message                                 |
      | Sprint | Checking     |     10 | 2025-03-21 | The payment was successfully submitted. |
      | Apple  | Savings      |     10 | 2025-04-21 | The payment was successfully submitted. |

  @missingAmount
  Scenario Outline: Missing Amount Bill Payment
    Given User is on the Bill Payment Page
    When User selects the "<Payee>" Account and "<From Account>"
    And User select a "<date>" and click pay
    Then User can see the error "<message>"

    Examples: 
      | Payee  | From Account | date       | message                       |
      | Sprint | Checking     | 2025-03-21 | Amount field cannot be empty. |
