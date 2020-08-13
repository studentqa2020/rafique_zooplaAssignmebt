@Regression 
Feature: Zoopla Automation   feature testing
	Description : login and property test
	
@TS_000 
Scenario: As a user , end to end testing from login to property select and logout
	Given login
	When Property search
	And check price descinding order and select  5th  prperty
	And get logo ,agent name, Agent telephone
	Then  logout 
	