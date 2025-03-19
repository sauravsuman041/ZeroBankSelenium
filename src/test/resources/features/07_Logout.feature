Feature: : Ensure users can log out securely.

  Background: 
    Given User should be logged in with "username" and "password"

	@logout
  Scenario: Logout Successfully
    When User clicks the logout button
    Then User is redirected to the home page "http://zero.webappsecurity.com/index.html"
    
	@sessionExpiry
  Scenario: Verify Session Expiry After Logout
    When User clicks the logout button
    And User tries to navigate the previous page by clicking the browser back button
    Then User is not able to access the previous page
