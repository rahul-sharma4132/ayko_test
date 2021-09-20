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
@smoke
Feature: Ribble Bike Checkout

  Scenario Outline: Check Ribble Endurance SL e Bike in Road Menu
    Given URL for Ribble Bikes works
    When User hover over the Road menu option
    Then User verify the Endurance SL e option is available
    And User shuts down the browser
    
   Scenario Outline: Check Ribble Endurance SL e  Bike Page Navgation
   	Given URL for Ribble Bikes works
    Given Endurance SL e option is available under Road menu option
    When User click on the ndurance SL e submenu option
    Then User verify the Endurance SL e option is  visible
    And User shuts down the browser
    
   Scenario Outline: Check Ribble Endurance SL e  count for color
   	Given URL for Ribble Bikes works
    Given Endurance SL e option is available under Road menu option
    Given User has navigated to Endurance SL e page
    When User has counted the number of black bikes
    And User clicks on White
    Then Count should change
    And User shuts down the browser
    
   Scenario Outline: Check Ribble Endurance SL e  Build your bike Navigation
   	Given URL for Ribble Bikes works
    Given Endurance SL e option is available under Road menu option
    Given User has navigated to Endurance SL e page
    When User clicks on Build your bike
    Then Build Your Bike webpage should appear
    And User shuts down the browser
    
   Scenario Outline: Check Your Bike Size
   	Given URL for Ribble Bikes works
    Given Endurance SL e option is available under Road menu option
    Given User has navigated to Endurance SL e page
    When User clicks on Build your bike
    And User checks the size available
    Then User should be able to see all sizes
    And User shuts down the browser
    
   Scenario Outline: Check Your Bike Customize button
   	Given URL for Ribble Bikes works
    Given Endurance SL e option is available under Road menu option
    Given User has navigated to Endurance SL e page
    When User clicks on Build your bike
    And User checks the size available
    And User Selects Medium Size Bike
    Then User should be able to see the Customize button
    And User shuts down the browser
    
    Scenario Outline: Check Your Bike Checkout button
   	 Given URL for Ribble Bikes works
     Given Endurance SL e option is available under Road menu option
     Given User has navigated to Endurance SL e page
     When User clicks on Build your bike
     And User checks the size available
     And User Selects Medium Size Bike
     Then User should be able to see the Checkout button
     And User shuts down the browser
    
    
    Scenario Outline: Check Your Bike Checkout Flow
   	 Given URL for Ribble Bikes works
     Given Endurance SL e option is available under Road menu option
     Given User has navigated to Endurance SL e page
     When User clicks on Build your bike
     And User checks the size available
     And User Selects Medium Size Bike
     And User Clicks on Review and Buy
     And User Clicks on Buy This Build
     Then User should be able to see the item in the card
     And User shuts down the browser
     
    Scenario Outline: Check Your Bike Customization & Checkout Flow
   	 Given URL for Ribble Bikes works
     Given Endurance SL e option is available under Road menu option
     Given User has navigated to Endurance SL e page
     When User clicks on Build your bike
     And User checks the size available
     And User Selects Medium Size Bike
     And User Clicks on Customize Bike button
     And User Clicks on Frame button
     And User changes size to Large
     And User Clicks on Customize Bike button
     And User Clicks on Style button
     And User Selects on Purple Blue style
     And User Clicks on Customize Bike button
     And User Clicks on Group Set
     And User Selects Shimano Ultegra Disc Groupset
     And User Clicks on Customize Bike button
     And User Clicks on GPS Mount
     And User Selects GPS Mount with Garmin Fitment
     And User Clicks on Review and Buy
     And User Clicks on Buy This Build
     Then User should be able to see the item in the card 
     And User shuts down the browser