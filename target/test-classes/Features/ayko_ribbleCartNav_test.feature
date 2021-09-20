#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Check Cart Feautre

  Scenario: Cart Amount Verficiation
    Given URL for Ribble Bikes works
     Given Endurance SL e option is available under Road menu option
     Given User has navigated to Endurance SL e page
     When User clicks on Build your bike
     And User checks the size available
     And User Selects Medium Size Bike
     And User Clicks on Review and Buy
     And User Clicks on Buy This Build
     And User notes to price
     And User Clicks on HomePage
     And User navigates to Cart from Cart button
     Then The price should remain the same
     And User shuts down the browser