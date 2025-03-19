Feature: Login to Zero Bank

  @validlogin
  Scenario Outline: Successful Login
    Given User is on Zero Bank login page
    When User enters "<username>" and "<password>" and click on SignIn button
    Then User should be redirected to the Home page

    Examples: 
      | username  | password  |
      | username  | password  |

  @invalidlogin
  Scenario Outline: Invalid Credentials
    Given User is on Zero Bank login page
    When User enters "<username>" and "<password>" and click on SignIn button
    Then User should see error message "<message>"

    Examples: 
      | username  | password  | 						message 					 		|
      | Saurav123 | saurav123 | Login and/or password are wrong.	|

  @missingcredentials
  Scenario Outline: Missing Credentials
    Given User is on Zero Bank login page
    When User click on SignIn button without entering credentials
    Then User should see error message "<message>"

    Examples: 
      | 						message 							|
      | Login and/or password are wrong.	|
