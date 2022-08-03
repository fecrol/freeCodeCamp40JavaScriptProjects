Feature: Counter

Background:
  Given I am on the index page

Scenario: Pressing the INCREASE button increases the number
  When I click the "INCREASE" button
  Then The number is increased

Scenario: Pressing the DECREASE button decreases the number
  When I click the "DECREASE" button
  Then The number is decreased

Scenario: Pressing the RESET button resets number to zero
  Given I click the "INCREASE" button
  When I click the "RESET" button
  Then The number should be 0