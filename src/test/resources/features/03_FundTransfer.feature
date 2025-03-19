Feature: Verify that funds can be transferred between accounts.

  Background: 
    Given User should be logged in with "username" and "password"

  @successfulTransfer
  Scenario Outline: Successful Fund Transfer
    Given User is on the Fund Transfer Page
    When User selects "<From Account>" and "<To Account>"
    And User enter a valid amount <amount> and submit
    Then User can see the transfer successfull "<message>"

    Examples: 
      | From Account | To Account | amount | message                                      |
      | Brokerage    | Checking   |     10 | You successfully submitted your transaction. |

  @insufficientBalanceTransfer
  Scenario Outline: Fund Transfer with Insufficient Balance
    Given User is on the Fund Transfer Page
    When User selects "<From Account>" and "<To Account>"
    And Enter an amount <amount> greater than the available balance in From Account and submit
    Then Error "<message>" should be displayed

    Examples: 
      | From Account | To Account | amount | message               |
      | Brokerage    | Checking   |   5000 | Insufficient Balance. |

  @negativeAmountTransfer
  Scenario Outline: Fund Transfer with Negative Amount
    Given User is on the Fund Transfer Page
    When User selects "<From Account>" and "<To Account>"
    And Enter a negative value in the amount <amount> field and submit
    Then Error "<message>" should be displayed

    Examples: 
      | From Account | To Account | amount | message         |
      | Brokerage    | Checking   |   -200 | Invalid Amount. |
