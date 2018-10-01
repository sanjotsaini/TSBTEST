Feature: Test the functionality on altoro mutual

#In this scenario I'm  check the that user is entering correct URL
Scenario: user should enter corret url
Given user is on web browser
When user enters the correct correct url
Then user gets confirmation


#In this scenario I'm checking user should alble to login when they are redirected to login page with correct username and password
Scenario: the user should be able to login with correct username and correct password
Given user is on login page
When user enters the correct usernbame and password
Then user gets confirmation1

#In this scenario I'm checking user should not able to login with worng password
Scenario: the user should be not able to login with correct username and wrong password
Given user is on login page1
When user enters the correct usernbame and wrong password
Then user gets confirmation11


#In this scenario I'm checking user should not able to login with worng username
Scenario: the user should be not able to login with wrong username and correct password
Given user is on login page2
When user enters the wrong usernbame and correct password
Then user gets confirmation12


#In this Scenario I'm check that user should able to transfer fund from one account to other by entering the amount
Scenario: transfer the funds
Given user is on transfer fund page
When selects the from account to account and enters amount
Then user gets confirmation2

#In this scenario I'm checking user should get error meassge
Scenario: transfer the funds
Given user is on transfer fund page1
When selects the from account to account and keeps amount blank
Then user gets confirmation21