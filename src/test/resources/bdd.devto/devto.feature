Feature: dev.to basic features
  Scenario: open first seen blog
    Given Chrome browser open
    When go to devto main page
    And click on first blog displayed
    Then should be redirected to blog page