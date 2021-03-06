Feature: dev.to basic features
  Scenario: open first seen blog
    Given go to devto main page
    When click on first blog displayed
    Then should be redirected to blog page