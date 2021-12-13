Feature: Game of the Brain
	As a player, I want to select a checker to a desired position
		
Scenario: Validate that when the player clicks a checker, the checker is highlighted
Given the player is on Checkers page
When the player clicks a checker
Then the checker is highlighted