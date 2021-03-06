Feature: basic calculator functions
  Scenario: adding two numbers
    Given I have a calculator
    When I add 2 and 3
    Then I should get 5
  Scenario: subtracting
    Given I have a calculator
    When subtract 5 from 8
    Then I should get 3
  Scenario: multiplying
    Given I have a calculator
    When I multiply 2 and 8
    Then I should get 16
  Scenario: division
    Given I have a calculator
    When I divide 6 by 2
    Then I should get 3